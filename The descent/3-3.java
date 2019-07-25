import java.util.*;

//Blackheart595의 코드.
// 객체을 사용한 방법풀이라 새로웠음.
// 댓글에 람다 보다는 Comparator.comparing(Mountain::getHeight) 이것이 좋아 보인다는 있었음.

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // game loop
        while (true) {
            // List the mountains
            List<Mountain> mountains = new ArrayList<>(8);

            for (int i = 0; i < 8; i++) {
                int mountainH = in.nextInt(); // represents the height of one mountain, from 9 to 0.
                mountains.add(new Mountain(mountainH));
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            // Write index of the highest mountain
            Mountain highest = Collections.max(mountains, (m1, m2) -> m1.getHeight() - m2.getHeight());
            System.out.println(mountains.indexOf(highest));
        }
    }

    /**
     * Represents a mountain at a specific time.
     */
    private static class Mountain {
        /**
         * The height of this mountain.
         */
        private final int height;

        /**
         * Constructs a new mountain.
         * 
         * @param height The height of this mountain. Must be non-negative.
         */
        public Mountain(final int height) {
            if (height < 0) {
                throw new IllegalArgumentException("A mountain must have a non-negative height!");
            }
            this.height = height;
        }

        /**
         * Returns the height of this mountain.
         * 
         * @return The height of this mountain.
         */
        private int getHeight() {
            return height;
        }
    }
}