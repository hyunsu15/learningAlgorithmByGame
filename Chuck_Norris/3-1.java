import java.util.*;
import java.io.*;
import java.math.*;

//ProkurorNSK의 코드
// 나머지 코드는 참신한것도 몇개 있긴햇음.
// 하지만 읽기 힘든 코드라고 생각함.

// 그나마 이게 제일 읽기 쉽고, 나와 조건 방식이 달라고 생각해서 옮겨씀.
//이것도 근데 내꺼랑 비슷하다고 생각함.

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();

        System.err.println(MESSAGE);
        
        
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        String binaryString = "";
        String result = "";
        char currentSymbol = ' ';
        String code;

        for (char symbol : MESSAGE.toCharArray()) {
            code = Integer.toBinaryString(symbol);
            for (int i = 0; i < 7 - code.length(); i++) {
                code = "0" + code;
            }
            binaryString += code;
        }

        System.err.println(binaryString);
        
        for (char symbol : binaryString.toCharArray()) {
            if (symbol != currentSymbol) {
                if (symbol == '1') {
                    result += " 0 0";
                } else {
                    result += " 00 0";
                }
                currentSymbol = symbol;
            } else {
                result += "0";
            }
        }
        System.out.println(result.trim());
    }
}
  