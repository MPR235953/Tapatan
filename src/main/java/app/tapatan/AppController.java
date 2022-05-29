package app.tapatan;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.File;

public class AppController {
    @FXML private AnchorPane root;
    @FXML private ImageView map;

    @FXML
    public void initialize(){
        map.setImage(new Image(new File("src/main/resources/app/tapatan/arts/map_600.png").toURI().toString()));
    }

    @FXML private Label playerNr;

    @FXML
    protected void nextTurn() {
        playerNr.setText("2");
    }
}