package sqp;

import java.util.Arrays;

public class AIPlayer extends AbstractPlayer {

    private int difficulty;

    public AIPlayer(String name, int diff){
        super(name);
        difficulty = diff;
    }

    public int chooseBestSeriesToPickUp(Game game){
        int[] points = new int[4];
        points[0] = game.getPointsFromSeries(0);
        points[1] = game.getPointsFromSeries(1);
        points[2] = game.getPointsFromSeries(2);
        points[3] = game.getPointsFromSeries(3);
        int smallest = points[0];
        int smallestIndex = 0;

        for (int i = 1; i < 4; i++) {
            if (points[i] < smallest) {
                smallest = points[i];
                smallestIndex = i;
            }
        }

        return smallestIndex;
    }

    public void chooseBestCard(Game game) {
        Card[] serie1 = game.getSeries(0);
        Card[] serie2 = game.getSeries(1);
        Card[] serie3 = game.getSeries(2);
        Card[] serie4 = game.getSeries(3);

        int minDifference = Integer.MAX_VALUE;
        Card bestCard = null;

        for (Card card : super.getHand()) {
            if (card != null) {
                int difference = Integer.MAX_VALUE;

                if (serie1[5] != card && serie1[4] == null)
                    difference = Math.min(difference, serie1[0].getNumber() - card.getNumber());
                if (serie2[5] != card && serie2[4] == null)
                    difference = Math.min(difference, serie2[0].getNumber() - card.getNumber());
                if (serie3[5] != card && serie3[4] == null)
                    difference = Math.min(difference, serie3[0].getNumber() - card.getNumber());
                if (serie4[5] != card && serie4[4] == null)
                    difference = Math.min(difference, serie4[0].getNumber() - card.getNumber());

                if (difference < minDifference) {
                    minDifference = difference;
                    bestCard = card;
                }
            }
        }

        selectCard(Arrays.asList(super.getHand()).indexOf(bestCard));
    }
}
