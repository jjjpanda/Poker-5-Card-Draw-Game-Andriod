package orangeboat.poker_ai;

import android.content.Context;

import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import orangeboat.poker_ai.Input.IMG;
import orangeboat.poker_ai.Input.SFX;
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
    public Display(Context context, DisplayMetrics m){
        super(context);
        getHolder().addCallback(this);
        contextHolder = getHolder();
        mainThread = new MainThread(getHolder(), this);

        device = m;
        imgloader = new IMG();
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
    public void update()
    {
        if(panelSwitch == 0)
            titlePanel.update();
        else if(panelSwitch == 1) {
            tablePanel.update();
        }
        if(tablePanel.gameEnded){
            panelSwitch = 2;
        }
    }
    public void newThread() {
        mainThread = new MainThread(contextHolder, this);
    }

}
