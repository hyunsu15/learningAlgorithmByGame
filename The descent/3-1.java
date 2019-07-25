import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

//BernardFrancis 꺼의 코드.
// TreeMap의 특성을 잘이용하여 짠 코드.
//자바8을 이용하여,만든 코드도 리뷰 상위권에 있었지만, 본인생각에는 너무 과하다고 생각했음.

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // game loop
        while (true) {
            TreeMap<Integer, Integer> tree = new TreeMap<Integer, Integer>();
            // 초기화
            for (int i = 0; i < 8; i++) {
                Integer mountainH = in.nextInt(); // represents the height of one mountain, from 9 to 0.
                tree.put(mountainH, i);
            }
            System.out.println(tree.get(tree.lastKey())); // The number of the mountain to fire on.
        }
    }
}
