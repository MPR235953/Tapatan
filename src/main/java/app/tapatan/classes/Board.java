package app.tapatan.classes;

import javafx.scene.Group;

public class Board extends Group {
    public static int BOARD_WIDTH = 3;
    public static int BOARD_HEIGHT = 3;
    public static Tile[][] TileTable = new Tile[BOARD_HEIGHT][BOARD_WIDTH];

    public Board(){
        for (int y = 0; y < BOARD_HEIGHT; y++){
            for (int x = 0; x < BOARD_WIDTH; x++){
                Tile tile  = new Tile(x,y);
                    TileTable[y][x] = tile;
                    this.getChildren().add(tile);
            }
        }
    }

    Tile getTileat(Point point){return TileTable[point.x][point.y];}
}
