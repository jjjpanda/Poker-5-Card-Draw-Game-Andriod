package orangeboat.poker_ai.Panels;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.os.Vibrator;

import java.util.ArrayList;

import orangeboat.poker_ai.Display;

/**
 * Created by jawpa on 12/6/2016.
 */
public class TablePanel {

    Paint paint = new Paint();
    public int counter;

    Vibrator v;
    ArrayList<Bitmap> imgloader = new ArrayList<>();
    ArrayList<MediaPlayer> sfxloader = new ArrayList<>();

    public Bitmap pauseButton;
    private int x, y, pausebuttonX, pausebuttonY;
    public Rect rectPause;

    public boolean gameEnded;

    public int money;
    public void setMoney(int money) {this.money = money;}

    public int gameRound; //0- preflop, 1- flop, 2-turn, 3- river
    public int dealerPosition; //0- user, 1- AI to the left, and so on.

    public TablePanel(Context context){
        v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
    }
    public void load(){
        paint.setColor(Color.WHITE);
        paint.setTextSize(100f);
        counter = 0;

        gameEnded = false;

        pauseButton = imgloader.get(0);
        x = (int) (Display.device.widthPixels/2);
        y = (int) ( Display.device.heightPixels/3);
        pausebuttonX = pauseButton.getWidth();
        pausebuttonY = pauseButton.getHeight();
        rectPause = new Rect( x, y, x+pausebuttonX, y+pausebuttonY);

        dealerPosition = (int)(Math.random() * 6); // 0 to 5
        gameRound = 0;
    }
    public void update(){
        counter++;
        if(counter % 30 == 0){
            v.vibrate(150);
        }
        if (gameRound == 0) {
            //preflop
            gameRound++;
        }
        else if( gameRound == 1){
            //flop
            gameRound++;
        }
        else if( gameRound == 2){
            //turn
            gameRound++;
        }
        else if( gameRound == 3){
            //river
            gameRound = 0;
        }
    }
    public void draw(Canvas canvas){
        canvas.drawText(""+counter, 100,100,paint);
        canvas.drawText("Game Screen" , 200,300,paint);
        canvas.drawBitmap(pauseButton, x, y, null);
    }
    public void imgLoad(Bitmap image) {imgloader.add(image);}
    public void sfxLoad(MediaPlayer sfx){ sfxloader.add(sfx);}
    public void downTouch(int x, int y, int pointerNumber) {

    }
    public void upTouch(int x, int y,int pointerNumber) {

    }
}