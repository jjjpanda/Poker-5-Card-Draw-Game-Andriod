package orangeboat.poker_ai.Panels;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.MediaPlayer;

import java.util.ArrayList;

/**
 * Created by jawpa on 12/6/2016.
 */
public class TitlePanel {
    ArrayList<Bitmap> imgloader = new ArrayList<>();
    ArrayList<MediaPlayer> sfxloader = new ArrayList<>();
    Bitmap playButton, title, wallet;
    public Rect rectPlay;


    public TitlePanel(){

    }
    public void load(){

    }
    public void update(){

    }
    public void draw(Canvas canvas) {
        canvas.drawBitmap(imgloader.get(0),0,0,null);
    }
    public void imgLoad(Bitmap image) {imgloader.add(image);}
    public void sfxLoad(MediaPlayer sfx){ sfxloader.add(sfx);}
}
