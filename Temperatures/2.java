import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
    static Scanner in;
    static int temperaturesNumber;
    static int[] number;
    static int max;
    static boolean isSame;

    public static void main(String args[]) {

        initialize();
        judgeMaxAndisSame();
        calculateMax();
        System.out.println(max);

    }

    static void initialize() {
        in = new Scanner(System.in);
        temperaturesNumber = in.nextInt(); // the number of temperatures to analyse
        number = new int[temperaturesNumber];
        max = Integer.MAX_VALUE - 1;
        isSame = false;
        for (int i = 0; i < temperaturesNumber; i++) {
            number[i] = in.nextInt();
        }
    }

    static void judgeMaxAndisSame() {
        for (int i = 0; i < temperaturesNumber; i++) {
            if (Math.abs(max) > Math.abs(number[i])) {
                max = number[i];
                isSame = false;
            }
            if (Math.abs(max) == Math.abs(number[i]) && max != number[i]) {
                isSame = true;
            }
        }
    }

    static void calculateMax() {
        if (isSame)
            max = Math.abs(max);
        else if (temperaturesNumber == 0)
            max = 0;

    }

}