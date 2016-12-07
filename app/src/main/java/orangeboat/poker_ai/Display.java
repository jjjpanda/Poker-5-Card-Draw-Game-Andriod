package orangeboat.poker_ai;

import android.content.Context;

import android.graphics.Canvas;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import orangeboat.poker_ai.Input.IMG;
import orangeboat.poker_ai.Input.SFX;
import orangeboat.poker_ai.Input.Touch;
import orangeboat.poker_ai.Panels.PausePanel;
import orangeboat.poker_ai.Panels.TablePanel;
import orangeboat.poker_ai.Panels.TitlePanel;
import orangeboat.poker_ai.Threads.MainThread;

/**
 * Created by jawpa on 12/6/2016.
 */
public class Display extends SurfaceView implements SurfaceHolder.Callback{
    SurfaceHolder contextHolder;
    MainThread mainThread;
    public static DisplayMetrics device;
    IMG imgloader;
    SFX sfxloader;
    TablePanel tablePanel;
    TitlePanel titlePanel;
    PausePanel pausePanel;
    int panelSwitch = 0;
    Touch touch;
    public Display(Context context, DisplayMetrics m){
        super(context);
        getHolder().addCallback(this);
        contextHolder = getHolder();
        mainThread = new MainThread(getHolder(), this);

        device = m;

        titlePanel = new TitlePanel();
        tablePanel = new TablePanel(context);
        pausePanel = new PausePanel();
        imgloader = new IMG(getResources(), device, tablePanel, titlePanel, pausePanel);
        sfxloader = new SFX();
    }
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        titlePanel.load();
        tablePanel.load();
        pausePanel.load();
        Thread.State state = mainThread.getState();
        if(state == Thread.State.TERMINATED){
            newThread();
        }
        mainThread.setRunning(true);
        mainThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                mainThread.setRunning(false);
                mainThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }
    public boolean onTouchEvent(MotionEvent event) {
        touch = new Touch(event);
        if (panelSwitch == 0) {
            touch.checkTitle(titlePanel);
            touch.toGameToggleInfo(tablePanel,pausePanel);
            if (touch.switcher) {
                panelSwitch = 1;
                touch.switcher = false;
            }
        }
        if (panelSwitch == 1) {
            touch.checkGame(tablePanel);
            touch.toGameToggleInfo(tablePanel, pausePanel);
            if (touch.switcher) {
                panelSwitch = 2;
                touch.switcher = false;
            }
        }
        if(panelSwitch == 2) {
            touch.checkPause(pausePanel, tablePanel);
            touch.toGameToggleInfo(tablePanel, pausePanel);
            if (touch.switcher) {
                panelSwitch = 1;
                touch.switcher = false;
            }
        }
        return true;
    }
    public void update()
    {
        if(tablePanel.gameEnded){
            panelSwitch = 0;
            tablePanel.load();
        }
        if(panelSwitch == 0)
            titlePanel.update();
        else if(panelSwitch == 1) {
            tablePanel.update();
        }

    }
    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        if(panelSwitch == 0)
        {
            titlePanel.draw(canvas);
        }
        else if(panelSwitch == 1) {
            tablePanel.draw(canvas);
        }
        else if(panelSwitch == 2){
            pausePanel.draw(canvas);
        }
    }
    public void newThread() {
        mainThread = new MainThread(contextHolder, this);
    }

}
