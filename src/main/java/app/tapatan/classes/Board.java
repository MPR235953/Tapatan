package app.tapatan.classes;

import app.tapatan.classes.Tile;

public class Board{

    public static int JAKA_SZEROKOSC_WARIACIE = 3;
    public static int JAKA_DLUGOSC_WARIACIE = 3;
    public static Tile[][] TileTable = new Tile[JAKA_DLUGOSC_WARIACIE][JAKA_SZEROKOSC_WARIACIE];



    Tile getTileat(Point point){return TileTable[point.x][point.y];}

}
