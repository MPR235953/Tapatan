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
    @FXML private Label turnPlayerNr = new Label();
    public static Label staticPlayerNr;
    @FXML private Pane boardPane;
    public static Pane staticBoardPane;
    @FXML Pane gameEndPane;
    @FXML private Label endPlayerNr = new Label();

    @FXML
    public void initialize(){
        staticBoardPane = boardPane;
        staticPlayerNr = turnPlayerNr;
        map.setImage(new Image(new File("src/main/resources/app/tapatan/arts/map_600.png").toURI().toString()));
        pane.setImage(new Image(new File("src/main/resources/app/tapatan/arts/pane.png").toURI().toString()));
        boardPane.getChildren().add(TapatanGame.board);
        //root.getChildren().add(TapatanGame.testPlayer.checkers);
    }

    @FXML protected void nextTurn() {
        turnPlayerNr.setText("2");
    }

    public void gameEndPaneAppear(){
        //endPlayerNr.setText();
        staticBoardPane.setVisible(true);
    }

    public void gameEndDisappear(){ gameEndPane.setVisible(false); }
}