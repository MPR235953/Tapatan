package app.tapatan;

import app.tapatan.classes.GameLoop;
import app.tapatan.classes.TileType;
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

import static app.tapatan.classes.Board.*;
import static app.tapatan.classes.GameLoop.*;

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

    static public void gameEndDisappear(){ staticGameEndPane.setVisible(false); }

    public void closeGame(ActionEvent actionEvent) {
        ((Stage)root.getScene().getWindow()).close();
    }

    public void gameRestart(ActionEvent actionEvent) {
        changeTurnPlayerNr();
        winConditionsFullfill = false;
        phase1Complete = false;

        for (int x = 0; x < getBoardWidth(); x++) {
            for (int y = 0; y < getBoardHeight(); y++) {
                getTileTable()[y][x].tileType = TileType.TILE_EMPTY;
            }
        }

        staticBoardPane.getChildren().clear();
        map.setImage(new Image(new File("src/main/resources/app/tapatan/arts/map_600.png").toURI().toString()));
        boardPane.getChildren().add(map);
        boardPane.getChildren().add(TapatanGame.board);

        for(int i=0; i<3; i++){
            if(!GameLoop.WaterImagesUsed.isEmpty()){
                GameLoop.WaterImagesUnused.add(GameLoop.WaterImagesUsed.get(0));
                GameLoop.WaterImagesUsed.remove(0);
            }
            if(!GameLoop.FireImagesUsed.isEmpty()){
                GameLoop.FireImagesUnused.add(GameLoop.FireImagesUsed.get(0));
                GameLoop.FireImagesUsed.remove(0);
            }
        }

        gameEndDisappear();
    }
}