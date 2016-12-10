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

    Random rand = new Random(System.currentTimeMillis());
    Vibrator v;
    ArrayList<Bitmap> imgloader = new ArrayList<>();
    ArrayList<Bitmap> cardloader = new ArrayList<>(); //C 0-12, H 13-25, S 26-38,  D 39-51 , A-K
    ArrayList<MediaPlayer> sfxloader = new ArrayList<>();
    ArrayList<Integer> cardsDealt = new ArrayList<>();

    public Bitmap pauseButton;
    private int px, py, pausebuttonX, pausebuttonY;
    public Rect rectPause;

    private int cx, cy, cRadius;
    public Rect rectCheckmark, rectWhite, rectRed, rectBlue, rectGreen, rectBlack, rectX;

    private int bx, by, buttonX, buttonY;
    public Rect rectCheck, rectCall, rectBet, rectRaise, rectFold;

    public int flopx, turnx, riverx, communityHeight, pocketHeight, cardwidth, pocket1, pocket2;
    public int flop1, flop2, flop3, turn, river;
    public int card1, card2;
    public int temp;
    public boolean gameEnded;

    public boolean chipUIShown;

    public int deviceWidth, deviceHeight;

    public int money, pot, forwardBet, bigblind;
    public void setMoney(int money) {this.money = money;}

    public int gameRound; //0- preflop, 1- flop, 2-turn, 3- river
    public int dealerPosition; //0- user, 1- AI to the left, and so on.

    public boolean playersFinished, bettingFinished, blindsFininshed;

    public AI player1, player2, player3, player4;
    public AI players[] = new AI[4];

    public TablePanel(Context context){
        v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
    }
    public void load(){
        if(money <= 100){
            money = 1000;
        }
        bigblind = ( money - (money%100) ) / 100;
        paint.setColor(Color.WHITE);
        paint.setTextSize(100f);

        card1 = 52;
        card2 = 52;
        flop1 = 52;
        flop2 = 52;
        flop3 = 52;
        turn = 52;
        river = 52;
        cardsDealt.clear();
        gameRound = 0;

        deviceHeight = Display.device.heightPixels;
        deviceWidth = Display.device.widthPixels;
        gameEnded = false;

        chipUIShown = true;

        player1 = new Normal();
        player2 = new Stupid();
        player3 = new Fish();
        player4 = new Smart();

        playersFinished = false;
        bettingFinished = false;
        blindsFininshed = false;

        pauseButton = imgloader.get(0);

        pausebuttonX = pauseButton.getWidth();
        pausebuttonY = pauseButton.getHeight();
        px = (int) (deviceWidth-pausebuttonX);
        py = 0;
        rectPause = new Rect( px, py, px+pausebuttonX, py +pausebuttonY);

        cRadius = imgloader.get(1).getWidth();
        cx = cRadius;
        cy = deviceHeight - 14*cRadius;
        rectCheckmark = new Rect(cx, cy, cx+cRadius, cy+cRadius);
        rectWhite = new Rect(cx, cy+cRadius*2, cx+cRadius, cy+cRadius*3);
        rectRed = new Rect(cx, cy+cRadius*4, cx+cRadius, cy+cRadius*5);
        rectBlue = new Rect(cx, cy+cRadius*6, cx+cRadius, cy+cRadius*7);
        rectGreen = new Rect(cx, cy+cRadius*8, cx+cRadius, cy+cRadius*9);
        rectBlack = new Rect(cx, cy+cRadius*10, cx+cRadius, cy+cRadius*11);
        rectX = new Rect(cx, cy+cRadius*12, cx+cRadius, cy+cRadius*13);

        buttonX = imgloader.get(6).getWidth();
        buttonY = imgloader.get(6).getHeight();
        bx = deviceWidth-buttonX;
        by = deviceHeight-buttonY*10;
        rectCheck = new Rect(bx, by, bx+buttonX, by+buttonY);
        rectBet = new Rect( bx, by+buttonY*2, bx+buttonX, by+buttonY*3);
        rectBet = rectCall;
        rectRaise = new Rect(bx, by+buttonY*4, bx+buttonX, by+buttonY*5);
        rectFold = new Rect(bx, by+buttonY*6, bx+buttonX, by+buttonY*7);

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
        if(player1.finished && player2.finished && player3.finished && player4.finished){
            playersFinished = true;
        }
        else playersFinished = false;

        money--;

        if (gameRound == 0) {
            if (!blindsFininshed) {
                card1 = deal();
                card2 = deal();
                blinds();
            }
            if (!bettingFinished) {
                betting(gameRound);
                if(playersFinished){
                    bettingFinished = true;
                    player1.finished = false;
                    player2.finished = false;
                    player3.finished = false;
                    player4.finished = false;
                }
            }
            if (bettingFinished) {
                flop1 = deal();
                flop2 = deal();
                flop3 = deal();
                gameRound++;
                bettingFinished = false;
            }
        }
        else if( gameRound == 1){
            //flop
            if(!bettingFinished){
                betting(gameRound);
                if(playersFinished){
                    bettingFinished = true;
                    player1.finished = false;
                    player2.finished = false;
                    player3.finished = false;
                    player4.finished = false;
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
                    player1.finished = false;
                    player2.finished = false;
                    player3.finished = false;
                    player4.finished = false;
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
                    player1.finished = false;
                    player2.finished = false;
                    player3.finished = false;
                    player4.finished = false;
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
        if(money <= 0){
            gameEnded = true;
        }
    }
    public void draw(Canvas canvas){
        canvas.drawText(""+money, 100,100,paint);
        canvas.drawText(""+pot , 200,700,paint);
        canvas.drawBitmap(pauseButton, px, py, null);
        if(chipUIShown){

            canvas.drawBitmap(imgloader.get(11), cx, cy, null);
            canvas.drawBitmap(imgloader.get(1), cx, cy + cRadius*2, null);
            canvas.drawBitmap(imgloader.get(2), cx, cy + cRadius*4, null);
            canvas.drawBitmap(imgloader.get(3), cx, cy + cRadius*6, null);
            canvas.drawBitmap(imgloader.get(4), cx , cy + cRadius*8, null);
            canvas.drawBitmap(imgloader.get(5), cx, cy+ cRadius*10, null);
            canvas.drawBitmap(imgloader.get(12), cx, cy + cRadius*12, null);
           /*
            canvas.drawRect(rectCheckmark, paint);
            canvas.drawRect(rectWhite, paint);
            canvas.drawRect(rectRed, paint);
            canvas.drawRect(rectBlue, paint);
            canvas.drawRect(rectGreen, paint);
            canvas.drawRect(rectBlack, paint);
            canvas.drawRect(rectX, paint);
            */
        }
        canvas.drawBitmap(imgloader.get(6), bx, by, null);
        canvas.drawBitmap(imgloader.get(8), bx, by+buttonY*2, null); //bet
        canvas.drawBitmap(imgloader.get(9), bx, by+buttonY*4, null);
        canvas.drawBitmap(imgloader.get(10), bx, by+buttonY*6, null);
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
        money-= bigblind;
    }
    public void takeSmallBlind(){
        money-= (bigblind/2);
    }
    public void blinds(){
        switch(dealerPosition){
            case 0:
                player1.takeSmallBlind(bigblind/2);
                player2.takeBigBlind(bigblind);
                break;
            case 1:
                player2.takeSmallBlind(bigblind/2);
                player3.takeBigBlind(bigblind);
                break;
            case 2:
                player3.takeSmallBlind(bigblind/2);
                player4.takeBigBlind(bigblind);
                break;
            case 3:
                player4.takeSmallBlind(bigblind/2);
                takeBigBlind();
                break;
            case 4:
                takeSmallBlind();
                player1.takeBigBlind(bigblind);
                break;
        }
        pot += (bigblind/2)+bigblind ;
        blindsFininshed = true;
        bettingFinished = false;
    }
    public void setWallet(int num)
    {
        if(num <= 100){
            money = 1000;
        }
        else{
            money = num;
        }
    }
    public void betting(int gameRound){
        if(gameRound == 0) {
            switch (dealerPosition) {
                case 0:
                    if(!player3.finished) {
                        player3.update(gameRound, 0);
                    }
                    else if(!player4.finished) {
                        player4.update(gameRound, 0);
                    }
                    //user input
                    else if(!player1.finished) {
                        player1.update(gameRound, 0);
                    }
                    else if(!player2.finished) {
                        player2.update(gameRound, 0);
                    }
                    break;
                case 1:
                    if(!player4.finished) {
                        player4.update(gameRound, 1);
                    }
                    //user input
                    else if(!player1.finished) {
                        player1.update(gameRound, 1);
                    }
                    else if(!player2.finished) {
                        player2.update(gameRound, 1);
                    }
                    else if(!player3.finished) {
                        player3.update(gameRound, 1);
                    }
                    break;
                case 2:
                    //user input
                    if(!player1.finished) {
                        player1.update(gameRound, 2);
                    }
                    else if(!player2.finished) {
                        player2.update(gameRound, 2);
                    }
                    else if(!player3.finished) {
                        player3.update(gameRound, 2);
                    }
                    else if(!player4.finished) {
                        player4.update(gameRound, 2);
                    }
                    break;
                case 3:
                    if(!player1.finished) {
                        player1.update(gameRound, 3);
                    }
                    else if(!player2.finished) {
                        player2.update(gameRound, 3);
                    }
                    else if(!player3.finished) {
                        player3.update(gameRound, 3);
                    }
                    else if(!player4.finished) {
                        player4.update(gameRound, 3);
                    }
                    //user input
                    break;
                case 4:
                    if(!player2.finished) {
                        player2.update(gameRound, 4);
                    }
                    else if(!player3.finished) {
                        player3.update(gameRound, 4);
                    }
                    else if(!player4.finished) {
                        player4.update(gameRound, 4);
                    }
                    //user input
                    else if(!player1.finished) {
                        player1.update(gameRound, 4);
                    }
                    break;
            }
        }
        else{
            switch (dealerPosition) {
                case 0:
                    if(!player1.finished) {
                        player1.update(gameRound, 3);
                    }
                    else if(!player2.finished) {
                        player2.update(gameRound, 3);
                    }
                    else if(!player3.finished) {
                        player3.update(gameRound, 3);
                    }
                    else if(!player4.finished) {
                        player4.update(gameRound, 3);
                    }
                    //user input
                    break;
                case 1:
                    if(!player2.finished) {
                        player2.update(gameRound, 4);
                    }
                    else if(!player3.finished) {
                        player3.update(gameRound, 4);
                    }
                    else if(!player4.finished) {
                        player4.update(gameRound, 4);
                    }
                    //user input
                    else if(!player1.finished) {
                        player1.update(gameRound, 4);
                    }
                    break;
                case 2:
                    if(!player3.finished) {
                        player3.update(gameRound, 0);
                    }
                    else if(!player4.finished) {
                        player4.update(gameRound, 0);
                    }
                    //user input
                    else if(!player1.finished) {
                        player1.update(gameRound, 0);
                    }
                    else if(!player2.finished) {
                        player2.update(gameRound, 0);
                    }
                    break;
                case 3:
                    if(!player4.finished) {
                        player4.update(gameRound, 1);
                    }
                    //user input
                    else if(!player1.finished) {
                        player1.update(gameRound, 1);
                    }
                    else if(!player2.finished) {
                        player2.update(gameRound, 1);
                    }
                    else if(!player3.finished) {
                        player3.update(gameRound, 1);
                    }
                    break;
                case 4:
                    //user input
                    if(!player1.finished) {
                        player1.update(gameRound, 3);
                    }
                    else if(!player2.finished) {
                        player2.update(gameRound, 3);
                    }
                    else if(!player3.finished) {
                        player3.update(gameRound, 3);
                    }
                    else if(!player4.finished) {
                        player4.update(gameRound, 3);
                    }
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