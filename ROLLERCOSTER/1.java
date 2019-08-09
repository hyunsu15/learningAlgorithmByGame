import java.util.*;

class Solution {
    static int[] que;
    static int limit;
    static int play;

    static HashMap<Integer, NextIndexPeople> hashmap = new HashMap<>();
    static long revenue;

    public static void main(String args[]) {
        initialize();
        printAnswer();
    }

    public static void initialize() {
        Scanner in = new Scanner(System.in);
        limit = in.nextInt();
        play = in.nextInt();
        int group = in.nextInt();
        que = new int[group];
        for (int i = 0; i < group; i++) {
            int pi = in.nextInt();
            que[i] = pi;
        }

    }

    public static void printAnswer() {
        boolean isAllRide = isAllRide();
        if (!isAllRide) {
            calculate();
            System.out.println(revenue);
        }
    }

    public static boolean isAllRide() {
        long sum = 0;
        for (int i = 0; i < que.length; i++)
            sum += que[i];

        if (sum < limit)
            System.out.println(sum * play);

        return sum < limit ? true : false;
    }

    public static void calculate() {
        int playNumber = 0;
        int beginIndex = 0;

        while (playNumber < play) {
            if (hashmap.get(beginIndex) == null) {
                NextIndexPeople next = calculateNextIndexPeople(beginIndex);
                hashmap.put(beginIndex, next);
            }
            revenue += hashmap.get(beginIndex).PeopleNum;
            beginIndex = hashmap.get(beginIndex).nextIndex;
            playNumber++;
        }

    }

    public static NextIndexPeople calculateNextIndexPeople(int beginIndex) {
        int index = beginIndex;
        long sum = 0;
        while (true) {
            if (sum + que[index] > limit)
                break;
            sum += que[index];
            index = (index + 1) % que.length;
        }
        return new NextIndexPeople(index, sum);
    }

    private static class NextIndexPeople {
        int nextIndex;
        long PeopleNum;

        public NextIndexPeople() {
        }

        public NextIndexPeople(int nextIndex, long PeopleNum) {
            this.PeopleNum = PeopleNum;
            this.nextIndex = nextIndex;
        }

    }

}