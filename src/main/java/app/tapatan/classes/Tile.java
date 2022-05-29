package app.tapatan.classes;

import app.tapatan.App;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static app.tapatan.classes.Board.TileTable;
import static app.tapatan.classes.TileType.TILE_EMPTY;

//współrzedne dałem jakby miały się przydać
//Można usunąć

public class Tile extends Rectangle {

    public TileType tileType = TileType.TILE_EMPTY;
    public Point point = new Point();
    public Tile(int x, int y){
        point.x = x;
        point.y = y;
        this.setWidth(App.TILE_SIZE);
        this.setHeight(App.TILE_SIZE);
        this.relocate(x * App.TILE_SIZE, y * App.TILE_SIZE + App.BOARD_Y_OFFSET);
        this.setFill(Color.TRANSPARENT);
        this.setStroke(Color.rgb(255,255,255,0.5));
    }
    public void setTileType(TileType tileType) {
        this.tileType = tileType;
    }
    boolean isEmpty(Point p) {
        if (TileTable[p.x][p.y].tileType == TILE_EMPTY) {
            return true;
        }
        return false;
    }
}
