package app.tapatan;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.File;


public class GameController {
    @FXML private AnchorPane root;
    @FXML private ImageView map;
    @FXML private ImageView pane;
    @FXML private Label playerNr;
    @FXML private Pane boardPane;
    public static Pane staticPaneBoard;

    @FXML
    public void initialize(){
        staticPaneBoard = boardPane;
        map.setImage(new Image(new File("src/main/resources/app/tapatan/arts/map_600.png").toURI().toString()));
        pane.setImage(new Image(new File("src/main/resources/app/tapatan/arts/pane.png").toURI().toString()));
        root.getChildren().add(TapatanGame.board);
        //root.getChildren().add(TapatanGame.testPlayer.checkers);
    }

    @FXML protected void nextTurn() {
        playerNr.setText("2");
    }
}