package app.tapatan.classes;

import app.tapatan.TapatanGame;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static app.tapatan.classes.Board.TileTable;
import static app.tapatan.classes.TileType.TILE_EMPTY;


public class Tile extends Rectangle {
    public TileType tileType = TileType.TILE_EMPTY;
    public Point point = new Point();

    public Tile(int x, int y){
        point.x = x;
        point.y = y;
        this.setWidth(TapatanGame.TILE_SIZE);
        this.setHeight(TapatanGame.TILE_SIZE);
        this.relocate(x * TapatanGame.TILE_SIZE, y * TapatanGame.TILE_SIZE + TapatanGame.BOARD_Y_OFFSET);
        this.setFill(Color.TRANSPARENT);
        this.setStroke(Color.rgb(255,255,255,0.5));
    }

    public void setTileType(TileType tileType) {
        this.tileType = tileType;
    }

    boolean isEmpty(Point p) {
        return TileTable[p.x][p.y].tileType == TILE_EMPTY;
    }

    boolean isEmpty(){ return this.tileType == TILE_EMPTY; }
}
