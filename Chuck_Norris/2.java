import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Solution {

    static StringBuffer answerCalcul;
    static Scanner in = new Scanner(System.in);
    static StringBuffer twoNumber;
    static String n;
    static int number;

    public static void main(String args[]) {
        initialize();
        calculate();

        System.out.println(answerCalcul);

    }

    static void initialize() {
        n = in.nextLine();
        number = n.charAt(0);
        twoNumber = new StringBuffer(Integer.toBinaryString(number));
        twoNumber = fillZeroBySevenLength(twoNumber);
        if (twoNumber.charAt(0) == '1')
            answerCalcul = new StringBuffer("0 0");
        else
            answerCalcul = new StringBuffer("00 0");

    }

    static StringBuffer fillZeroBySevenLength(StringBuffer twoNumber) {
        while (twoNumber.length() != 7) {
            twoNumber.insert(0, 0);
        }
        return twoNumber;
    }

    static void calculate() {
        int endNumber = 0;
        int i = 0;
        do {
            number = n.charAt(i);
            twoNumber = new StringBuffer(Integer.toBinaryString(number));
            twoNumber = fillZeroBySevenLength(twoNumber);
            answerCalculate(endNumber);
            i++;
            endNumber = twoNumber.charAt(twoNumber.length() - 1);
        } while (i < n.length());

    }

    static void answerCalculate(int endNumber) {
        answerCalculateZero(endNumber);
        answerCalculateOneuptoLength();

    }
    static void  answerCalculateZero(int endNumber){
         if (endNumber != 0 && twoNumber.charAt(0) == endNumber)
            answerCalcul.append(0);
        else if (endNumber == '0' && twoNumber.charAt(0) != endNumber)
            answerCalcul.append(" 0 0");
        else if (endNumber == '1' && twoNumber.charAt(0) != endNumber)
            answerCalcul.append(" 00 0");
       
    }
    static void answerCalculateOneuptoLength() {
        for (int i = 1; i < twoNumber.length(); i++) {

            if (twoNumber.charAt(i - 1) == twoNumber.charAt(i))
                answerCalcul.append(0);

            if (twoNumber.charAt(i - 1) != twoNumber.charAt(i) && twoNumber.charAt(i) == '1')
                answerCalcul.append(" 0 0");

            if (twoNumber.charAt(i - 1) != twoNumber.charAt(i) && twoNumber.charAt(i) == '0')
                answerCalcul.append(" 00 0");
        }
    }
}
