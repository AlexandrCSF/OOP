package sc.vsu.Kotov.combinations;

import sc.vsu.Kotov.Card;
import sc.vsu.Kotov.CardRank;

import java.util.ArrayList;
import java.util.List;

public class HighCardCombination implements ICombination {
    @Override
    public List<Card> checkSequence(List<Card> cards) {
        int highestRank = CardRank.CARD_2.ordinal();
        List<Card> result = new ArrayList<>();
        for (Card card : cards) {
            if (card.getRankToInt() >= highestRank) {
                highestRank = card.getRankToInt();
                result.clear();
                result.add(card);
            }
        }
        return result;
    }
}
