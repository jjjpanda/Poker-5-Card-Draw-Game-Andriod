package orangeboat.poker_ai.Panels;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;

import java.util.ArrayList;

import orangeboat.poker_ai.Display;

/**
 * Created by jawpa on 12/6/2016.
 */
public class PausePanel {

    Paint paint = new Paint();

    ArrayList<Bitmap> imgloader = new ArrayList<>();
    ArrayList<MediaPlayer> sfxloader = new ArrayList<>();
    Bitmap resumeButton, quitButton, wallet, numOfPlayers;
    private int rx, ry, resumebuttonX, resumebuttonY;
    private int qx, qy, quitbuttonX, quitbuttonY;
    public Rect rectResume, rectQuit;

    public PausePanel(){

    }
    public void load(){
        paint.setColor(Color.WHITE);
        paint.setTextSize(100f);

        resumeButton = imgloader.get(0);
        rx = (int) (Display.device.widthPixels/4);
        ry = (int) ( Display.device.heightPixels/1.3);
        resumebuttonX = resumeButton.getWidth();
        resumebuttonY = resumeButton.getHeight();
        rectResume = new Rect(rx, ry, rx +resumebuttonX, ry+resumebuttonY);

        quitButton = imgloader.get(1);
        qx = (int) (Display.device.widthPixels/1.5);
        qy = (int) ( Display.device.heightPixels/1.9);
        quitbuttonX = quitButton.getWidth();
        quitbuttonY = quitButton.getHeight();
        rectQuit = new Rect(qx, qy, qx+quitbuttonX, qy+quitbuttonY);
    }
    public void draw(Canvas canvas) {

        canvas.drawText("Pause Screen", 100,100, paint);

        canvas.drawBitmap(resumeButton, rx,ry, null);
        canvas.drawBitmap(quitButton,qx,qy,null);
    }
    public void imgLoad(Bitmap image) {imgloader.add(image);}
    public void sfxLoad(MediaPlayer sfx){ sfxloader.add(sfx);}
}
