package app.tapatan;

import app.tapatan.classes.Board;
import app.tapatan.classes.Tile;
import app.tapatan.classes.Board.*;
import app.tapatan.classes.TileType;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

import static app.tapatan.classes.Board.TileTable;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("start.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 710);

        Image icon = new Image(new File("src/main/resources/app/tapatan/arts/fire_tepig_200.png").toURI().toString());
        stage.getIcons().add(icon);
        stage.setTitle("Tapatan");




        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    /*    Tile p[][] = new Tile[2][2];
        Tile p1 = new Tile();
        Tile ti1 = TileTable[1][1];
        System.out.println(TileTable[1][1]);

        Board board = new Board();
        Tile ti1 =  board.TileTable[1][1];
     */
    }
}