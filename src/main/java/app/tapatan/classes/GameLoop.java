package app.tapatan.classes;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;

import static app.tapatan.classes.Board.*;

/**
 * Glowna klasa posiadajaca kluczowe pola do implementacji i kontroli petli gry oraz ruchow gracza
 */

public class GameLoop {
    public static ArrayList<String> FireImagesUnused = new ArrayList<>(Arrays.asList("fire_tepig_200.png", "fire_torchic_200.png", "fire_charmander_200.png"));
    public static ArrayList<String> WaterImagesUnused = new ArrayList<>(Arrays.asList("water_squirtle_200.png", "water_horsea_200.png", "water_piplup_200.png"));
    public static ArrayList<String> FireImagesUsed = new ArrayList<>();
    public static ArrayList<String> WaterImagesUsed = new ArrayList<>();
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
        players[0].tileusage = TileType.TILE_IN_USE_PLAYER_1;
        players[1].tileusage = TileType.TILE_IN_USE_PLAYER_2;
        players[0].color = Color.RED;
        players[1].color = Color.BLUE;

    }

    /**
     * metoda sprawdzajaca warunki zwyciestwa aktualnego gracza
     */
    public static void winCheck(){
        if(!phase1Complete) {
            return;
        }
        int[] check = new int[8];   // tablica przechowująca ilość pionków w {wiersz1, wiersz2, wiersz3, kolumna1, kolumna2, kolumna3, przekątna1, przekątna2}

        for (int i = 0; i < Board.getBoardWidth(); i++) {
            for (int j = 0; j < getBoardHeight(); j++) {
                //sprawdzanie wierszy
                if (getTileTable()[i][j].tileType == players[actualPlayerNumber].tileusage) check[j]++;
                //sprawdzanie kolumn
                if (getTileTable()[j][i].tileType == players[actualPlayerNumber].tileusage) check[Board.getBoardWidth() + j]++;
            }
            //sprawdzanie przekątnych
            if (getTileTable()[i][i].tileType == players[actualPlayerNumber].tileusage)
                check[Board.getBoardWidth() + getBoardHeight()]++;
            if (getTileTable()[getBoardWidth() - i - 1][i].tileType == players[actualPlayerNumber].tileusage)
                check[Board.getBoardWidth() + getBoardHeight() + 1]++;
        }

        for (int i : check)
            if (i == 3) {
                winConditionsFullfill = true;
                break;
            }
    }

}
