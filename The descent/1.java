import java.util.*;
import java.io.*;
import java.math.*;

class Player {

    static int[] moutain = new int[8];
    static int max;
    static int maxIndex;
    static Scanner in = new Scanner(System.in);

    public static void main(String args[]) {
        // game loop
        while (true) {
            mountainInitial();
            findMaxIndex();
            System.out.println(maxIndex);
        }
    }

    static void mountainInitial() {
        for (int i = 0; i < moutain.length; i++)
            moutain[i] = in.nextInt();
        max = 0;
        maxIndex = 0;
    }

    static void findMaxIndex() {
        for (int i = 0; i < moutain.length; i++)
            if (max < moutain[i]) {
                max = moutain[i];
                maxIndex = i;
            }

    }
}