package sc.vsu.Kotov.combinations;

import sc.vsu.Kotov.Card;

import java.util.ArrayList;
import java.util.List;

public class FullHouseCombination implements ICombination {
    @Override
    public List<Card> checkSequence(List<Card> cards) {
        PairCombination pairCombination = new PairCombination();
        SetCombination setCombination = new SetCombination();
        List<Card> result;
        List<Card> cardCopy = new ArrayList<>(cards);
        if (pairCombination.checkSequence(cards) != null) {
            result = new ArrayList<>(pairCombination.checkSequence(cards));
        } else return null;
        cardCopy.removeAll(result);
        if (setCombination.checkSequence(cardCopy) != null) {
            result.addAll(setCombination.checkSequence(cardCopy));
        } else return null;
        return result;
    }
}
