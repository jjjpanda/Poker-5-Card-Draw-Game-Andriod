package orangeboat.poker_ai.Players;

import orangeboat.poker_ai.Card;

/**
 * Created by jawpa on 12/6/2016.
 */
//Straight Better
public class Normal extends AI{
    int minSum = 18;
    public int timePassed;
    public Normal() {
        super();
        //change values
        super.bluffRate = 0;
        super.responseTime = 0;
        super.shortStackPoint = 0;
        responseTime = 60;
        finished = false;
    }
    @Override
    public void update(int gameRound, int dealerPosition){
        if (gameRound == 0 && !finished) {
            //preflop
            timePassed++;
            if(timePassed >= responseTime){
                timePassed = 0;
                finished = true;
                if( evaluateCards(a,b, gameRound, money) ){
                    //do action
                }
            }
        }
        else if( gameRound == 1 && !finished){
            //flop
            timePassed++;
            if( timePassed >= responseTime){
                timePassed =0;
                finished = true;
            }

        }
        else if( gameRound == 2 && !finished){
            //turn
            timePassed++;
            if( timePassed == responseTime){
                timePassed =0;
                finished = true;
            }
        }
        else if( gameRound == 3 && !finished){
            //river
            timePassed++;
            if( timePassed == responseTime){
                timePassed =0;
                finished = true;
            }
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
