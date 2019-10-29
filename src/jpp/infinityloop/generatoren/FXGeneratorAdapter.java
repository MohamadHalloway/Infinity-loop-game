package jpp.infinityloop.generatoren;

import jpp.infinityloop.Board;

public class FXGeneratorAdapter implements BoardGenerator {
    @Override
    public Board next() {
        return null;
    }

    @Override
    public boolean hasnext() {
        return false;
    }
}
