package orangeboat.poker_ai;

import android.content.Context;

import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import orangeboat.poker_ai.Input.IMG;
import orangeboat.poker_ai.Input.SFX;
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

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
