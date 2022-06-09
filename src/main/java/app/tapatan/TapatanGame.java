package app.tapatan;

import app.tapatan.classes.Board;
import app.tapatan.classes.GameLoop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class TapatanGame extends Application {
    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 710;
    public static final int TILE_SIZE = 200;
    public static final int BOARD_Y_OFFSET = 110;
    public static Board board = new Board();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TapatanGame.class.getResource("start.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), WINDOW_WIDTH, WINDOW_HEIGHT);
        GameLoop gameLoop = new GameLoop();
        stage.setResizable(false);
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