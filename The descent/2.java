import java.util.*;
import java.io.*;
import java.math.*;

//1과동일.
// 배열을 굳이 안쓰고 해도 될 것 같음.

class Player {

    static int[] mountain = new int[8];
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
        for (int i = 0; i < mountain.length; i++)
            mountain[i] = in.nextInt();
        max = 0;
        maxIndex = 0;
    }

    static void findMaxIndex() {
        for (int i = 0; i < mountain.length; i++)
            if (max < mountain[i]) {
                max = mountain[i];
                maxIndex = i;
            }

    }
}