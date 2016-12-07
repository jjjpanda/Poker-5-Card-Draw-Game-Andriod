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
public class TitlePanel {

    Paint paint = new Paint();

    ArrayList<Bitmap> imgloader = new ArrayList<>();
    ArrayList<MediaPlayer> sfxloader = new ArrayList<>();
    Bitmap playButton, title, wallet;
    private int x, y, playbuttonX, playbuttonY;
    public Rect rectPlay;

    public TitlePanel(){

    }
    public void load(){

        paint.setColor(Color.WHITE);
        paint.setTextSize(100f);

        this.playButton = imgloader.get(0);

        playbuttonX = playButton.getWidth();
        playbuttonY = playButton.getHeight();
        x = (int) (Display.device.widthPixels/2);
        y = (int) ( Display.device.heightPixels/1.3);

        rectPlay = new Rect( x, y, x+playbuttonX, y+playbuttonY);

    }
    public void update(){

    }
    public void draw(Canvas canvas) {
        canvas.drawText("Title", 100, 100, paint);
        canvas.drawBitmap(playButton,x,y,null);
    }
    public void imgLoad(Bitmap image) {imgloader.add(image);}
    public void sfxLoad(MediaPlayer sfx){ sfxloader.add(sfx);}
}
