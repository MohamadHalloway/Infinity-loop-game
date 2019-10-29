package jpp.infinityloop.adapter;

import jpp.infinityloop.BacktrackingSolver;
import jpp.infinityloop.Board;
import jpp.infinityloop.Tile;
import jpp.infinityloop.generatoren.BoardGenerator;
import jpp.infinityloop.generatoren.MatrixGenerator;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TestAdapter implements ITestAdapter<Board> {

    public int width;
    public int height;
    private boolean aufgerufen;

    private BoardGenerator boardGenerator;

    @Override
    public Board decode(byte[] data) {
        BlobCoder blobCoder = new BlobCoder();
        return blobCoder.decode(data);
    }

    @Override
    public byte[] encode(Board board) {
        BlobCoder blobCoder = new BlobCoder();
        return blobCoder.encode(board);
    }

    @Override
    public boolean solve(Board board) {
        BacktrackingSolver backtrackingSolver = new BacktrackingSolver();
        return backtrackingSolver.solve(board);
    }

    @Override
    public void initGenerator(int minWidth, int maxWidth, int minHeight, int maxHeight) {
        this.aufgerufen = true;
        this.width = ThreadLocalRandom.current().nextInt(minWidth, maxWidth + 1);
        this.height = ThreadLocalRandom.current().nextInt(minHeight, maxHeight + 1);

    }

    @Override
    public Board generate() {
        if (!aufgerufen) {
            throw new IllegalStateException();
        }
        BoardGenerator boardGenerator = new MatrixGenerator(width, height);
        Board result = boardGenerator.next();
        result.shuffle();
        return result;
    }

    @Override
    public void rotate(Board board, int column, int row) {
        board.rotate(column, row);
    }


}
