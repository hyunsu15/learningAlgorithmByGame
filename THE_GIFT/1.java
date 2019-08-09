import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Solution {

    static Scanner in = new Scanner(System.in);
    static int price;
    static int[] payArray;
    static int[] assetArray;

    public static void main(String args[]) {
        initialize();
        judgeMoney();

    }

    static void initialize() {
        int N = in.nextInt();// 사람수
        price = in.nextInt();// 선물가격

        assetArray = new int[N];
        payArray = new int[N];

        for (int i = 0; i < N; i++) {
            int B = in.nextInt();
            assetArray[i] = B;
        }
        Arrays.sort(assetArray);
    }

    static void judgeMoney() {
        int sum = 0;
        for (int i = 0; i < assetArray.length; i++)
            sum += assetArray[i];

        if (price > sum)
            System.out.println("IMPOSSIBLE");
       
        else {
            calculateMoney();
            printPayArray();
        }
    }

    static void calculateMoney() {
        int i = 0;
        int num = assetArray.length;
        while (i < assetArray.length) {
            int allowance = minMoney(num);
            if (allowance > assetArray[i]) {
                price -= assetArray[i];
                payArray[i] = assetArray[i];
            } else {
                price -= allowance;
                payArray[i] = allowance;
            }
            i++;
            num--;

        }

    }

    static int minMoney(int num) {
        return (int) Math.ceil((double) price / num);
    }

    static void printPayArray() {
        Arrays.sort(payArray);
        for (int i = 0; i < payArray.length; i++)
            System.out.println(payArray[i]);
    }

}