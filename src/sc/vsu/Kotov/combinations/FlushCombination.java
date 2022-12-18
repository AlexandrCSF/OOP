package sc.vsu.Kotov.combinations;

import sc.vsu.Kotov.Card;
import sc.vsu.Kotov.CardSuit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FlushCombination implements ICombination {

    @Override
    public List<Card> checkSequence(List<Card> cards) {
        CardSuit[] cardSuits = new CardSuit[]{CardSuit.SPADES, CardSuit.CLUBS, CardSuit.HEARTS, CardSuit.DIAMONDS};
        HashMap<CardSuit, ArrayList<Card>> result = new HashMap<>();
        ArrayList<Card> cardArray = new ArrayList<>();

        for (Card card : cards) {
            CardSuit currSuit = card.getSuit();
            if (result.get(currSuit) == null)
                cardArray.add(card);
            else {
                cardArray = result.get(currSuit);
                cardArray.add(card);
            }
            result.put(currSuit, new ArrayList<>(cardArray));
            cardArray.clear();
        }

        for (CardSuit cardSuit : cardSuits) {
            if (result.get(cardSuit) == null)
                continue;
            if (result.get(cardSuit).size() == 5) {
                return result.get(cardSuit);
            }
        }
        return null;
    }
}
