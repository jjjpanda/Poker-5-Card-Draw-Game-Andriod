package orangeboat.poker_ai;

/**
 * Created by jawpa on 12/8/2016.
 */
public class Card {
    public char value = '0';
    public char suit = '0';
    public Card(){}
    public void deal(char value, char suit){
        this.value = value;
        this.suit = suit;
    }
}
