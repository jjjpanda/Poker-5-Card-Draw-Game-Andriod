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
    ArrayList<Bitmap> cardloader = new ArrayList<>();
    ArrayList<MediaPlayer> sfxloader = new ArrayList<>();

    public Bitmap pauseButton;
    private int px, py, pausebuttonX, pausebuttonY;
    public Rect rectPause;

    public int flopx, turnx, riverx, communityHeight, cardwidth;
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

        pausebuttonX = pauseButton.getWidth();
        pausebuttonY = pauseButton.getHeight();
        px = (int) (Display.device.widthPixels-pausebuttonX);
        py = 0;
        rectPause = new Rect( px, py, px+pausebuttonX, py +pausebuttonY);
        cardwidth = cardloader.get(0).getWidth();
        communityHeight = Display.device.heightPixels/10;
        flopx = Display.device.widthPixels/2-cardwidth*5/2;
        turnx = Display.device.widthPixels/2+ cardwidth/2;
        riverx = Display.device.widthPixels/2+ cardwidth*3/2;
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
        canvas.drawBitmap(pauseButton, px, py, null);
        if (gameRound == 0) {
            //preflop
        }
        else if( gameRound == 1){
            canvas.drawBitmap(cardloader.get(0), flopx, communityHeight, null);
            canvas.drawBitmap(cardloader.get(0), flopx+cardwidth, communityHeight, null);
            canvas.drawBitmap(cardloader.get(0), flopx+cardwidth*2, communityHeight, null);
            //flop
        }
        else if( gameRound == 2){
            canvas.drawBitmap(cardloader.get(0), flopx, communityHeight, null);
            canvas.drawBitmap(cardloader.get(0), flopx+cardwidth, communityHeight, null);
            canvas.drawBitmap(cardloader.get(0), flopx+cardwidth*2, communityHeight, null);
            canvas.drawBitmap(cardloader.get(0), turnx, communityHeight, null);
            //turn
        }
        else if( gameRound == 3){
            canvas.drawBitmap(cardloader.get(0), flopx, communityHeight, null);
            canvas.drawBitmap(cardloader.get(0), flopx+cardwidth, communityHeight, null);
            canvas.drawBitmap(cardloader.get(0), flopx+cardwidth*2, communityHeight, null);
            canvas.drawBitmap(cardloader.get(0), turnx, communityHeight, null);
            canvas.drawBitmap(cardloader.get(0), riverx, communityHeight, null);
            //river
        }
    }
    public void imgLoad(Bitmap image) {imgloader.add(image);}
    public void cardLoad(Bitmap image) {cardloader.add(image);}
    public void sfxLoad(MediaPlayer sfx){ sfxloader.add(sfx);}
    public void downTouch(int x, int y, int pointerNumber) {

    }
    public void upTouch(int x, int y,int pointerNumber) {

    }
}