package orangeboat.poker_ai.Panels;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.MediaPlayer;

import java.util.ArrayList;

/**
 * Created by jawpa on 12/6/2016.
 */
public class TablePanel {
    ArrayList<Bitmap> imgloader = new ArrayList<>();
    ArrayList<MediaPlayer> sfxloader = new ArrayList<>();

    public Rect rectPause;

    public boolean gameEnded;

    public int money;
    public void setMoney(int money) {this.money = money;}

    public TablePanel(){

    }
    public void load(){

    }
    public void update(){

    }
    public void draw(Canvas canvas){

    }
    public void imgLoad(Bitmap image) {imgloader.add(image);}
    public void sfxLoad(MediaPlayer sfx){ sfxloader.add(sfx);}
    public void downTouch(int x, int y, int pointerNumber) {

    }
    public void upTouch(int x, int y,int pointerNumber) {

    }
}