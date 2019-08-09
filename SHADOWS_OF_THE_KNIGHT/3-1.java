import java.util.*;
import java.io.*;
import java.math.*;

//ivanoff.org.ua의 코드
//indexOf로 방향을 구현한 방법이 신기했다.
//indexOf을 쓰는 연습이 부족한듯 하다.

// 이진탐색부분도 내꺼보다 더 자연스러운 것 같다. 
//좀더 연습해야할 부분이다.
// 변수명은 내꺼처럼 하는것이 더 나을듯 싶다.

//그리고 문제 조건은 그냥 같으면 끝나는것인데, 잘못생각하고있엇음.
//같은것이 나오면 그 차이가 1이 나올때까지 하게 하는 코드를 작성함.


class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int X0 = in.nextInt();
        int Y0 = in.nextInt();

        // game loop
        int xa = 0, ya = 0, xz = W-1, yz = H-1;
        while (true) {
            String BOMB_DIR = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)

    if ( BOMB_DIR.indexOf("R")>=0 ) { xa = X0+1; }
    if ( BOMB_DIR.indexOf("L")>=0 ) { xz = X0-1; }
    if ( BOMB_DIR.indexOf("D")>=0 ) { ya = Y0+1; }
    if ( BOMB_DIR.indexOf("U")>=0 ) { yz = Y0-1; }

    X0 = ((xz-xa)/2) + xa;
    Y0 = ((yz-ya)/2) + ya;

            System.out.println(X0+" "+Y0); // the location of the next window Batman should jump to.
        }
    }
}