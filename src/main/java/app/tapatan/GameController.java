package app.tapatan;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;

import static app.tapatan.classes.GameLoop.*;

public class GameController {
    @FXML private AnchorPane root;
    @FXML private ImageView map;
    @FXML private ImageView pane;
    @FXML private Label turnPlayerNr = new Label();
    private static Label staticTurnPlayerNr;
    @FXML private Pane boardPane;
    public static Pane staticBoardPane;
    @FXML Pane gameEndPane;
    public static Pane staticGameEndPane;
    @FXML private Label endPlayerNr = new Label();
    private static Label staticEndPlayerNr;

    @FXML
    private void initialize(){
        staticBoardPane = boardPane;
        staticTurnPlayerNr = turnPlayerNr;
        staticTurnPlayerNr.setTextFill(Color.RED);
        staticGameEndPane = gameEndPane;
        staticEndPlayerNr = endPlayerNr;
        map.setImage(new Image(new File("src/main/resources/app/tapatan/arts/map_600.png").toURI().toString()));
        pane.setImage(new Image(new File("src/main/resources/app/tapatan/arts/pane.png").toURI().toString()));
        boardPane.getChildren().add(TapatanGame.board);
    }

    public static void changeTurnPlayerNr(){
        actualPlayerNumber = (actualPlayerNumber + 1) % 2;
        staticTurnPlayerNr.setText(String.valueOf(actualPlayerNumber+1));
        staticTurnPlayerNr.setTextFill(players[actualPlayerNumber].color);
    }

    public static void gameEndAppear(){
        staticEndPlayerNr.setText(String.valueOf(actualPlayerNumber+1));
        staticEndPlayerNr.setTextFill(players[actualPlayerNumber].color);
        staticGameEndPane.setVisible(true);
    }

    private void gameEndDisappear(){ staticGameEndPane.setVisible(false); }

    public void closeGame(ActionEvent actionEvent) {
        ((Stage)root.getScene().getWindow()).close();
    }

    public void restartGame(ActionEvent actionEvent) {
        staticBoardPane.getChildren().clear();
        map.setImage(new Image(new File("src/main/resources/app/tapatan/arts/map_600.png").toURI().toString()));
        boardPane.getChildren().add(map);
        boardPane.getChildren().add(TapatanGame.board);

        changeTurnPlayerNr();
        resetGame();
        gameEndDisappear();
    }
}