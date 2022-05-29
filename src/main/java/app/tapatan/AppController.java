package app.tapatan;

import app.tapatan.classes.Board;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.File;

//TODO: skalowanie okna

public class AppController {
    @FXML private AnchorPane root;
    @FXML private ImageView map;
    @FXML private ImageView pane;

    @FXML
    public void initialize(){
        map.setImage(new Image(new File("src/main/resources/app/tapatan/arts/map_600.png").toURI().toString()));
        pane.setImage(new Image(new File("src/main/resources/app/tapatan/arts/pane.png").toURI().toString()));
        root.getChildren().add(App.board);
        root.getChildren().add(App.testPlayer.checkers);

//        ImageView img = new ImageView();
//        img.setImage(new Image("file:src/main/resources/app/tapatan/arts/fire_charmander_200.png"));
    }

    @FXML private Label playerNr;

    @FXML
    protected void nextTurn() {
        playerNr.setText("2");
    }
}