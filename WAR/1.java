import java.util.*;

class Solution {

    static Scanner in = new Scanner(System.in);
    static Deque<String> player1Deck;
    static Deque<String> player2Deck;
    static Deque<String> player1OpenCard;
    static Deque<String> player2OpenCard;
    static Boolean player1IsHighLevel;
    static Boolean player1IsWin;
    static int playCount;

    public static void main(String args[]) {
        initialize();
        gameStart();
        gameEnd();
    }

    static void initialize() {
        player1Deck = queueInitialize(in.nextInt());
        player2Deck = queueInitialize(in.nextInt());
        playCount = 0;
        openCardInitialize();
    }

    static Deque<String> queueInitialize(int cardAmount) {
        Deque<String> playerDeck = new LinkedList() {
            {
                for (int i = 0; i < cardAmount; i++)
                    add(in.next());
            }
        };
        return playerDeck;
    }

    static void openCardInitialize() {
        player1OpenCard = new LinkedList();
        player2OpenCard = new LinkedList();
    }

    static void gameStart() {
        while (!player1Deck.isEmpty() && !player2Deck.isEmpty()) {
            String player1Card = player1Deck.pollFirst();
            String player2Card = player2Deck.pollFirst();
            isPlayerHigh(player1Card, player2Card);
            openCard(player1Card, player2Card);
            if (player1IsHighLevel == null) {
                if (player1Deck.size() < 4 || player2Deck.size() < 4)
                    break;
                else
                    openCard(3);
                playCount--;
            } else
                openCardPlace();
            playCount++;
        }

    }

    static void isPlayerHigh(String player1Card, String player2Card) {
        int player1CardValue = judgeLevelValue(player1Card);
        int player2CardValue = judgeLevelValue(player2Card);

        player1IsHighLevel = player1CardValue > player2CardValue ? true : false;

        if (player1CardValue == player2CardValue)
            player1IsHighLevel = null;
    }

    static int judgeLevelValue(String card) {
        int value = card.charAt(0);
        value = addWeightLevel(value, '1', '9');
        value = addWeightLevel(value, 'K', 'Q');
        value = addWeightLevel(value, 'A', 'R');
        return value;

    }

    static int addWeightLevel(int value, char charValue, char prefix) {
        return value == charValue ? prefix + 1 : value;
    }

    static void openCardPlace() {
        if (player1IsHighLevel) {
            player1Deck.addAll(player1OpenCard);
            player1Deck.addAll(player2OpenCard);
        } else {
            player2Deck.addAll(player1OpenCard);
            player2Deck.addAll(player2OpenCard);
        }
        openCardInitialize();
    }

    static void openCard(int num) {
        for (int i = 0; i < num; i++) {
            player1OpenCard.add(player1Deck.pollFirst());
            player2OpenCard.add(player2Deck.pollFirst());
        }

    }

    static void openCard(String player1Card, String player2Card) {

        player1OpenCard.add(player1Card);
        player2OpenCard.add(player2Card);

    }

    static void gameEnd() {
        if (player1Deck.isEmpty())
            whoVictory(2);
        else if (player2Deck.isEmpty())
            whoVictory(1);
        else
            System.out.println("PAT");
    }

    static void whoVictory(int playerName) {
        System.out.println(playerName + " " + playCount);
    }
}