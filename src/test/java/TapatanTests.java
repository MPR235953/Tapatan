import app.tapatan.classes.Board;
import app.tapatan.classes.Point;
import app.tapatan.classes.Tile;
import app.tapatan.classes.TileType;
import org.junit.Assert;
import org.junit.Test;

public class TapatanTests {
    @Test
    public void testBoardBoundary() {
        Board board = new Board();
        Point p = new Point();
        boolean check;
        for(int y = 0; y < 3; y++) {
            p.y = y;
            for(int x = 0; x < 3; x++) {
                p.x = x;
                check = Board.isOutOfBound(p);
                Assert.assertFalse(check);
            }
        }
        for(int x = 0; x < 3; x++) {
            p.x = x;
            p.y = x % 2 == 0 ? 4 : -1;
            check = Board.isOutOfBound(p);
            Assert.assertTrue(check);
        }
        for(int y = 0; y < 3; y++) {
            p.y = y;
            p.x = y % 2 == 0 ? 4 : -1;
            check = Board.isOutOfBound(p);
            Assert.assertTrue(check);
        }
    }

    @Test
    public void testIfEmptyType() {
        Board board = new Board();
        Tile tile;
        for(int y = 0; y < 3; y++) {
            for(int x = 0; x < 3; x++) {
                tile = Board.tileTable[y][x];
                Assert.assertSame(tile.tileType, TileType.TILE_EMPTY);
            }
        }
    }

}
