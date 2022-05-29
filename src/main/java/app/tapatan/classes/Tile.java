package app.tapatan.classes;

import static app.tapatan.classes.Board.TileTable;
import static app.tapatan.classes.TileType.TILE_EMPTY;

//współrzedne dałem jakby miały się przydać
//Można usunąć

public class Tile {

    public TileType tileType = TileType.TILE_EMPTY;
    public Point point = new Point();
    public Tile(int x, int y){
        point.x = x;
        point.y = y;
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
