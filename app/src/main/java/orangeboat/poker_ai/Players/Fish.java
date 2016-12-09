package orangeboat.poker_ai.Players;

import orangeboat.poker_ai.Card;

/**
 * Created by jawpa on 12/6/2016.
 */
//Picky
public class Fish extends AI{

    public Fish() {
        super();
        //change values
        super.bluffRate = 0;
        super.responseTime = 0;
        super.shortStackPoint = 0;
    }
    @Override
    public void update(int gameRound, int dealerPosition){
        if (gameRound == 0) {
            //preflop
            a.deal('T', 'H');
            b.deal('9', 'S');
            if( evaluateCards(a,b, gameRound, money) ){
                //do action
            }
        }
        else if( gameRound == 1){
            //flop
        }
        else if( gameRound == 2){
            //turn
        }
        else if( gameRound == 3){
            //river
        }
    }
    public boolean evaluateCards(Card a, Card b, int gameRound, int money){
        if (gameRound == 0) {
            //preflop
        }
        else if( gameRound == 1){
            //flop
        }
        else if( gameRound == 2){
            //turn
        }
        else if( gameRound == 3){
            //river
        }
        return true;
    }
}
