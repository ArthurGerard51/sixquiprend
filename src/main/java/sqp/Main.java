package sqp;

public class Main {

    public static void main(String[] args) {
        Game mainGame = new Game();
        mainGame.getPlayerOrAi(true).selectCard(0);
        mainGame.getPlayerOrAi(false).selectCard(0);
        mainGame.pickupSelectedCards();
        mainGame.playCardsThatMustBePlayed();
    }
}
