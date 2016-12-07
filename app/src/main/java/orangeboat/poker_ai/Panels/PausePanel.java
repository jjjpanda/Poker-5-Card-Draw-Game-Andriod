package orangeboat.poker_ai.Panels;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.MediaPlayer;

import java.util.ArrayList;

/**
 * Created by jawpa on 12/6/2016.
 */
public class PausePanel {
    ArrayList<Bitmap> imgloader = new ArrayList<>();
    ArrayList<MediaPlayer> sfxloader = new ArrayList<>();
    Bitmap resumeButton, title, wallet, numOfPlayers;
    public Rect rectResume;

    public PausePanel(){

    }
    public void load(){

    }
    public void draw(Canvas canvas) {

    }
    public void imgLoad(Bitmap image) {imgloader.add(image);}
    public void sfxLoad(MediaPlayer sfx){ sfxloader.add(sfx);}
}
