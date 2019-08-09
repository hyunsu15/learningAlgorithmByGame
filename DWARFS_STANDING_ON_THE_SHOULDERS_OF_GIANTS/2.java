import java.util.*;
import java.io.*;
import java.math.*;

//1.java를 짠 것처럼하면, 다시 만들때 구체적으로 만들어줘야하며, 힘들다.
// 2.java에서는 HashMap을 이용하여, 그래프를 만들려고한다.
class Solution {

    static HashMap<Integer, ArrayList<Integer>> graph = new HashMap();

    public static void main(String args[]) {

        initialize();
        printResult();
    }

    static void initialize() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (graph.get(x) == null)
                graph.put(x, new ArrayList());
            graph.get(x).add(y);
        }
    }

    public static void printResult() {
        int max = 0;
        for (Integer i : graph.keySet())
            max = Math.max(max, calculateLength(graph.get(i)));
        System.out.println(max);
    }

    public static int calculateLength(ArrayList<Integer> arrayList) {
        if (arrayList == null || arrayList.isEmpty())
            return 1;

        int max = 0;
        for (Integer i : arrayList) {
            max = Math.max(max, calculateLength(graph.get((i))));
        }
        return max + 1;
    }

}