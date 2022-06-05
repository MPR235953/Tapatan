package app.tapatan.classes;

import javafx.scene.paint.Color;

import static app.tapatan.classes.Board.*;

/**
 * Glowna klasa posiadajaca kluczowe pola do implementacji i kontroli petli gry oraz ruchow gracza
 */

public class GameLoop {
    public static Player[] players = {
                                        new Player(),
                                        new Player()
                                     };
    public static int actualPlayerNumber = 0;
    public static boolean  winConditionsFullfill = false;
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
        int[] check = new int[8];   // tablica przechowująca ilość pionków w {wiersz1, wiersz2, wiersz3, kolumna1, kolumna2, kolumna3, przekątna1, przekątna2}

        for (int i = 0; i < Board.BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                //sprawdzanie wierszy
                if (tileTable[i][j].tileType == players[actualPlayerNumber].tileusage) check[j]++;
                //sprawdzanie kolumn
                if (tileTable[j][i].tileType == players[actualPlayerNumber].tileusage) check[Board.BOARD_WIDTH + j]++;
            }
            //sprawdzanie przekątnych
            if (tileTable[i][i].tileType == players[actualPlayerNumber].tileusage)
                check[Board.BOARD_WIDTH + BOARD_HEIGHT]++;
            if (tileTable[BOARD_WIDTH - i - 1][i].tileType == players[actualPlayerNumber].tileusage)
                check[Board.BOARD_WIDTH + BOARD_HEIGHT + 1]++;
        }

        for (int i : check)
            if (i == 3) {
                winConditionsFullfill = true;
                break;
            }
    }

}
