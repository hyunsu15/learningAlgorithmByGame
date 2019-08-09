import java.util.*;
import java.io.*;
import java.math.*;

// 수정할 부분은 
//1. wordListInitial에서 String[] 필요없음. -> 삭제함
//2. wordDelete에서 반복줄이기.

//1개에 1의 값을 다루고있어서 굳이 HashMap 사용 할 필요는 없음.
// 구현은 하지 않겠지만, HashMap을 사용한다고 했을때,
//HashMap<value,String>으로선언하고
//alphabetArra와 pointArray을 지역 변수로 하고 포문으로 선언하는게 가장이쁠 것같다.
//calculateScore 메소드는 keySet()을포문으로 하고, 상황에 맞게 만들어주면 될듯함.

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
        wordList = new ArrayList();
        for (int i = 0; i < N; i++)
            wordList.add(in.nextLine());
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
            String alphabetChar = Character.toString(alphabet.charAt(j));
            if (word.indexOf(alphabetChar)>-1) {
                word.deleteCharAt(word.indexOf(alphabetChar));
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
            String alphabet = "" + word.charAt(j);
            for (int k = 0; k < alphabetArray.length; k++) {
                if (alphabetArray[k].contains(alphabet))
                    sum += pointArray[k];
            }
        }
        return sum;
    }
}