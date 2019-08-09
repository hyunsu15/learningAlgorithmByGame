import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    static Scanner in = new Scanner(System.in);
    static String alphabet;
    static List<String> wordList;
    static List<String> validWordList;
    static String[] alphabetArray;
    static int[] pointArray = { 1, 2, 3, 4, 5, 8, 10 };

    public static void main(String args[]) {

        initialize();
        isContainAlphabet();
        WordHighScorePrint();

    }

    static void initialize() {
        int N = in.nextInt();

        if (in.hasNextLine())
            in.nextLine();
        wordListInitial(N);

        alphabet = in.nextLine();
        validWordList = new ArrayList();
        alphabetArrayInitial();
    }

    static void wordListInitial(int N) {
        String[] wordArray = new String[N];
        for (int i = 0; i < N; i++)
            wordArray[i] = in.nextLine();
        wordList = new ArrayList(Arrays.asList(wordArray));
    }

    static void alphabetArrayInitial() {
        String alphabet = "eaionrtlsu dg bcmp fhvwy k jx qz";
        alphabetArray = alphabet.split(" ");
    }

    static void isContainAlphabet() {
        for (int i = 0; i < wordList.size(); i++) {
            StringBuffer word = new StringBuffer(wordList.get(i));
            word = wordDelete(word);

            if (word.length() == 0)
                validWordList.add(wordList.get(i));
        }
    }

    static StringBuffer wordDelete(StringBuffer word) {
        for (int j = 0; j < alphabet.length(); j++) {
            for (int k = 0; k < word.length();) {
                if (word.charAt(k) == alphabet.charAt(j)) {
                    word.deleteCharAt(k);
                    k = 0;
                    break;
                } else
                    k++;
            }
        }
        return word;
    }

    static void WordHighScorePrint() {
        int index = 0;
        index = maxScoreIndex(index);
        System.out.println(validWordList.get(index));
    }

    static int maxScoreIndex(int index) {
        int max = 0;
        int sum = 0;

        for (int i = 0; i < validWordList.size(); i++) {
            String word = validWordList.get(i);
            sum = 0;
            sum = calculateScore(word, sum);

            if (sum > max) {
                max = sum;
                index = i;
            }
        }
        return index;
    }

    static int calculateScore(String word, int sum) {
        for (int j = 0; j < word.length(); j++) {
            String alphabet = new String("" + word.charAt(j));
            for (int k = 0; k < alphabetArray.length; k++) {
                if (alphabetArray[k].contains(alphabet))
                    sum += pointArray[k];
            }
        }
        return sum;
    }
}
