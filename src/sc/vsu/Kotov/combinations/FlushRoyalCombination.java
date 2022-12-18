package sc.vsu.Kotov.combinations;

import sc.vsu.Kotov.Card;
import sc.vsu.Kotov.CardRank;
import sc.vsu.Kotov.CardSuit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FlushRoyalCombination implements ICombination {
    @Override
    public List<Card> checkSequence(List<Card> cards) {
        CardSuit[] cardSuits = new CardSuit[]{CardSuit.SPADES, CardSuit.CLUBS, CardSuit.HEARTS, CardSuit.DIAMONDS};
        HashMap<CardSuit, ArrayList<Card>> result = new HashMap<>();
        FlushCombination flushCombination = new FlushCombination();
        if(flushCombination.checkSequence(cards) == null)
            return null;

        for (CardSuit cardSuit : cardSuits) {
            if (result.get(cardSuit) == null)
                continue;
            List<CardRank> suits = getCardListRanks(result.get(cardSuit));
            if (result.get(cardSuit).size() == 5 && suits.contains(CardRank.CARD_10) && suits.contains(CardRank.JACK) &&
                    suits.contains(CardRank.QUEEN) && suits.contains(CardRank.KING) && suits.contains(CardRank.ACE)) {
                return result.get(cardSuit);
            }
        }
        return null;
    }

    protected List<CardRank> getCardListRanks(List<Card> cards) {
        List<CardRank> result = new ArrayList<>();
        for (Card card : cards) {
            result.add(card.getRank());
        }
        return result;
    }
}
