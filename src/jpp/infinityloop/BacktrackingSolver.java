package jpp.infinityloop;

import jpp.infinityloop.adapter.TestAdapter;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class BacktrackingSolver implements Solver {
    Board board;
    Tile[][] boardArray;
    int width;
    int height;
    private Board solvedBoard;

    @Override
    public boolean solve(Board board) {
        this.board = board;
        boardArray = board.getBoardArray();
        return myAlgo(0, 0);

    }

    private boolean myAlgo(int x, int y) {
        width = board.getWidth();
        height = board.getHeight();
        Tile gesucht = boardArray[y][x];
        byte hex = gesucht.getHex();

        //searching the next tile
        int xnext;
        int ynext = 0;
        if (x == width - 1) {    //if in the last column
            if (y == height - 1) {       //if in the last field
                xnext = -1; //when tile the last field in the game
            } else {
                xnext = 0;
                ynext = y + 1;
            }
        } else {
            xnext = x + 1;
            ynext = y;
        }

        //the backStracking solve
        int count = 0;
        if (hex == 0 || hex == 15) {
            count = 3;
        }
        while (count < 4) {
            boolean oben = twelveOclock(x, y, gesucht);
            boolean links = nineOclock(x, y, gesucht);
            if (oben && links){ //if both sides are okay

                if (x != width - 1 && y != height - 1){
                    if (myAlgo(xnext, ynext)){
                        return true;
                    }
                }
                else if (x == width - 1 && y == height - 1){ //last tile
                    if (!gesucht.getRechts() && !gesucht.getUnten()){
                        return true;
                    }
                    return false;
                }

                else if (x == width - 1 && !gesucht.getRechts()){ //last column
                    if (myAlgo(xnext, ynext)){
                        return true;
                    }
                }
                else if (y == height - 1 && !gesucht.getUnten()){
                    if (myAlgo(xnext, ynext)){
                        return true;
                    }
                }
            }
            gesucht.rotateTeil();
            count++;
        }
        return false;


//        System.out.println(board);
//        Tile tile = boardArray[y][x];
//        int hex = tile.getHex();
//        int height = board.getHeight();
//        int width = board.getWidth();
//        int xnext = 0;
//        int ynext = 0;
//        if (x == width - 1) {    //if in the last column
//            if (y == height - 1) {       //if in the last field
//                xnext = -1; //when tile the last field in the game
//            } else {
//                xnext = 0;
//                ynext = y + 1;
//            }
//        } else {
//            xnext = x + 1;
//            ynext = y;
//        }
////        boolean isTee = false;
////        if (hex == 0b1011 || hex == 0b1110|| hex == 0b0111 || hex == 0b1101){
////            isTee = true;
////        }
//
//        int count = 0;
////        if (hex == 0x0f || hex == 0x0) count = 3; //if it was Cross or empty
//        while (count < 4) {
//            boolean links = nineOclock(x, y, tile);
//            boolean oben = twelveOclock(x, y, tile);
//            if (x == width - 1) {     //last column and last tile
//                if (y == height - 1) {   //last field
//                    if (oben && links && (hex & Tile.rechts) == 0 && (hex & Tile.unten) == 0) {
//                        return true;
//                    } else {
//                        tile.rotateTeil();
//                        count++;
//                        continue;
//                    }
//                }
////                if (isTee){
////                    tile.setHex((byte)0b1101);
////                }
//                if (oben && links && (hex & Tile.rechts) == 0) {
//                    if (myAlgo(xnext, ynext)) return true;
//                }
//            } else if (y == height - 1) {    //last row
//                if (oben && links && (hex & Tile.unten) == 0) {
//                    if (myAlgo(xnext, ynext)) return true;
//                }
//            } else {
//                if (oben && links) {
//                    if (myAlgo(xnext, ynext)) {
//                        return true;
//                    }
//                }
//            }
//            tile.rotateTeil();
//            count++;


        //alter Algo
//            for (int j = 0; j <= y; j++) {
//                for (int i = 0; i < x; i++) {
//                    System.out.print(boardArray[j][i]);
//                }
//                System.out.println();
//            }
//            if (x == board.getWidth() - 1){
//                if (links && oben && (tile.getHex() & Tile.rechts) != 0) {
//                    if (xnext >= 0) {
//                        if (myAlgo(xnext, ynext)) {
//                            return true;
//                        }
//                    } else {
//                        if ((tile.getHex() & Tile.unten) > 0 || (tile.getHex() & Tile.rechts) > 0) return false;
//                        else {
//                            return true;
//                        }
//                    }
//                }
//            } else if (y == board.getHeight()){
//                if (links && oben && (tile.getHex() & Tile.unten) != 0) {
//                    if (xnext >= 0) {
//                        if (myAlgo(xnext, ynext)) {
//                            return true;
//                        }
//                    } else {
//                        if ((tile.getHex() & Tile.unten) > 0 || (tile.getHex() & Tile.rechts) > 0) return false;
//                        else {
//                            return true;
//                        }
//                    }
//                }
//            }else {
//                if (links && oben) {
//                    if (xnext >= 0) {
//                        if (myAlgo(xnext, ynext)) {
//                            return true;
//                        }
//                    } else {
//                        if ((tile.getHex() & Tile.unten) > 0 || (tile.getHex() & Tile.rechts) > 0) return false;
//                        else {
//                            return true;
//                        }
//                    }
//                }
//
//            }
//
//
//            tile.rotateTeil();
//            count++;
//        }
//        return false;
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
