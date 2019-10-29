package jpp.infinityloop.generatoren;

import jpp.infinityloop.Board;

public interface BoardGenerator {

    Board next();
    boolean hasnext();
}
