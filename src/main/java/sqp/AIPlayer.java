package sqp;

public class AIPlayer extends AbstractPlayer {

    private int difficulty;

    public AIPlayer(String name, int diff){
        super(name);
        difficulty = diff;
    }

    public int chooseBestSeriesToPickUp(Game game){

        return 0;
    }

    public void chooseBestCard(Game game) {
        Card[] serie1 = game.getSeries(0);

        selectCard(0);
    }
}
