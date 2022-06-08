package app.tapatan.classes;

import app.tapatan.TapatanGame;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static app.tapatan.GameController.*;
import static app.tapatan.classes.Board.tileTable;
import static app.tapatan.classes.GameLoop.*;

public class Checker extends ImageView {
    private final Point pressedPoint = new Point();
    private final Point releasedPoint = new Point();

    public Checker(Image img, int x, int y) {

        this.setImage(img);
        this.relocate(x * TapatanGame.TILE_SIZE, y * TapatanGame.TILE_SIZE);

        this.setOnMousePressed( e -> {
            if (phase1Complete){
                setCursor(Cursor.MOVE);
                pressedPoint.x = (int) (e.getSceneX() / TapatanGame.TILE_SIZE);
                pressedPoint.y = (int) ((e.getSceneY() - TapatanGame.BOARD_Y_OFFSET) / TapatanGame.TILE_SIZE);

                    if (tileTable[pressedPoint.x][pressedPoint.y].tileType == players[actualPlayerNumber].tileusage) {
                        if (pressedOK())
                            setPressedPosition(TileType.TILE_EMPTY);
//                        showCheckerInfo("Pressed", e.getSceneX(), e.getSceneY());
                        fieldClickControl = false;
                    }
                    else{
                        fieldClickControl = true;
                    }
            }
        });

        this.setOnMouseDragged( e -> {
            if (!fieldClickControl && pressedOK())
                relocate(e.getSceneX() - this.getImage().getWidth() / 2, e.getSceneY() - this.getImage().getHeight());
        });

        this.setOnMouseReleased(e -> {
            if (fieldClickControl || !phase1Complete) return;
            releasedPoint.x = (int) (e.getSceneX() / TapatanGame.TILE_SIZE);
            releasedPoint.y = (int) ((e.getSceneY() - TapatanGame.BOARD_Y_OFFSET) / TapatanGame.TILE_SIZE);
            if (pressedOK() && releasedOK()) {
                setReleasedPosition(players[actualPlayerNumber].tileusage);
                winCheck();
                if (winConditionsFullfill) gameEndAppear();
                else changeTurnPlayerNr();
            }
            else setPressedPosition(players[actualPlayerNumber].tileusage);
        });
    }

    /** zwraca true jeżeli:
     1. aktualna tura to umozliwia
     2. aktualny gracz porusza swoim pionkiem*/
    boolean pressedOK(){
        return phase1Complete && !winConditionsFullfill;
    }

    /** zwraca true jeżeli:
     1. przesunięcie pionka jest na mapie
     2. pole jest puste
     3. przesuwamy sie o jedno pole
     4. przesunięcie na skos jest zgodne ze ścieżkami na mapie
     5. gracz zmienil pole na inne*/
    boolean releasedOK(){
        return !Board.isOutOfBound(releasedPoint) && tileTable[releasedPoint.x][releasedPoint.y].isEmpty() && !isDoubleMove() && !isIllegalCrossMove() && !isNoMove();
    }

    /** zwraca true jesli pionek przesunie sie o 2 pola */
    boolean isDoubleMove(){
        return Math.abs(pressedPoint.x - releasedPoint.x) == 2 || Math.abs(pressedPoint.y - releasedPoint.y) == 2;
    }

    /** zwraca true jesli pionek wykonuje ruch na skos niezgodznie ze sciezkami na mapie */
    boolean isIllegalCrossMove(){
        return (pressedPoint.x == 0 && pressedPoint.y == 1 ||
                pressedPoint.x == 1 && pressedPoint.y == 0 ||
                pressedPoint.x == 1 && pressedPoint.y == 2 ||
                pressedPoint.x == 2 && pressedPoint.y == 1) &&
                Math.abs(pressedPoint.x - releasedPoint.x) == 1 &&
                Math.abs(pressedPoint.y - releasedPoint.y) == 1;
    }

    boolean isNoMove(){
        return pressedPoint.x == releasedPoint.x && pressedPoint.y == releasedPoint.y;
    }

    /** Umieszcza pionek na pozycji po zdarzeniu "Upuszczenia" */
    void setReleasedPosition(TileType tileType){
        relocate(releasedPoint.x * TapatanGame.TILE_SIZE, releasedPoint.y * TapatanGame.TILE_SIZE);
        tileTable[releasedPoint.x][releasedPoint.y].tileType = tileType;
    }

    /** Umieszcza pionek na pozycji po zdarzeniu "Wcisnięcia" */
    void setPressedPosition(TileType tileType){
        relocate(pressedPoint.x * TapatanGame.TILE_SIZE, pressedPoint.y * TapatanGame.TILE_SIZE);
        tileTable[pressedPoint.x][pressedPoint.y].tileType = tileType;
    }

    /** Do debbugowania, pokazuje powstawowe informacje o pionku i zdarzeniu*/
    void showCheckerInfo(String event, double x, double y){
        System.out.println(event);
        System.out.println("Checker: " + this);
        System.out.println("Checker cords: (" + this.getLayoutX() + "," + this.getLayoutY() + ")");
        System.out.println("Mouse cords: (" + x + "," + (y - TapatanGame.BOARD_Y_OFFSET) + ")");
        System.out.print("Indexes: ");
        if(event.equals("Pressed"))
            pressedPoint.showPoint();
        else if(event.equals("Released"))
            releasedPoint.showPoint();
        else
            System.out.println("");
        System.out.println("Board:");
        Board.showBoardTypes();
    }
}
