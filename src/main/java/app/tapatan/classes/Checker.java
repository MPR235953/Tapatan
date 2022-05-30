package app.tapatan.classes;

import app.tapatan.TapatanGame;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Checker extends ImageView {
    public double mouseX, mouseY;
    public double oldX, oldY;

    public Checker(Image img, int x, int y) {
        move(x,y);
        this.setImage(img);

        this.setOnMousePressed( e -> {
            mouseX = e.getSceneX();
            mouseY = e.getSceneY();
            setCursor(Cursor.MOVE);
            System.out.println("Mouse X, Y: " + mouseX + " " + mouseY);
        });

        this.setOnMouseDragged( e -> relocate(e.getSceneX() - 100, e.getSceneY() - 100));
    }

    public void move(int x, int y) {
        oldX = x * TapatanGame.TILE_SIZE;
        oldY = y * TapatanGame.TILE_SIZE + TapatanGame.BOARD_Y_OFFSET;
        relocate(oldX, oldY);
    }

    public void abortMove() {
        relocate(oldX, oldY);
    }
}
