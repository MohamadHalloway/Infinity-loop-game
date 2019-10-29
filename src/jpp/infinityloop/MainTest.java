package jpp.infinityloop;

import javafx.scene.layout.BorderPane;
import jpp.infinityloop.adapter.BlobCoder;
import jpp.infinityloop.adapter.TestAdapter;
import jpp.infinityloop.generatoren.BoardGenerator;
import jpp.infinityloop.generatoren.FilesGenerator;
import jpp.infinityloop.generatoren.MatrixGenerator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.sql.Time;
import java.time.LocalTime;
import java.util.*;



/*1-was sind thresholds?
 */

public class MainTest {

    public static void main(String[] args) {


        MainTest mainTest = new MainTest();
        int count = 1;
        byte[] encodedBoard = {(byte) 0xe2, (byte) 0x88, (byte) 0x9e, 3, 0, 0, 0, 2, 0, 0, 0, (byte) 0x31, (byte) 0x11, (byte) 0x13};
        BlobCoder blobCoder = new BlobCoder();
        Board board = blobCoder.decode(encodedBoard);
        byte[] testEncode = blobCoder.encode(board);
        System.out.print("{ ");
        for (int i = 0; i < testEncode.length; i++) {
            System.out.print(Integer.toHexString(testEncode[i]) + " ");
        }
        System.out.println(" }");
        BoardGenerator boardGenerator = new FilesGenerator();
        Board board1 = boardGenerator.next();
//        System.out.println( count + "\n" + board1);
//        count++;
        Board board2 = boardGenerator.next();
//        System.out.println( count + "\n" + board2);
//        count++;
        Board board3 = boardGenerator.next();
//        System.out.println( count + "\n" + board3);
//        count++;
        Board board4 = boardGenerator.next();
//        System.out.println( count + "\n" + board4);
//        count++;
        Board board5 = boardGenerator.next();
//        System.out.println( count + "\n" + board5);
//        count++;
        Board board6 = boardGenerator.next();
//        System.out.println( count + "\n" + board6);
//        count++;
        Board board7 = boardGenerator.next();
//        System.out.println( count + "\n" + board7);
//        count++;
        Board board8 = boardGenerator.next();
//      System.out.println( count + "\n" + board8);
//      count++;
        Board board9 = boardGenerator.next();
//        System.out.println(count + "\n" + board9);
//        count++;
        Board board10 = boardGenerator.next();
//        System.out.println(count + "\n" + board10);
//        count++;
        Board board11 = boardGenerator.next();
//        System.out.println(count + "\n" + board11);
//        count++;
        Board board12 = boardGenerator.next();
//        System.out.println(count + "\n" + board12);
//        count++;
        Board board13 = boardGenerator.next();
//        System.out.println(count + "\n" + board13);
//        count++;
        Board board14 = boardGenerator.next();
//        System.out.println(count + "\n" + board14);
//        count++;
        Board board15 = boardGenerator.next();
//        System.out.println(count + "\n" + board15);
//        count++;
        Board board16 = boardGenerator.next();
//        System.out.println(count + "\n" + board16);
//        count++;
        Board board17 = boardGenerator.next();
//        System.out.println(count + "\n" + board17);
//        count++;


//        System.out.println("Here starts the Algo!");
        BacktrackingSolver backtrackingSolver = new BacktrackingSolver();
//        System.out.println(backtrackingSolver.solve(board7));


//            solve testing
        System.out.println(Time.valueOf(LocalTime.now()));
        TestAdapter testAdapter = new TestAdapter();
        testAdapter.initGenerator(20, 20, 20, 20);
        Board generated = testAdapter.generate();
        byte[] date = testAdapter.encode(board7);
        testAdapter.decode(date);
        System.out.println(board7);
        System.out.println(testAdapter.solve(board7));
        System.out.println(board7);
        System.out.println("Is the Board solved? " + board7.checkSolved());
        System.out.println(Time.valueOf(LocalTime.now()));


//        System.out.println("width of Board: "+ board.getWidth());
//        System.out.println( "height of board: "+ board.getHeight());
//        System.out.println(board);
//        Scanner scanner = new Scanner(System.in);

//        while (!board.checkSolved()){
//            System.out.println("Enter coordinate of the tile to rotate: ");
//            int s = scanner.nextInt();
//            int x = s % 10;
//            int y = s / 10;
//            board.rotate(x, y);
//            System.out.println(board);
//        }
//        System.out.println("Board solved!");
    }


    public void printGame(Board board) {
        int height = board.getHeight();
        int width = board.getWidth();
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                System.out.print(board.getTiles().get(((h * 2) + w)));

            }
            System.out.println();
        }
    }

    public byte[] separate(byte mixed) {
        byte[] result = new byte[2];
        result[0] = (byte) ((mixed >> 4) & 0x0F);
        result[1] = (byte) ((mixed) & 0x0f);
        return result;
    }

    public byte mix(byte b1, byte b2) {
        byte mixed = (byte) ((b1 << 4) | (b2 & 0x0F));
        return mixed;
    }

    public String[] hexarray(byte[] byteArray) {
        String[] result = new String[byteArray.length];

        for (int i = 0; i < byteArray.length; i++) {
            result[i] = Integer.toHexString(byteArray[i]);
        }
        return result;
    }

    public String toHex(String arg) {
        return String.format("%040x", new BigInteger(1, arg.getBytes(/*YOUR_CHARSET?*/)));
    }

    public int oneOrZero(int n) {
        if (n == 0) return 0;
        else return 1;
    }

    public int byteArrayToInt(byte[] array) {
        int x = array[0] << 24 | (array[1] << 16 | (array[2] << 8 | (array[3])));
        return x;
    }

    public byte[] intToByteArray(int number) {
        if (number > 508 || number < 0) throw new IllegalStateException("width or height doesn't match");
        byte[] b = new byte[4];
        int count = 0;
        while (count < 4) {
            if (number > 127) {
                b[count] = 127;
                number -= 127;
                count++;
            } else {
                b[count] = (byte) number;
                number = 0;
                count++;
            }
        }
        return b;
    }
}
