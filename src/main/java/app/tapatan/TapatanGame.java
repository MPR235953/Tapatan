package app.tapatan;

import app.tapatan.classes.Board;
import app.tapatan.classes.GameLoop;
import app.tapatan.classes.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class TapatanGame extends Application {
    static public int TILE_SIZE = 200;
    static public int BOARD_Y_OFFSET = 110;
    static public Board board = new Board();
    //static public Player testPlayer = new Player();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TapatanGame.class.getResource("start.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 710);
        GameLoop gameLoop = new GameLoop();
        Image icon = new Image(new File("src/main/resources/app/tapatan/arts/fire_tepig_200.png").toURI().toString());
        stage.getIcons().add(icon);
        stage.setTitle("Tapatan");

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}