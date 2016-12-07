package orangeboat.poker_ai.Input;

import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;

import orangeboat.poker_ai.Panels.PausePanel;
import orangeboat.poker_ai.Panels.TablePanel;
import orangeboat.poker_ai.Panels.TitlePanel;

/**
 * Created by jawpa on 12/6/2016.
 */
public class Touch {
    public boolean switcher = false;
    MotionEvent event;
    int x, y;
    int pointerCount;
    public int touchtriggerOn = 0;
    public Touch(MotionEvent event) {
        this.event = event;
        pointerCount = event.getPointerCount();
        if (pointerCount >= 2) {
            x = (int) event.getX(event.getPointerId(event.getActionIndex()));
            y = (int) event.getY(event.getPointerId(event.getActionIndex()));
        } else {
            x = (int) event.getX();
            y = (int) event.getY();
        }
    }
    public void checkTitle(TitlePanel title) {
        int action = MotionEventCompat.getActionMasked(event);
        if (MotionEvent.ACTION_DOWN == action) {
            System.out.println(x + " " + y);
            if (title.rectPlay.contains(x, y)) {
                System.out.println("Play button pressed");
                switcher = true;
            }
            else if(title.rectToggle.contains(x,y)){
                System.out.println("TOGGLED");
                if(title.touchOn){
                    title.touchOn = false;
                    touchtriggerOn = 1;
                }
                else{
                    title.touchOn = true;
                    touchtriggerOn = 2;
                }
            }
        }
    }
    public void toGameToggleInfo(TablePanel tablePanel, PausePanel pausePanel){
        if(touchtriggerOn == 2) {
            tablePanel.touchOn = 2;
            pausePanel.toggle = 2;
        }
        if(touchtriggerOn == 1){
            tablePanel.touchOn = 1;
            pausePanel.toggle = 1;
        }
    }
    public void checkPause(PausePanel pausePanel){
        int action = MotionEventCompat.getActionMasked(event);
        if (MotionEvent.ACTION_DOWN == action) {
            System.out.println(x + " " + y);
            if (pausePanel.rectResume.contains(x, y)) {
                switcher = true;
            }
            else if(pausePanel.rectToggle.contains(x,y)){
                System.out.println("TOGGLED");
                if(pausePanel.toggle == 2){
                    pausePanel.toggle = 1;
                    touchtriggerOn = 1;
                }
                else{
                    pausePanel.toggle = 2;
                    touchtriggerOn = 2;
                }
            }
        }
    }
    public void checkGame(TablePanel tablePanel) {
        int action = MotionEventCompat.getActionMasked(event);
        // FIRST TOUCH
        if (MotionEvent.ACTION_DOWN == action) {
            if (tablePanel.pause.contains(x, y)) {
                switcher = true;
            }
            tablePanel.downTouch(x, y, event.getPointerId(event.getActionIndex()));
            //  System.out.println(x+ " is the x coordinate " + y + " is the y coordinate");
        }
        if(MotionEvent.ACTION_UP == action)
        {
            tablePanel.upTouch(x, y, event.getPointerId(event.getActionIndex()));
        }

        // SECOND TOUCH
        if(MotionEvent.ACTION_POINTER_DOWN == action)
        {
            if (tablePanel.pause.contains(x, y)) {
                switcher = true;
            }
            tablePanel.downTouch(x, y, event.getPointerId(event.getActionIndex()));
        }
        if(MotionEvent.ACTION_POINTER_UP == action) {
            tablePanel.upTouch(x, y, event.getPointerId(event.getActionIndex()));
        }
        if(MotionEvent.ACTION_MOVE == action)
        {
            int pointerCount = event.getPointerCount();
            for(int i = 0; i < pointerCount; ++i) {

                x = (int)event.getX(i);
                y = (int)event.getY(i);
                tablePanel.downTouch(x,y,event.getPointerId(i));
            }
        }
    }
}
