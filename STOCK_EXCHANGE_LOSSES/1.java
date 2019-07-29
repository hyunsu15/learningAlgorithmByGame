import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Solution {

    static long[] investArray;
    static int index = 0;

    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        initialize();
        System.out.println(judgePoint());

    }

    static void initialize() {
        int num = sc.nextInt();
        investArray = new long[num];
        for (int i = 0; i < num; i++)
            investArray[i] = sc.nextInt();

    }

    static long judgePoint() {
        long highPoint = investArray[0];
        long lowPoint = investArray[0];
        long result = 0;
        for (int i = 1; i < investArray.length; i++) {
            if (highPoint < investArray[i]) {
                highPoint = investArray[i];
                lowPoint = investArray[i];
            }
            if (lowPoint > investArray[i]) {
                lowPoint = investArray[i];
                if (result > lowPoint - highPoint)
                    result = lowPoint - highPoint;
            }
        }
        return result;
    }

}