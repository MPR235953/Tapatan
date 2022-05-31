package app.tapatan.classes;

import javafx.scene.Group;

public class Board extends Group {
    public static int BOARD_WIDTH = 3;
    public static int BOARD_HEIGHT = 3;
    public static Tile[][] tileTable = new Tile[BOARD_HEIGHT][BOARD_WIDTH];

    public Board(){
        for (int x = 0; x < BOARD_WIDTH; x++){
            for (int y = 0; y < BOARD_HEIGHT; y++){
                Tile tile  = new Tile(x,y);
                tileTable[x][y] = tile;
                this.getChildren().add(tile);
            }
        }
    }

    /** Do debuggowania, pokazuje aktualny stan planszy */
    public static void showBoardTypes(){
        for (int x = 0; x < BOARD_WIDTH; x++){
            for (int y = 0; y < BOARD_HEIGHT; y++){
                switch(tileTable[y][x].tileType){
                    case TILE_EMPTY:{ System.out.print("O"); break; }
                    case TILE_IN_USE:{ System.out.print("X"); break; }
                    case TILE_IN_USE_PLAYER_1:{ System.out.print("1"); break; }
                    case TILE_IN_USE_PLAYER_2:{ System.out.print("2"); break; }
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }

    /** Zwraca true jesli mamy wyjscie poza mape/tablice */
    public static boolean isOutOfBound(Point p){
        return p.x >= BOARD_WIDTH || p.x < 0 || p.y >= BOARD_HEIGHT || p.y < 0;
    }

    Tile getTileat(Point point){return tileTable[point.x][point.y];}
}
