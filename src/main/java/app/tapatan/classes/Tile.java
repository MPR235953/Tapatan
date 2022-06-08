package app.tapatan.classes;

import app.tapatan.TapatanGame;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.util.Random;

import static app.tapatan.GameController.*;
import static app.tapatan.classes.GameLoop.*;
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

        //utworzenie pionka po kliknieciu w kafelek i nadanie kafelkowi odpowiednich atrybutow
        this.setOnMouseClicked(e ->{
            if(!phase1Complete) {
                if (this.tileType == TILE_EMPTY) {
                    this.tileType = players[actualPlayerNumber].tileusage;

                    if (actualPlayerNumber == 0) {
                        int randomIndex = new Random().nextInt(GameLoop.FireImagesUnused.size());
                        Image image = new Image(new File("src/main/resources/app/tapatan/arts/" + GameLoop.FireImagesUnused.get(randomIndex)).toURI().toString());
                        GameLoop.FireImagesUsed.add(GameLoop.FireImagesUnused.get(randomIndex));
                        GameLoop.FireImagesUnused.remove(randomIndex);

                        Checker checker = new Checker(image, x, y);
                        staticBoardPane.getChildren().add(checker);
//                        checker.showCheckerInfo("Initialize", e.getSceneX(), e.getSceneY());
                    } else {
                        int randomIndex = new Random().nextInt(GameLoop.WaterImagesUnused.size());
                        Image image = new Image(new File("src/main/resources/app/tapatan/arts/" + GameLoop.WaterImagesUnused.get(randomIndex)).toURI().toString());
                        GameLoop.WaterImagesUsed.add(GameLoop.WaterImagesUnused.get(randomIndex));
                        GameLoop.WaterImagesUnused.remove(randomIndex);       //usuwanie kolejnych grafik, aby grafiki pionkow sie nie powtarzaly

                        Checker checker = new Checker(image, x, y);
                        staticBoardPane.getChildren().add(checker);       //wyswietlenie grafiki poprzez statycznego Pane
//                        checker.showCheckerInfo("Initialize", e.getSceneX(), e.getSceneY());
                    }
                    winCheck();
                    if (winConditionsFullfill)
                        gameEndAppear();
                    else
                        changeTurnPlayerNr();
                    if (GameLoop.FireImagesUnused.isEmpty() && GameLoop.WaterImagesUnused.isEmpty())
                        phase1Complete = true;
                }
            }
        });
    }

    /** sprawdza czy na kafelku nie ma pionka (bezparametrowa) */
    boolean isEmpty(){ return this.tileType == TILE_EMPTY; }
}
