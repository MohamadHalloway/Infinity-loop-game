package jpp.infinityloop.generatoren;

import jpp.infinityloop.Board;

import java.util.Random;

public class ShuffledGenerator implements BoardGenerator {
    @Override
    public Board next() {
        int x = new Random().nextInt(508);
        int y = new Random().nextInt(508);
        BoardGenerator boardGenerator = new MatrixGenerator(x, y);
        return boardGenerator.next();
    }

    @Override
    public boolean hasnext() {
        return true;
    }
}
