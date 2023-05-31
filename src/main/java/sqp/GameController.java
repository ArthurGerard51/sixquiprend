package sqp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GameController {

    @FXML
    public Button takeserie1button;
    @FXML
    public Button takeserie2button;
    @FXML
    public Button takeserie3button;
    @FXML
    public Button takeserie4button;
    @FXML
    private ImageView playercard1;
    @FXML
    private ImageView playercard2;
    @FXML
    private ImageView playercard3;
    @FXML
    private ImageView playercard4;
    @FXML
    private ImageView playercard5;
    @FXML
    private ImageView playercard6;
    @FXML
    private ImageView playercard7;
    @FXML
    private ImageView playercard8;
    @FXML
    private ImageView playercard9;
    @FXML
    private ImageView playercard10;
    @FXML
    private ImageView serie1card1;
    @FXML
    private ImageView serie1card2;
    @FXML
    private ImageView serie1card3;
    @FXML
    private ImageView serie1card4;
    @FXML
    private ImageView serie1card5;
    @FXML
    private ImageView serie1card6;
    @FXML
    private ImageView serie2card1;
    @FXML
    private ImageView serie2card2;
    @FXML
    private ImageView serie2card3;
    @FXML
    private ImageView serie2card4;
    @FXML
    private ImageView serie2card5;
    @FXML
    private ImageView serie2card6;
    @FXML
    private ImageView serie3card1;
    @FXML
    private ImageView serie3card2;
    @FXML
    private ImageView serie3card3;
    @FXML
    private ImageView serie3card4;
    @FXML
    private ImageView serie3card5;
    @FXML
    private ImageView serie3card6;
    @FXML
    private ImageView serie4card1;
    @FXML
    private ImageView serie4card2;
    @FXML
    private ImageView serie4card3;
    @FXML
    private ImageView serie4card4;
    @FXML
    private ImageView serie4card5;
    @FXML
    private ImageView serie4card6;
    @FXML
    private Button card1button;
    @FXML
    private Button card2button;
    @FXML
    private Button card3button;
    @FXML
    private Button card4button;
    @FXML
    private Button card5button;
    @FXML
    private Button card6button;
    @FXML
    private Button card7button;
    @FXML
    private Button card8button;
    @FXML
    private Button card9button;
    @FXML
    private Button card10button;

    private Game game;

    public void initialize() throws FileNotFoundException {
        game = new Game();

        updateBoardImages();
        updatePlayerHandImages();
        setTakeSeriesButtonsDisabled(true);
    }

    private void updateBoardImages() throws FileNotFoundException {
        ImageView[] serie1 = new ImageView[]{serie1card1, serie1card2, serie1card3, serie1card4, serie1card5, serie1card6};
        ImageView[] serie2 = new ImageView[]{serie2card1, serie2card2, serie2card3, serie2card4, serie2card5, serie2card6};
        ImageView[] serie3 = new ImageView[]{serie3card1, serie3card2, serie3card3, serie3card4, serie3card5, serie3card6};
        ImageView[] serie4 = new ImageView[]{serie4card1, serie4card2, serie4card3, serie4card4, serie4card5, serie4card6};

        for(int i = 0; i < 4; i++){
            ImageView[] views = switch (i){case 0 -> serie1; case 1 -> serie2; case 2 -> serie3; case 3 -> serie4; default -> throw new IllegalStateException("Unexpected value: " + i);};
            Card[] serie = game.getSeries(i);
            for(int j = 0; j < 6; j++){
                if(serie[j]!=null){
                    views[j].setImage(new Image(new FileInputStream(serie[j].getImage())));
                } else {
                    views[j].setImage(new Image(new FileInputStream("src/main/resources/sqp/cards/empty.png")));
                }
            }
        }
    }

    private void updatePlayerHandImages() throws FileNotFoundException {
        Card[] hand = game.getPlayerOrAi(true).getHand();
        ImageView[] imageViews = new ImageView[]{playercard1, playercard2, playercard3, playercard4, playercard5, playercard6, playercard7, playercard8, playercard9, playercard10};
        for(int i = 0; i < 10; i++){
            if(hand[i]!=null){
                imageViews[i].setImage(new Image(new FileInputStream(hand[i].getImage())));
            } else {
                imageViews[i].setImage(new Image(new FileInputStream("src/main/resources/sqp/cards/empty.png")));
            }
        }
    }

    public void setTakeSeriesButtonsDisabled(boolean input){
        takeserie1button.setDisable(input);
        takeserie2button.setDisable(input);
        takeserie3button.setDisable(input);
        takeserie4button.setDisable(input);
    }

    public void setPlayButtonsDisabled(boolean input){
        card1button.setDisable(input);
        card2button.setDisable(input);
        card3button.setDisable(input);
        card4button.setDisable(input);
        card5button.setDisable(input);
        card6button.setDisable(input);
        card7button.setDisable(input);
        card8button.setDisable(input);
        card9button.setDisable(input);
        card10button.setDisable(input);
    }

    private void checkHumanMustTakeSerie() {
        if(game.getHumanPlayerMustTakeSerie()){
            setTakeSeriesButtonsDisabled(false);
            setPlayButtonsDisabled(true);
        }
    }

    public void takeSerie1(MouseEvent mouseEvent) throws FileNotFoundException {
        game.humanPlayerTakesSerie(0);
        game.playCardsThatMustBePlayed();
        game.setHumanPlayerMustTakeSerie(false);
        setTakeSeriesButtonsDisabled(true);
        setPlayButtonsDisabled(false);
        updateBoardImages();
        updatePlayerHandImages();
    }

    public void takeSerie2(MouseEvent mouseEvent) throws FileNotFoundException {
        game.humanPlayerTakesSerie(1);
        game.playCardsThatMustBePlayed();
        game.setHumanPlayerMustTakeSerie(false);
        setTakeSeriesButtonsDisabled(true);
        setPlayButtonsDisabled(false);
        updateBoardImages();
        updatePlayerHandImages();
    }

    public void takeSerie3(MouseEvent mouseEvent) throws FileNotFoundException {
        game.humanPlayerTakesSerie(2);
        game.playCardsThatMustBePlayed();
        game.setHumanPlayerMustTakeSerie(false);
        setTakeSeriesButtonsDisabled(true);
        setPlayButtonsDisabled(false);
        updateBoardImages();
        updatePlayerHandImages();
    }

    public void takeSerie4(MouseEvent mouseEvent) throws FileNotFoundException {
        game.humanPlayerTakesSerie(3);
        game.playCardsThatMustBePlayed();
        game.setHumanPlayerMustTakeSerie(false);
        setTakeSeriesButtonsDisabled(true);
        setPlayButtonsDisabled(false);
        updateBoardImages();
        updatePlayerHandImages();
    }

    public boolean doesCardExist(int index){
        return game.getPlayerOrAi(true).getHand()[index] != null;
    }

    public void playCard1(MouseEvent mouseEvent) throws FileNotFoundException {
        if(doesCardExist(0)) {
            game.getPlayerOrAi(true).selectCard(0);
            game.playerHasSelectedCard();
            checkHumanMustTakeSerie();
            updateBoardImages();
            updatePlayerHandImages();
        }
    }



    public void playCard2(MouseEvent mouseEvent) throws FileNotFoundException {
        if(doesCardExist(1)) {
            game.getPlayerOrAi(true).selectCard(1);
            game.playerHasSelectedCard();
            checkHumanMustTakeSerie();
            updateBoardImages();
            updatePlayerHandImages();
        }
    }

    public void playCard3(MouseEvent mouseEvent) throws FileNotFoundException {
        if(doesCardExist(2)) {
            game.getPlayerOrAi(true).selectCard(2);
            game.playerHasSelectedCard();
            checkHumanMustTakeSerie();
            updateBoardImages();
            updatePlayerHandImages();
        }
    }

    public void playCard4(MouseEvent mouseEvent) throws FileNotFoundException {
        if(doesCardExist(3)) {
            game.getPlayerOrAi(true).selectCard(3);
            game.playerHasSelectedCard();
            checkHumanMustTakeSerie();
            updateBoardImages();
            updatePlayerHandImages();
        }
    }

    public void playCard5(MouseEvent mouseEvent) throws FileNotFoundException {
        if(doesCardExist(4)) {
            game.getPlayerOrAi(true).selectCard(4);
            game.playerHasSelectedCard();
            checkHumanMustTakeSerie();
            updateBoardImages();
            updatePlayerHandImages();
        }
    }

    public void playCard6(MouseEvent mouseEvent) throws FileNotFoundException {
        if(doesCardExist(5)) {
            game.getPlayerOrAi(true).selectCard(5);
            game.playerHasSelectedCard();
            checkHumanMustTakeSerie();
            updateBoardImages();
            updatePlayerHandImages();
        }
    }

    public void playCard7(MouseEvent mouseEvent) throws FileNotFoundException {
        if(doesCardExist(6)) {
            game.getPlayerOrAi(true).selectCard(6);
            game.playerHasSelectedCard();
            checkHumanMustTakeSerie();
            updateBoardImages();
            updatePlayerHandImages();
        }
    }

    public void playCard8(MouseEvent mouseEvent) throws FileNotFoundException {
        if(doesCardExist(7)) {
            game.getPlayerOrAi(true).selectCard(7);
            game.playerHasSelectedCard();
            checkHumanMustTakeSerie();
            updateBoardImages();
            updatePlayerHandImages();
        }
    }

    public void playCard9(MouseEvent mouseEvent) throws FileNotFoundException {
        if(doesCardExist(8)) {
            game.getPlayerOrAi(true).selectCard(8);
            game.playerHasSelectedCard();
            checkHumanMustTakeSerie();
            updateBoardImages();
            updatePlayerHandImages();
        }
    }

    public void playCard10(MouseEvent mouseEvent) throws FileNotFoundException {
        if(doesCardExist(9)) {
            game.getPlayerOrAi(true).selectCard(9);
            game.playerHasSelectedCard();
            checkHumanMustTakeSerie();
            updateBoardImages();
            updatePlayerHandImages();
        }
    }
}
