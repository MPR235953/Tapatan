package app.tapatan.classes;

import app.tapatan.classes.Tile;
import javafx.scene.Group;

public class Board extends Group {

    public static int JAKA_SZEROKOSC_WARIACIE = 3;
    public static int JAKA_DLUGOSC_WARIACIE = 3;
    public static Tile[][] TileTable = new Tile[JAKA_DLUGOSC_WARIACIE][JAKA_SZEROKOSC_WARIACIE];


    public Board(){
        for (int y = 0; y < JAKA_DLUGOSC_WARIACIE; y++){
            for (int x = 0; x < JAKA_SZEROKOSC_WARIACIE; x++){
                Tile tile  = new Tile(x,y);
                    TileTable[y][x] = tile;
            }
        }


    }

    Tile getTileat(Point point){return TileTable[point.x][point.y];}

}
