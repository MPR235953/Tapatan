package app.tapatan.classes;

import app.tapatan.GameController;
import app.tapatan.TapatanGame;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.util.Random;

import static app.tapatan.classes.Board.tileTable;
import static app.tapatan.classes.TileType.TILE_EMPTY;


public class Tile extends Rectangle {
    public TileType tileType = TileType.TILE_EMPTY;
    public Point point = new Point();

    public Tile(int x, int y){
        point.x = x;
        point.y = y;
        this.setWidth(TapatanGame.TILE_SIZE);
        this.setHeight(TapatanGame.TILE_SIZE);
        this.relocate(x * TapatanGame.TILE_SIZE, y * TapatanGame.TILE_SIZE);
        this.setFill(Color.TRANSPARENT);
        this.setStroke(Color.WHITE);

        /** utworzenie pionka po kliknieciu w kafelek i nadanie kafelkowi odpowiednich atrybutow */
        this.setOnMouseClicked(e ->{
            if(this.tileType == TILE_EMPTY){
                ///TODO: dodac warunek/funkcje sprawdzajaca czy gracz moze jeszcze postawic pionki tj. moze max 3 (np poprzez jakis licznik lub przejsciu przez mape i zliczajca TileType aktualnego gracza)
                ///TODO: podczas tury 2 nalezy zablokowac mozliwosc stawiania pionkow
                ///TODO: uzaleznic pojawianie sie pionkow od aktualnego gracza (team water i fire)
                this.tileType = TileType.TILE_IN_USE;
                int randomIndex = new Random().nextInt(GraphicLinkArray.FireImages.size());
                //sa 2 arraye z grafikami w GraphicLinkArray dla teamu fire i water w zaleznosci od gracza
                Image image = new Image(new File("src/main/resources/app/tapatan/arts/" + GraphicLinkArray.FireImages.get(randomIndex)).toURI().toString());
                GraphicLinkArray.FireImages.remove(randomIndex);       //usuwanie kolejnych grafik, aby grafiki pionkow sie nie powtarzaly
                this.setStroke(Color.ORANGE);       //kolor w zaleznosci od gracza
                Checker checker = new Checker(image, x, y);
                GameController.staticBoardPane.getChildren().add(checker);       //wyswietlenie grafiki poprzez statycznego Pane

                checker.showCheckerInfo("Initialize", e.getSceneX(), e.getSceneY());
            }
        });
    }

    public void setTileType(TileType tileType) {
        this.tileType = tileType;
    }

    boolean isEmpty(Point p) {
        return tileTable[p.x][p.y].tileType == TILE_EMPTY;
    }

    /** sprawdza czy na kafelku nie ma pionka (bezparametrowa) */
    boolean isEmpty(){ return this.tileType == TILE_EMPTY; }
}
