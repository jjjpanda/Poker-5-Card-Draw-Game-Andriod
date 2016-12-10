package orangeboat.poker_ai.Panels;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.annotation.ArrayRes;

import java.util.ArrayList;
import java.util.Random;

import orangeboat.poker_ai.Display;
import orangeboat.poker_ai.Players.AI;
import orangeboat.poker_ai.Players.Fish;
import orangeboat.poker_ai.Players.Normal;
import orangeboat.poker_ai.Players.Smart;
import orangeboat.poker_ai.Players.Stupid;

/**
 * Created by jawpa on 12/6/2016.
 */
public class TablePanel {

    Paint paint = new Paint();
    public int counter;

    Random rand = new Random(System.currentTimeMillis());
    Vibrator v;
    ArrayList<Bitmap> imgloader = new ArrayList<>();
    ArrayList<Bitmap> cardloader = new ArrayList<>(); //C 0-12, H 13-25, S 26-38,  D 39-51 , A-K
    ArrayList<MediaPlayer> sfxloader = new ArrayList<>();
    ArrayList<Integer> cardsDealt = new ArrayList<>();

    public Bitmap pauseButton;
    private int px, py, pausebuttonX, pausebuttonY;
    public Rect rectPause;

    public int flopx, turnx, riverx, communityHeight, pocketHeight, cardwidth, pocket1, pocket2;
    public int flop1, flop2, flop3, turn, river;
    public int card1, card2;
    public int temp;
    public boolean gameEnded;

    public int deviceWidth, deviceHeight;

    public int money;
    public void setMoney(int money) {this.money = money;}

    public int gameRound; //0- preflop, 1- flop, 2-turn, 3- river
    public int dealerPosition; //0- user, 1- AI to the left, and so on.

    public boolean playersFinished, bettingFinished, blindsFininshed = false;
    public AI player1, player2, player3, player4;
    public AI players[] = new AI[4];

