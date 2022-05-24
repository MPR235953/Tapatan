package app.tapatan.classes;

import app.tapatan.classes.Tile;

public class Board{

    public static int JAKA_SZEROKOSC_WARIACIE = 3;
    public static int JAKA_DLUGOSC_WARIACIE = 3;
    public static Tile[][] TileTable = new Tile[JAKA_DLUGOSC_WARIACIE][JAKA_SZEROKOSC_WARIACIE];


    public Board(){
        for (int i = 0; i<JAKA_DLUGOSC_WARIACIE ; i++){
            for (int j= 0; j<JAKA_SZEROKOSC_WARIACIE ; j++){
                Tile tile  = new Tile();
                    TileTable[i][j] =tile;
            }
        }


    }

    Tile getTileat(Point point){return TileTable[point.x][point.y];}

}
