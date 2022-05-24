package app.tapatan;

import app.tapatan.classes.Board;
import app.tapatan.classes.Tile;
import app.tapatan.classes.Board.*;
import app.tapatan.classes.TileType;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static app.tapatan.classes.Board.TileTable;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("start.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
      //  launch();
    /*    Tile p[][] = new Tile[2][2];
        Tile p1 = new Tile();
        Tile ti1 = TileTable[1][1];
        System.out.println(TileTable[1][1]);

     */
        Board board = new Board();
        Tile ti1 =  board.TileTable[1][1];

    }
}