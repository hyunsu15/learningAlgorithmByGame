import java.util.*;
import java.io.*;
import java.math.*;

//d-mark 의코드

//내가 처음에 구현하고싶었던 조금 비효율적이지만, 정확한 코드를 구현함.
//다른사람들은 내꺼와 비슷하게 결국 갔는데, 이분은 대단하다.

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c = in.nextInt();
        int t = 0;
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
            t += b[i];
        }

        if (t < c) {
            System.out.println("IMPOSSIBLE");
        } else {
            int[] r = new int[n];

            while (c > 0) {
                for (int i = 0; i < n; i++) {
                    if (c > 0 && b[i] > 0) {
                        r[i]++;
                        b[i]--;
                        c--;
                    }
                }
            }

            Arrays.sort(r);
            for (int i : r) {
                System.out.println(i);
            }
        }
    }
}