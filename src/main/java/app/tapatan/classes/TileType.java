package app.tapatan.classes;

public enum TileType {
    TILE_IN_USE_PLAYER_1(0),
    TILE_IN_USE_PLAYER_2(1),
    TILE_EMPTY(3),
    TILE_IN_USE(4);

    final int status;

    TileType(int t){
        status = t;
    }

}
