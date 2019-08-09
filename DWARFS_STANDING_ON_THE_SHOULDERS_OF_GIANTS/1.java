import java.util.*;

import java.io.*;
import java.math.*;

//그래프 구현은 인접행렬 or 인접 리스트로 구현할수있음.

class Solution {
    static ArrayList<Str

    public static void main(String[] args) {
        initialize();
        calculate();
        print();
    }

    public static void initialize() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(new StringBuffer(scan.nextInt() + " " + scan.nextInt()));
    }

    public static void calculate() {
        LinkedList<StringBuffer> que = new LinkedList<>();
        que.addAll(list);
        while (!que.isEmpty()) {
            StringBuffer poll = que.poll();
            String[] numberList = poll.toString().split(" ");
            for (int i = 0; i < list.size(); i++) {
                String[] iList = list.get(i).toString().split(" ");
                if (numberList[numberList.length - 1].equals(iList[0])) {
                    StringBuffer temp = new StringBuffer(calculatefrontStr(numberList) + " " + list.get(i));
                    list.add(temp);
                    que.add(temp);
                }
            }
        }
    }

    public static String calculatefrontStr(String[] strList) {
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < strList.length - 1; i++)
            sb.append(strList[i] + " ");
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    public static void print() {
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            String[] str = list.get(i).toString().split(" ");
            max = Math.max(max, str.length);
        }
        System.out.println(max);

    }

}