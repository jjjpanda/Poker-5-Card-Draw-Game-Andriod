package orangeboat.poker_ai.Players;

/**
 * Created by jawpa on 12/6/2016.
 */
//Straight Better
public class Normal extends AI{
    int minSum = 18;

    public Normal() {
        super();
        //change values
        super.bluffRate = 0;
        super.responseTime = 0;
        super.shortStackPoint = 0;
    }
}
