import java.util.*;

//cheatah의 코드
// 내가 짤려고했던 코드와 가장 유사하면서, 내가 할려고했던 방식과 유사하게짬.
// allowed.indexOf()을 쓰는것도 좋은아이디어인것같다.

class Solution {

    static HashMap<Character, Integer> points = new HashMap<Character, Integer>(26);
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] dict = new String[n];
        for (int i = 0; i < n; i++) {
            dict[i] = in.nextLine();
        }
        String allowed = in.nextLine();
        constructMap();
        
        String bestWord = "";
        int bestScore = 0;
        for (int i = 0; i < n; i++) {
            if (isPossible(dict[i], allowed) && calcScore(dict[i]) > bestScore) {
                bestWord = dict[i];
                bestScore = calcScore(bestWord);
                if (bestWord.length() == 7) {
                    System.out.println(bestWord);
                    return;
                }
            }
        }
        System.out.println(bestWord);
    }
    
    private static boolean isPossible(String tested, String allowed) {
        for (char ch: tested.toCharArray()) {
            if (allowed.indexOf(ch) >= 0) {
                allowed = allowed.replaceFirst(Character.toString(ch), "");
            } else {
                return false;
            }
        }
        return true;
    }
    
    private static int calcScore(String word) {
        int score = 0;
        for (char ch: word.toCharArray()) {
            score += points.get(ch);
        }
        return score;
    }
    
    private static void constructMap() {
        String[] letters = {"eaionrtlsu", "dg", "bcmp", "fhvwy", "k", "jx", "qz"};
        int[] values = {1, 2, 3, 4, 5, 8, 10};
        for (int i = 0; i < values.length; i++) {
            for (char ch: letters[i].toCharArray()) {
                points.put(ch, values[i]);
            }
        }
    }
}