import java.util.*;
import java.io.*;
import java.math.*;

//Superflight의 코드

//나도 이차원 배열이 헷갈려서 그냥 배열 두개로 나눠서 할까 고민했었음
// 이차원배열도 쓸줄 알아야된다고 생각해서, 그냥 이차원배열로함.

//참신하다고 느낀것이 프린트 부분을 아주 짧게 만든것 같다.

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt();
        int height = in.nextInt();
        in.nextLine();

        Vector<Integer> vX = new Vector<Integer>(1, 1);
        Vector<Integer> vY = new Vector<Integer>(1, 1);

        for (int y = 0; y < height; y++) // saving coordinates of nodes
        {
            String line = in.nextLine();
            for (int x = 0; x < width; x++) {
                if (line.charAt(x) == '0') {
                    vX.add(x);
                    vY.add(y);
                }
            }
        }

        for (int i = 0; i < vX.size(); i++) {
            int cX = vX.get(i);
            int cY = vY.get(i);
            int nY = vY.indexOf(cY, i + 1); // index of right neighbour - one with the same Y
            int nX = vX.indexOf(cX, i + 1); // index of bottom neighbour - one with the same X

            System.out.print(cX + " " + cY);
            System.out.print(nY > 0 ? " " + vX.get(nY) + " " + cY : " -1 -1");
            System.out.println(nX > 0 ? " " + cX + " " + vY.get(nX) : " -1 -1");
        }
    }
}