import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse
        int[] number = new int[n];
        int max = Integer.MAX_VALUE - 1;
        boolean isSame = false;

        for (int i = 0; i < n; i++) {
            number[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (Math.abs(max) > Math.abs(number[i])) {
                max = number[i];
                isSame = false;
            }
            if (Math.abs(max) == Math.abs(number[i]) && max != number[i]) {
                isSame = true;
            }
        }

        if (isSame)
            max = Math.abs(max);
        else if (n == 0)
            max = 0;
        System.out.println(max);

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

    }
}