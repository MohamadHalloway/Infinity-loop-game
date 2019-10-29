package jpp.infinityloop.generatoren;

import jpp.infinityloop.Board;
import jpp.infinityloop.Tile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MatrixGenerator implements BoardGenerator {
    private int widthFactory, heightFactory;
    private List<Tile> solvedBoardTiles;

    public MatrixGenerator(int x, int y) {
        widthFactory = x;
        heightFactory = y;
    }


    @Override
    public Board next() {
        Board generated = generate(widthFactory,heightFactory);
        //saving the solution of this Board
        this.solvedBoardTiles = new ArrayList<>(generated.getTiles());
//        System.out.println("Generated Board before the shuffle(): ");
//        System.out.println(generated);
        generated.shuffle();
        return generated;
    }

    @Override
    public boolean hasnext() {
        return true;
    }

    public List<Tile> getSolvedBoardTiles() {
        return solvedBoardTiles;
    }

    private Board generate(int x, int y){
        List<Tile> result = new ArrayList<>();
        byte[][] byteBoard = new byte[y][x];
        int[] sides = {0,0,0,0};
        for (int h = 0; h < y ; h++){
            for (int w = 0; w < x ; w++){
                //if in the first column
                if (w == 0){
                    sides[0] = 0;
                }
                else {
                    if (oneOrZero((byteBoard[h][w-1] & Tile.rechts)) != 0) sides[0] = 1;    //what the left tile on his right side needs
                    else sides[0] = 0;
                }
                //if in the last column
                if (w == x - 1){
                    sides[2] = 0;
                }
                else {
                    sides[2] = new Random().nextInt(2);
                }


                //if in the first row
                if (h == 0){
                    sides[1] = 0;
                }
                else {
                    if (oneOrZero((byteBoard[h-1][w] & Tile.unten)) != 0) sides[1] = 1; //what the upper tile on his down side needs
                    else {
                        sides[1] = 0;
                    }
                }

                //if in the last row
                if (h == y -1){
                    sides[3] = 0;
                }
                else {
                    sides[3] = new Random().nextInt(2);
                }

                //find the type of tile
                int type = 0;
                int hoch = 0;
                for (int i = 3; i >= 0; i--) {
                    if (sides[i] != 0) {
                        type += Math.pow(2, hoch);
                    }
                    hoch++;
                }
                Tile tile = new Tile((byte) type);


                //making a different between STRAIGHT and BEND
//                if (type == 2 && (sides[0] == sides[2])) { //if it was STRAIGHT
//                    type = 5;
//                }
//                Tile tile = new Tile(type);
//                boolean erledigt = false;
//                while (!erledigt){
//                    if ((oneOrZero(tile.getHex() & Tile.links)) != sides[0]){
//                        tile.rotateTeil();
//                        continue;
//                    }
//                    if ((oneOrZero(tile.getHex() & Tile.oben)) != sides[1]){
//                        tile.rotateTeil();
//                        continue;
//                    }
//                    if ((oneOrZero(tile.getHex() & Tile.rechts)) != sides[2]) {
//                        tile.rotateTeil();
//                        continue;
//                    }
//                    if ((oneOrZero(tile.getHex() & Tile.unten)) != sides[3]){
//                        tile.rotateTeil();
//                        continue;
//                    }
//                    erledigt = true;
//                }

                byteBoard[h][w] = tile.getHex();
                result.add(tile);
                for (int i = 0; i < sides.length ; i++){
                    sides[i] = 0;
                }
//                for(int j = 0 ; j < y; j++){
//                    for(int i = 0 ; i < x ; i++){
//                        if ((y*x) < result.size()){
//                            System.out.print(result.get(y*x));
//                        }
//                    }
//
//                    System.out.println();
//                }
            }
        }

        Board board = new Board(x, y, result);
        return board;
    }
    public int oneOrZero(int n){
        if (n == 0) return 0;
        else return 1;
    }
}