    public TablePanel(Context context){
        v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
    }
    public void load(){
        paint.setColor(Color.WHITE);
        paint.setTextSize(100f);
        counter = 0;

        card1 = 52;
        card2 = 52;
        flop1 = 52;
        flop2 = 52;
        flop3 = 52;
        turn = 52;
        river = 52;
        cardsDealt.clear();
        gameRound = 0;
        blindsFininshed = false;

        deviceHeight = Display.device.heightPixels;
        deviceWidth = Display.device.widthPixels;
        gameEnded = false;

        player1 = new Normal();
        player2 = new Stupid();
        player3 = new Fish();
        player4 = new Smart();

        pauseButton = imgloader.get(0);

        pausebuttonX = pauseButton.getWidth();
        pausebuttonY = pauseButton.getHeight();
        px = (int) (deviceWidth-pausebuttonX);
        py = 0;
        rectPause = new Rect( px, py, px+pausebuttonX, py +pausebuttonY);
        cardwidth = cardloader.get(0).getWidth();
        pocketHeight = (int) (deviceHeight/1.3);
        pocket1 =  deviceWidth/2;
        pocket2 =  deviceWidth/2 - cardwidth;
        communityHeight = deviceHeight/13;
        flopx = deviceWidth/2-cardwidth*5/2;
        turnx = deviceWidth/2+ cardwidth/2;
        riverx = deviceWidth/2+ cardwidth*3/2;
        dealerPosition = rand.nextInt(6); // 0 to 5
        gameRound = 0;
    }
    public void update(){
        if(player1.finished){
            playersFinished = true;
        }
        else playersFinished = false;
        counter++;
        if(counter % 30 == 0){
           //v.vibrate(150);
        }

        if (gameRound == 0) {
            if(!blindsFininshed){
                card1= deal();
                card2 = deal();
                blinds();
                blindsFininshed = true;
            }
            if(!bettingFinished) {
                betting(gameRound);
                if(playersFinished){
                    bettingFinished = true;
                }
            }
            if(bettingFinished) {
                flop1 = deal();
                flop2 = deal();
                flop3 = deal();
                player1.finished = false;
                //preflop
                bettingFinished = false;
                gameRound++;
            }
        }
        else if( gameRound == 1){
            //flop
            if(!bettingFinished){
                betting(gameRound);
                if(playersFinished){
                    bettingFinished = true;
                }
            }
            if(bettingFinished){
                turn = deal();
                bettingFinished = false;
                gameRound++;
            }
        }
        else if( gameRound == 2){
            //turn
            if(!bettingFinished){
                betting(gameRound);
                if(playersFinished){
                    bettingFinished = true;
                }
            }
            if(bettingFinished){
                river = deal();
                bettingFinished = false;
                gameRound++;
            }
        }
        else if( gameRound == 3){
            //river
            if(!bettingFinished){
                betting(gameRound);
                if(playersFinished){
                    bettingFinished = true;
                }
            }
            if(bettingFinished) {
                //determine winnner
                bettingFinished = false;
                card1 = 52;
                card2 = 52;

                flop1 = 52;
                flop2 = 52;
                flop3 = 52;
                turn = 52;
                river = 52;
                cardsDealt.clear();
                gameRound = 0;
                blindsFininshed = false;

                dealerPosition++;
                if (dealerPosition == 4) {
                    dealerPosition = 0;
                }
            }
        }
    }
    public void draw(Canvas canvas){
        canvas.drawText(""+counter, 100,100,paint);
        canvas.drawText("Game Screen" , 200,300,paint);
        canvas.drawBitmap(pauseButton, px, py, null);
        if (gameRound == 0) {
            //preflop
            canvas.drawBitmap(cardloader.get(card1), pocket1, pocketHeight, null);
            canvas.drawBitmap(cardloader.get(card2), pocket2, pocketHeight, null);
        }
        else if( gameRound == 1){
            canvas.drawBitmap(cardloader.get(flop1), flopx, communityHeight, null);
            canvas.drawBitmap(cardloader.get(flop2), flopx+cardwidth, communityHeight, null);
            canvas.drawBitmap(cardloader.get(flop3), flopx+cardwidth*2, communityHeight, null);
            canvas.drawBitmap(cardloader.get(card1), pocket1, pocketHeight, null);
            canvas.drawBitmap(cardloader.get(card2), pocket2, pocketHeight, null);
            //flop
        }
        else if( gameRound == 2){
            canvas.drawBitmap(cardloader.get(flop1), flopx, communityHeight, null);
            canvas.drawBitmap(cardloader.get(flop2), flopx+cardwidth, communityHeight, null);
            canvas.drawBitmap(cardloader.get(flop3), flopx+cardwidth*2, communityHeight, null);
            canvas.drawBitmap(cardloader.get(turn), turnx, communityHeight, null);
            canvas.drawBitmap(cardloader.get(card1), pocket1, pocketHeight, null);
            canvas.drawBitmap(cardloader.get(card2), pocket2, pocketHeight, null);
            //turn
        }
        else if( gameRound == 3){
            canvas.drawBitmap(cardloader.get(flop1), flopx, communityHeight, null);
            canvas.drawBitmap(cardloader.get(flop2), flopx+cardwidth, communityHeight, null);
            canvas.drawBitmap(cardloader.get(flop3), flopx+cardwidth*2, communityHeight, null);
            canvas.drawBitmap(cardloader.get(turn), turnx, communityHeight, null);
            canvas.drawBitmap(cardloader.get(river), riverx, communityHeight, null);
            canvas.drawBitmap(cardloader.get(card1), pocket1, pocketHeight, null);
            canvas.drawBitmap(cardloader.get(card2), pocket2, pocketHeight, null);
            //river
        }
    }
    public int deal(){
        int temp = rand.nextInt(52);
        for (Integer dealt : cardsDealt){
            if (dealt == temp){
                temp = rand.nextInt(52);
            }
        }
        cardsDealt.add(temp);
        return temp;
    }
    public void takeBigBlind(){
        money--;
        money--;
    }
    public void takeSmallBlind(){
        money--;
    }
    public void blinds(){
        switch(dealerPosition){
            case 0:
                player1.takeSmallBlind();
                player2.takeBigBlind();
                break;
            case 1:
                player2.takeSmallBlind();
                player3.takeBigBlind();
                break;
            case 2:
                player3.takeSmallBlind();
                player4.takeBigBlind();
                break;
            case 3:
                player4.takeSmallBlind();
                takeBigBlind();
                break;
            case 4:
                takeSmallBlind();
                player1.takeBigBlind();
                break;
        }
    }
    public void betting(int gameRound){
        if(gameRound == 0) {
            switch (dealerPosition) {
                case 0:
                    player3.update(gameRound, 0);
                    player4.update(gameRound, 0);
                    //user input
                    player1.update(gameRound, 0);
                    player2.update(gameRound, 0);
                    break;
                case 1:
                    player4.update(gameRound, 0);
                    //user input
                    player1.update(gameRound, 0);
                    player2.update(gameRound, 0);
                    player3.update(gameRound, 0);
                    break;
                case 2:
                    //user input
                    player1.update(gameRound, 0);
                    player2.update(gameRound, 0);
                    player3.update(gameRound, 0);
                    player4.update(gameRound, 0);
                    break;
                case 3:
                    player1.update(gameRound, 0);
                    player2.update(gameRound, 0);
                    player3.update(gameRound, 0);
                    player4.update(gameRound, 0);
                    //user input
                    break;
                case 4:
                    player2.update(gameRound, 0);
                    player3.update(gameRound, 0);
                    player4.update(gameRound, 0);
                    //user input
                    player1.update(gameRound, 0);
                    break;
            }
        }
        else{
            switch (dealerPosition) {
                case 0:
                    player1.update(gameRound, 0);
                    player2.update(gameRound, 0);
                    player3.update(gameRound, 0);
                    player4.update(gameRound, 0);
                    //user input
                    break;
                case 1:
                    player2.update(gameRound, 0);
                    player3.update(gameRound, 0);
                    player4.update(gameRound, 0);
                    //user input
                    player1.update(gameRound, 0);
                    break;
                case 2:
                    player3.update(gameRound, 0);
                    player4.update(gameRound, 0);
                    //user input
                    player1.update(gameRound, 0);
                    player2.update(gameRound, 0);
                    break;
                case 3:
                    player4.update(gameRound, 0);
                    //user input
                    player1.update(gameRound, 0);
                    player2.update(gameRound, 0);
                    player3.update(gameRound, 0);
                    break;
                case 4:
                    //user input
                    player1.update(gameRound, 0);
                    player2.update(gameRound, 0);
                    player3.update(gameRound, 0);
                    player4.update(gameRound, 0);
                    break;
            }
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