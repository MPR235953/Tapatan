package app.tapatan.classes;

import javafx.scene.paint.Color;

import static app.tapatan.classes.Board.BOARD_WIDTH;
import static app.tapatan.classes.Board.tileTable;

/**
 * Glowna klasa posiadajaca kluczowe pola do implementacji i kontroli petli gry oraz ruchow gracza
 *
 */

public class GameLoop {
    public static Player[] players =
                                    {
                                        new Player(),
                                        new Player()
                                    };
    public static int actualPlayerNumber = 0;
    public static boolean  winConditionsFullfill =false;
    public static boolean  phase1Complete = false;
    //ważne ustawia flagę która sprawdza czy kliknięty został dobry pionek
    public static boolean fieldClickControl = false;
    public GameLoop(){
        players[0].tileusage =TileType.TILE_IN_USE_PLAYER_1;
        players[1].tileusage =TileType.TILE_IN_USE_PLAYER_2;
        players[0].color = Color.RED;
        players[1].color = Color.BLUE;

    }

    /**
     * metoda sprawdzajaca warunki zwyciestwa aktualnego gracza
     */
    public static void winCheck(){
        int row1=0,row2=0,row3=0;
        int col1=0,col2=0,col3=0;
        int rdiag=0,diag=0;

        for (int i=0;i<Board.BOARD_WIDTH;i++)
        {
            //sprawdzanie wierszy
        //row1
            if (tileTable[i][0].tileType == players[actualPlayerNumber].tileusage) row1++;
        //row1
            if (tileTable[i][1].tileType == players[actualPlayerNumber].tileusage) row2++;
        //row1
            if (tileTable[i][2].tileType == players[actualPlayerNumber].tileusage) row3++;
            //sprawdzanie kolumn
        //col1
            if (tileTable[0][i].tileType == players[actualPlayerNumber].tileusage) col1++;
        //col2
            if (tileTable[1][i].tileType == players[actualPlayerNumber].tileusage) col2++;
        //col3
            if (tileTable[2][i].tileType == players[actualPlayerNumber].tileusage) col3++;
            //sprawdzanie przekatnych
        //rdiag
            if (tileTable[i][i].tileType == players[actualPlayerNumber].tileusage) rdiag++;
        //diag
            if (tileTable[BOARD_WIDTH-i-1][i].tileType == players[actualPlayerNumber].tileusage) diag++;
        }
        if (col1 == 3 || col2 == 3 || col3 == 3 || row1 == 3 || row2 == 3 || row3 == 3 || diag == 3 || rdiag == 3)
            winConditionsFullfill = true;
    }

}
