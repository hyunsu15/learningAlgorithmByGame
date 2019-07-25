import java.util.*;

//diziaq의 코드
//Collections.sort을 사용하여 해볼려고했지만 그건 인덱스변경이 Collections의 메소드를 못쓰는줄 알았음.
//indexOf와 max 을 잘 이용한 코드.
//read함수에서 ArrayList{{}}을 사용하여 선언한것이 새로웠음.
// 겉의 {}는 익명클래스이고, 안의 {}는 실행되는 지역 블록을 의미하는 것같다. 
//안의 블록에서는 익명클래스의 메소드를 그냥 이름만 불려도 호출되는식으로 구동.  

//익명클래스을 아주 잘활용하고 Collections함수를 잘이용한  신기한 풀이였음.

class Player {

    static Scanner in = new Scanner(System.in);

    static List<Integer> read() {
        return new ArrayList(8) {
            {
                for (int i = 0; i < 8; i++)
                    add(in.nextInt());
            }
        };
    }

    public static void main(String args[]) {

        while (true) {
            List<Integer> m = read();

            int maxIndex = m.indexOf(Collections.max(m));

            System.out.println(maxIndex);
        }
    }
}