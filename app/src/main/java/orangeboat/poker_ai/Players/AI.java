package orangeboat.poker_ai.Players;

import orangeboat.poker_ai.Card;

/**
 * Created by jawpa on 12/6/2016.
 */
//base
public class AI{
    public short bluffRate;
    public int shortStackPoint, responseTime; //number of big blinds
    public int money;
    public boolean finished;
    public Card a =  new Card();
    public Card b = new Card();

    public AI() {
        bluffRate = 0;
        responseTime = 0;
        shortStackPoint = 0;
        money = 0;
    }
    public void update(int gameRound, int dealerPosition){
    }
    public void takeBigBlind(){

    }
    public void takeSmallBlind(){

    }
}
