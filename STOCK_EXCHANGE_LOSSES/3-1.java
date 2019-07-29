import java.util.*;

//Cheatah의 코드

//나는 쉽게 생각하기 위해, 최고값과 최소값을 따로 따로 생각해서 만듬.
// 이 코드는 그것을 이미 계산을 해서 만듬.

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int maxDrawdown = 0, maxValue = 0;
        for (int i = 0; i < n; i++) {
            int v = in.nextInt();
            maxValue = Math.max(maxValue, v);
            maxDrawdown = Math.min(maxDrawdown, v - maxValue);
        }
        System.out.println(maxDrawdown);
    }
}