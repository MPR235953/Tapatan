package app.tapatan;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.File;

import static app.tapatan.classes.GameLoop.actualPlayerNumber;
import static app.tapatan.classes.GameLoop.players;

public class GameController {
    @FXML private AnchorPane root;
    @FXML private ImageView map;
    @FXML private ImageView pane;
    @FXML private Label turnPlayerNr = new Label();
    public static Label staticTurnPlayerNr;
    @FXML private Pane boardPane;
    public static Pane staticBoardPane;
    @FXML Pane gameEndPane;
    public static Pane staticGameEndPane;
    @FXML private Label endPlayerNr = new Label();
    public static Label staticEndPlayerNr;

    @FXML
    public void initialize(){
        staticBoardPane = boardPane;
        staticTurnPlayerNr = turnPlayerNr;
        staticTurnPlayerNr.setTextFill(Color.RED);
        staticGameEndPane = gameEndPane;
        staticEndPlayerNr = endPlayerNr;
        map.setImage(new Image(new File("src/main/resources/app/tapatan/arts/map_600.png").toURI().toString()));
        pane.setImage(new Image(new File("src/main/resources/app/tapatan/arts/pane.png").toURI().toString()));
        boardPane.getChildren().add(TapatanGame.board);
        //root.getChildren().add(TapatanGame.testPlayer.checkers);
    }

    static public void changeTurnPlayerNr(){
        actualPlayerNumber = (actualPlayerNumber + 1) % 2;
        staticTurnPlayerNr.setText(String.valueOf(actualPlayerNumber+1));
        staticTurnPlayerNr.setTextFill(players[actualPlayerNumber].color);
    }

    static public void gameEndAppear(){
        staticEndPlayerNr.setText(String.valueOf(actualPlayerNumber+1));
        staticEndPlayerNr.setTextFill(players[actualPlayerNumber].color);
        staticGameEndPane.setVisible(true);
    }

    public void gameEndDisappear(){ gameEndPane.setVisible(false); }
}