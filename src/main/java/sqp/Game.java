package sqp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Game {

    private HumanPlayer humanPlayer;
    private AIPlayer ai;
    private Deck deck;
    private ArrayList<Card> usedCards;
    private final Card[] series1, series2, series3, series4;
    private Card[][] series;
    private ArrayList<Card> cardsToPutOnBoard;
    private boolean humanPlayerMustTakeSerie;

    public Game(){
        humanPlayer = new HumanPlayer("player");
        ai = new AIPlayer("ai", 1);
        deck = new Deck();
        usedCards = new ArrayList<>();
        cardsToPutOnBoard = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            humanPlayer.getHand()[i] = deck.drawTopCard();
            ai.getHand()[i] = deck.drawTopCard();
        }
        humanPlayer.setPlayerInCards();
        ai.setPlayerInCards();
        humanPlayer.sortHand();
        ai.sortHand();

        series1 = new Card[]{deck.drawTopCard(), null, null, null, null, null};
        series2 = new Card[]{deck.drawTopCard(), null, null, null, null, null};
        series3 = new Card[]{deck.drawTopCard(), null, null, null, null, null};
        series4 = new Card[]{deck.drawTopCard(), null, null, null, null, null};
        series = new Card[][]{series1, series2, series3, series4};

        humanPlayerMustTakeSerie = false;
    }

    public void newRound(){
        usedCards.clear();
        cardsToPutOnBoard.clear();
        cleanSeries();
        deck = new Deck();
        for(int i = 0; i < 10; i++){
            humanPlayer.getHand()[i] = deck.drawTopCard();
            ai.getHand()[i] = deck.drawTopCard();
        }
        humanPlayer.setPlayerInCards();
        ai.setPlayerInCards();
        humanPlayer.sortHand();
        ai.sortHand();
        series1[0] = deck.drawTopCard();
        series2[0] = deck.drawTopCard();
        series3[0] = deck.drawTopCard();
        series4[0] = deck.drawTopCard();
    }

    private void cleanSeries() {
        Arrays.fill(series1, null);
        Arrays.fill(series2, null);
        Arrays.fill(series3, null);
        Arrays.fill(series4, null);
    }

    public AbstractPlayer getPlayer(boolean player){
        if(player){
            return humanPlayer;
        } else {
            return ai;
        }
    }

    public Card[] getSeries(int index){
        return series[index];
    }

    public void pickupSerieAndAssignPoints(int index, AbstractPlayer player){
        player.addScore(getPointsFromSeries(index));
        Card[] serie = series[index];
        for(int i = 0; i < 5; i++){
            if(serie[i] != null) {
                usedCards.add(serie[i]);
                serie[i] = null;
            }
        }
        serie[0] = serie[5];
        serie[5] = null;
    }

    public int getPointsFromSeries(int index){
        int score = 0;
        for(int i = 0; i < 5; i++){
            if(series[index][i] != null) {
                score += series[index][i].getHeadNumber();
            }
        }
        return score;
    }

    public static Card getLastNonNullCard(Card[] cards) {
        for (int i = cards.length - 1; i >= 0; i--) {
            if (cards[i] != null) {
                return cards[i];
            }
        }
        return null;
    }

    public static int getFirstFreeCardIndex(Card[] cards) {
        for (int i = cards.length - 1; i >= 0; i--) {
            if (cards[i] != null) {
                return i+1;
            }
        }
        return 0;
    }

    public int getHighestNumInSerie(Card[] serie){
        assert getLastNonNullCard(serie) != null;
        return getLastNonNullCard(serie).getNumber();
    }

    public int[] getHighestNumsInSeries(){
        int[] highest = new int[4];
        highest[0] = getHighestNumInSerie(series[0]);
        highest[1] = getHighestNumInSerie(series[1]);
        highest[2] = getHighestNumInSerie(series[2]);
        highest[3] = getHighestNumInSerie(series[3]);
        return highest;
    }

    public boolean canCardBePutInSeries(Card card){
        int num = card.getNumber();
        boolean isLower = true;
        for(int i : getHighestNumsInSeries()){
            if (num > i) {
                isLower = false;
                break;
            }
        }
        return !isLower;
    }

    public void playCardsThatMustBePlayed(){
        Collections.sort(cardsToPutOnBoard, Comparator.comparingInt(Card::getNumber));
        while (cardsToPutOnBoard.size() > 0){
            Card card = cardsToPutOnBoard.get(0);
            if(!canCardBePutInSeries(card)){
                if(card.getPlayer().getClass() == AIPlayer.class){
                    int index = ((AIPlayer) card.getPlayer()).chooseBestSeriesToPickUp(this);
                    series[index][5] = card;
                    cardsToPutOnBoard.remove(0);
                    pickupSerieAndAssignPoints(index, ai);
                } else {
                    humanPlayerMustTakeSerie = true;
                    break;
                }
            } else {
                putCardOnTable(card);
                cardsToPutOnBoard.remove(0);
            }
        }
    }

    public void humanPlayerTakesSerie(int index){
        series[index][5] = cardsToPutOnBoard.get(0);
        pickupSerieAndAssignPoints(index, humanPlayer);
        cardsToPutOnBoard.remove(0);
    }

    private void putCardOnTable(Card card) {
        int num = card.getNumber();
        int[] highest = getHighestNumsInSeries();
        int[] differences = new int[4];
        differences[0] = num - highest[0];
        differences[1] = num - highest[1];
        differences[2] = num - highest[2];
        differences[3] = num - highest[3];
        int seriesIndex = getLowestIndex(differences);
        Card[] serie = series[seriesIndex];
        int index = getFirstFreeCardIndex(serie);
        serie[index] = card;
        if(index == 5){
            pickupSerieAndAssignPoints(seriesIndex, card.getPlayer());
        }
    }

    public static int getLowestIndex(int[] array) {
        int lowestIndex = -1;
        int lowestValue = 104;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < lowestValue && array[i] > 0) {
                lowestValue = array[i];
                lowestIndex = i;
            }
        }

        return lowestIndex;
    }

    public void pickupSelectedCards(){
        cardsToPutOnBoard.add(humanPlayer.getSelectedCard());
        cardsToPutOnBoard.add(ai.getSelectedCard());
        humanPlayer.cleanSelectedCard();
        ai.cleanSelectedCard();
    }

    public void playerHasSelectedCard() {
        ai.chooseBestCard(this);
        pickupSelectedCards();
        playCardsThatMustBePlayed();
    }

    public boolean getHumanPlayerMustTakeSerie() {
        return humanPlayerMustTakeSerie;
    }

    public void setHumanPlayerMustTakeSerie(boolean input) {
        humanPlayerMustTakeSerie = input;
    }

    public boolean noCardInStack(){
        return cardsToPutOnBoard.size() == 0;
    }
}
