package sc.vsu.Kotov.combinations;

import sc.vsu.Kotov.Card;

import java.util.List;

public class StraightFlushCombination implements ICombination {

    @Override
    public List<Card> checkSequence(List<Card> cards) {
        FlushCombination flushCombination = new FlushCombination();
        StraightCombination straightCombination = new StraightCombination();
        List<Card> flushCards = flushCombination.checkSequence(cards);
        List<Card> straightCards = straightCombination.checkSequence(cards);

        if (flushCards != null && straightCards != null) {
            if (flushCards.equals(straightCards))
                return straightCards;
        }
        return null;
    }
}
