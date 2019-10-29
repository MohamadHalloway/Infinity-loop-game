package jpp.infinityloop.generatoren;

import jpp.infinityloop.Board;
import jpp.infinityloop.adapter.TestAdapter;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.time.temporal.Temporal;
import java.util.*;

public class FilesGenerator implements BoardGenerator {
    Iterator<File> fileIterator;

    public FilesGenerator() {
        File file = new File("C:\\Users\\s353177\\IdeaProjects\\InfinityLoop\\testFiles");
        List<File> list = Arrays.asList(Objects.requireNonNull(file.listFiles()));
        this.fileIterator = list.iterator();
    }

    @Override
    public Board next() {
        if (hasnext()) {
            File file = fileIterator.next();
            byte[] boardAsBytes = new byte[0];
            try {
                boardAsBytes = Files.readAllBytes(file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
            TestAdapter testAdapter = new TestAdapter();
            return testAdapter.decode(boardAsBytes);
        } else {
            return null;
        }

    }

    @Override
    public boolean hasnext() {
        return fileIterator.hasNext();
    }
}
