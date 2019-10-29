package jpp.infinityloop;

import java.util.*;
import java.util.concurrent.TimeoutException;

import static java.util.Collections.shuffle;

public class Board {
    private int width;
    private int height;
    private List<Tile> tiles;
    private Tile[][] boardArray;


    public Board(int x, int y, List<Tile> z) {
        width = x;
        height = y;
        tiles = new ArrayList<>(z);
        Iterator<Tile> iterator = tiles.iterator();
        boardArray = new Tile[height][width];
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                boardArray[j][i] = iterator.next();
            }
        }

    }

    public boolean checkSolved() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!nineOclock(j,i,boardArray[i][j])) {
                    return false;
                }
                if (!twelveOclock(j,i,boardArray[i][j])) {
                    return false;
                }
            }
        }
        return true;


    }

    public void shuffle() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int r = new Random().nextInt(4);
                for (int k = 0; k < r; k++){
                    rotate(j, i);
                }
            }
        }

    }

    public void rotate(int x, int y) {
        if (x >= width || x < 0 || y >= height || y < 0) {
            throw new IllegalArgumentException("x or y is too big or under 0");
        }
        Tile gesucht = tiles.get((y * width) + x);
        gesucht.rotateTeil();

    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Tile[][] getBoardArray() {
        return boardArray;
    }

    public String toString(){
        String result = "";
        int height = getHeight();
        int width = getWidth();
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                result += boardArray[h][w];

            }
            result += "\n";
        }
        return result;
    }

    private Tile getObigerTeil(int x, int y) {
        if (y != 0) {
            return boardArray[y - 1][x];
        }
        return new Tile((byte) 0);
    }

    private Tile getLinkerTeil(int x, int y) {
        if (x != 0) {
            return boardArray[y][x - 1];
        }
        return new Tile((byte) 0);
    }

    private boolean nineOclock(int x, int y, Tile tile) {
        Tile linkerTeil = getLinkerTeil(x, y);
        return tile.getLinks() == linkerTeil.getRechts();
    }

    private boolean twelveOclock(int x, int y, Tile tile) {
        Tile obigerTeil = getObigerTeil(x, y);
        return tile.getOben() == obigerTeil.getUnten();
    }

}
