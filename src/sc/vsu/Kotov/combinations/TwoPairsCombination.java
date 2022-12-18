package sc.vsu.Kotov.combinations;

import sc.vsu.Kotov.Card;
import sc.vsu.Kotov.CardRank;

import java.util.ArrayList;
import java.util.List;

public class TwoPairsCombination implements ICombination {
    @Override
    public List<Card> checkSequence(final List<Card> cards) {
        PairCombination pairCombination = new PairCombination();
        List<Card> result;
        List<Card> cardCopy = new ArrayList<>(cards);
        if (pairCombination.checkSequence(cards) != null) {
            result = new ArrayList<>(pairCombination.checkSequence(cards));
        } else return null;
        cardCopy.removeAll(result);
        if (pairCombination.checkSequence(cardCopy) != null) {
            result.addAll(pairCombination.checkSequence(cardCopy));
        } else return null;
        return result;
    }
}