package app.tapatan.classes;

import app.tapatan.TapatanGame;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Checker extends ImageView {
    private final Point pressedPoint = new Point();
    private final Point releasedPoint = new Point();

    public Checker(Image img, int x, int y) {

        this.setImage(img);
        this.relocate(x * TapatanGame.TILE_SIZE, y * TapatanGame.TILE_SIZE);

        this.setOnMousePressed( e -> {
            setCursor(Cursor.MOVE);
            pressedPoint.x = (int)(e.getSceneX() / TapatanGame.TILE_SIZE);
            pressedPoint.y = (int)((e.getSceneY() - TapatanGame.BOARD_Y_OFFSET) / TapatanGame.TILE_SIZE);
            setPressedPosition(TileType.TILE_EMPTY, Color.WHITE);
            showCheckerInfo("Pressed", e.getSceneX(), e.getSceneY());
        });

        this.setOnMouseDragged( e -> relocate(e.getSceneX() - this.getImage().getWidth() / 2, e.getSceneY() - this.getImage().getHeight()));

        this.setOnMouseReleased(e ->{
            releasedPoint.x = (int)(e.getSceneX() / TapatanGame.TILE_SIZE);
            releasedPoint.y = (int)((e.getSceneY() - TapatanGame.BOARD_Y_OFFSET) / TapatanGame.TILE_SIZE);
            if(moveOK()) setReleasedPosition(TileType.TILE_IN_USE, Color.RED);
            else setPressedPosition(TileType.TILE_IN_USE, Color.RED);
            showCheckerInfo("Released", e.getSceneX(), e.getSceneY());
        });
    }

    /** zwraca true jeżeli:
     1. przesunięcie pionka jest na mapie
     2. pole jest puste
     3. przesuwamy sie o jedno pole
     4. aktualna tura to umozliwia */
    boolean moveOK(){
        ///TODO: Nalezy dodac jeszcze jeden warunek aby ruch nie byl mozliwy jezeli jest runda 1 (tylko ustawianie pionkow na mapie)
        return !Board.isOutOfBound(releasedPoint) && Board.tileTable[releasedPoint.x][releasedPoint.y].isEmpty() && !isDoubleJump();
    }

    /** zwraca true jesli pionek przesunie sie o 2 pola */
    boolean isDoubleJump(){
        return Math.abs(pressedPoint.x - releasedPoint.x) == 2 || Math.abs(pressedPoint.y - releasedPoint.y) == 2;
    }

    /** Umieszcza pionek na pozycji po zdarzeniu "Upuszczenia" */
    void setReleasedPosition(TileType tileType, Color color){
        relocate(releasedPoint.x * TapatanGame.TILE_SIZE, releasedPoint.y * TapatanGame.TILE_SIZE);
        Board.tileTable[releasedPoint.x][releasedPoint.y].tileType = tileType;
        Board.tileTable[releasedPoint.x][releasedPoint.y].setStroke(color);
    }

    /** Umieszcza pionek na pozycji po zdarzeniu "Wcisnięcia" */
    void setPressedPosition(TileType tileType, Color color){
        relocate(pressedPoint.x * TapatanGame.TILE_SIZE, pressedPoint.y * TapatanGame.TILE_SIZE);
        Board.tileTable[pressedPoint.x][pressedPoint.y].tileType = tileType;
        Board.tileTable[pressedPoint.x][pressedPoint.y].setStroke(color);
    }

    /** Do debbugowania, pokazuje powstawowe informacje o pionku i zdarzeniu*/
    void showCheckerInfo(String event, double x, double y){
        System.out.println(event);
        System.out.println("Checker: " + this);
        System.out.println("Checker cords: (" + x + "," + (y - TapatanGame.BOARD_Y_OFFSET) + ")");
        System.out.println("Mouse cords: (" + this.getLayoutX() + "," + this.getLayoutY() + ")");
        System.out.print("Indexes: ");
        if(event.equals("Pressed")) pressedPoint.showPoint();
        else if(event.equals("Released")) releasedPoint.showPoint();
        else System.out.println("");
        System.out.println("Board:");
        Board.showBoardTypes();
    }
}
