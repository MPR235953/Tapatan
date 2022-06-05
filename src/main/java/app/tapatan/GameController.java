package app.tapatan;

import app.tapatan.classes.GraphicLinkArray;
import app.tapatan.classes.TileType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
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
    @FXML private Button exitButton;
    @FXML private Button restartButton;

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

    static public void gameEndDisappear(){ staticGameEndPane.setVisible(false); }

    public void closeGame(ActionEvent actionEvent) {
        ((Stage)root.getScene().getWindow()).close();
    }

    public void gameRestart(ActionEvent actionEvent) {
        changeTurnPlayerNr();
        winConditionsFullfill = false;
        phase1Complete = false;
        fieldClickControl = false;

        for (int x = 0; x < BOARD_WIDTH; x++) {
            for (int y = 0; y < BOARD_HEIGHT; y++) {
                tileTable[y][x].tileType = TileType.TILE_EMPTY;
            }
        }

        staticBoardPane.getChildren().clear();
        map.setImage(new Image(new File("src/main/resources/app/tapatan/arts/map_600.png").toURI().toString()));
        boardPane.getChildren().add(map);
        boardPane.getChildren().add(TapatanGame.board);

        for(int i=0; i<3; i++){
            if(!GraphicLinkArray.WaterImagesUsed.isEmpty()){
                GraphicLinkArray.WaterImagesUnused.add(GraphicLinkArray.WaterImagesUsed.get(0));
                GraphicLinkArray.WaterImagesUsed.remove(0);
            }
            if(!GraphicLinkArray.FireImagesUsed.isEmpty()){
                GraphicLinkArray.FireImagesUnused.add(GraphicLinkArray.FireImagesUsed.get(0));
                GraphicLinkArray.FireImagesUsed.remove(0);
            }
        }

        gameEndDisappear();
    }
}