package sqp;

public class Main {

    public static void main(String[] args) {
        Game mainGame = new Game();
        mainGame.getPlayer(true).selectCard(0);
        mainGame.getPlayer(false).selectCard(0);
        mainGame.pickupSelectedCards();
        mainGame.playCardsThatMustBePlayed();
    }
}
