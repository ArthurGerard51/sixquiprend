package sqp;

import java.util.Arrays;
import java.util.Comparator;

public class AbstractPlayer {

    private String name;
    private Card[] hand;
    private Card selectedCard;
    private int score;

    public AbstractPlayer(String givenName){
        name = givenName;
        hand = new Card[10];
        score = 0;
    }

    public Card[] getHand() {
        return hand;
    }

    public int getScore(){
        return score;
    }

    public void addScore(int toAdd){
        score += toAdd;
    }

    public void sortHand(){
        Arrays.sort(hand, Comparator.nullsLast(Comparator.comparingInt(Card::getNumber)));
    }

    public void setPlayerInCards(){
        for(Card card : hand){
            card.setPlayer(this);
        }
    }

    public void selectCard(int index){
        selectedCard = hand[index];
        hand[index] = null;
        sortHand();
    }

    public Card getSelectedCard() {
        return selectedCard;
    }

    public void cleanSelectedCard(){
        selectedCard = null;
    }
}
