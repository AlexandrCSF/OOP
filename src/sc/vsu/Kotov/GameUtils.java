package sc.vsu.Kotov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GameUtils {
    public static List<Card> arrayToList(Card[] cards){
        return new ArrayList<>(Arrays.asList(cards));
    }
    public static String cardsToString(Card[] cards){
        return cardsToString(Arrays.asList(cards));
    }
    public static String cardsToString(List<Card> cards){
        String result = "Cards: ";
        HashMap<CardSuit,Character> suitToString = new HashMap<>();
        suitToString.put(CardSuit.HEARTS,'❤');
        suitToString.put(CardSuit.CLUBS,'♠');
        suitToString.put(CardSuit.DIAMONDS,'♢');
        suitToString.put(CardSuit.SPADES,'♧');

        for (Card card : cards) {
            result += String.valueOf(card.getRank()) + suitToString.get(card.getSuit()) + " ";
        }
        return result;
    }
}
