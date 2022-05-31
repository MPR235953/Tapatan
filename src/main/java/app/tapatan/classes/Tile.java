package app.tapatan.classes;

import app.tapatan.GameController;
import app.tapatan.TapatanGame;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.util.Random;

import static app.tapatan.classes.Board.tileTable;
import static app.tapatan.classes.TileType.TILE_EMPTY;


public class Tile extends Rectangle {
    public TileType tileType = TileType.TILE_EMPTY;
    public Point point = new Point();

    public Tile(int x, int y){
        point.x = x;
        point.y = y;
        this.setWidth(TapatanGame.TILE_SIZE);
        this.setHeight(TapatanGame.TILE_SIZE);
        this.relocate(x * TapatanGame.TILE_SIZE, y * TapatanGame.TILE_SIZE);
        this.setFill(Color.TRANSPARENT);
        this.setStroke(Color.WHITE);

        this.setOnMouseClicked(e ->{
            if(this.tileType == TILE_EMPTY){
                this.tileType = TileType.TILE_IN_USE;
                int randomIndex = new Random().nextInt(GraphicLinkArray.FireImages.size());
                Image image = new Image(new File("src/main/resources/app/tapatan/arts/" + GraphicLinkArray.FireImages.get(randomIndex)).toURI().toString());
                GraphicLinkArray.FireImages.remove(randomIndex);
                this.setStroke(Color.ORANGE);
                Checker checker = new Checker(image, x, y);
                GameController.staticBoardPane.getChildren().add(checker);
            }
        });
    }

    public void setTileType(TileType tileType) {
        this.tileType = tileType;
    }

    boolean isEmpty(Point p) {
        return tileTable[p.x][p.y].tileType == TILE_EMPTY;
    }

    boolean isEmpty(){ return this.tileType == TILE_EMPTY; }
}
