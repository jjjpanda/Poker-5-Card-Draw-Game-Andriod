package orangeboat.poker_ai.Players;

/**
 * Created by jawpa on 12/6/2016.
 */
//base
public class AI{
    public short bluffRate, responseTime ;
    public int shortStackPoint; //number of big blinds
    public AI() {
        bluffRate = 0;
        responseTime = 0;
        shortStackPoint = 0;
    }
    public void update(int gameRound, int dealerPosition){
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
    }

}
