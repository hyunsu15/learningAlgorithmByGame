import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Solution {

    static StringBuffer answerCalcul;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String n = in.nextLine(); // the number of temperatures to analyse
        int number = n.charAt(0);
        StringBuffer twoNumber = new StringBuffer(Integer.toBinaryString(number));
        while(twoNumber.length()!=7)
        {
        	twoNumber.insert(0, 0);
        }
        int endNumber= 0;
        
        if (twoNumber.charAt(0) == '1')
            answerCalcul = new StringBuffer("0 0");
        else
            answerCalcul = new StringBuffer("00 0");
        int i = 0;
        do {
        	number =n.charAt(i);
        	twoNumber=new StringBuffer(Integer.toBinaryString(number));
        	 while(twoNumber.length()!=7)
             {
             	twoNumber.insert(0, 0);
             }
        	 
        	 
        	answerCalculate(twoNumber,endNumber);
            i++;
            endNumber= twoNumber.charAt(twoNumber.length()-1);
        } while (i < n.length());

        System.out.println(answerCalcul);

    }

    static void answerCalculate(StringBuffer twoNumber,int endNumber) {
    	if(endNumber!=0&&twoNumber.charAt(0)==endNumber)
    		answerCalcul.append(0);
    	else if(endNumber=='0'&&twoNumber.charAt(0)!=endNumber)
    		answerCalcul.append(" 0 0");
    	else if(endNumber=='1'&&twoNumber.charAt(0)!=endNumber)
    		answerCalcul.append(" 00 0");
    	
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
