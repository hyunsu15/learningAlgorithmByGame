import java.util.*;
import java.io.*;
import java.math.*;

//lucaslagessr의코드

//우선 코드줄이 짧으며, 내가 처음에 작성해보고 싶었던 코드였음.(실패해서 우회함.)

//추가했으면 하는것은 아무래도 result 에 들어가는식 한번에 알아보긴 힘듬. 이걸 함수로 변경해서 하면 더 좋은 코드가 될듯 함.

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        Integer result = null;

        while (in.hasNextInt()) {
            int temp = in.nextInt();
            result = result == null || Math.abs(temp) < Math.abs(result)
                    || (Math.abs(temp) == Math.abs(result) && temp > 0) ? temp : result;
        }



        System.out.println(result == null ? 0 : result);
    }
}