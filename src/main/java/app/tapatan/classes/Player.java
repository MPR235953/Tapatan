package app.tapatan.classes;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;


public class Player {
    public String name;
    public Color color = Color.BLACK;
    public TileType tileusage = TileType.TILE_IN_USE_PLAYER_1;
    public Group checkers;

    public Player() {
        checkers = new Group();
        Image img = new Image("file:src/main/resources/app/tapatan/arts/fire_charmander_200.png");
        checkers.getChildren().add(new Checker(img, 0, 0));
    }
}
