package sc.vsu.Kotov.combinations;

import sc.vsu.Kotov.Card;
import sc.vsu.Kotov.CardRank;

import java.util.ArrayList;
import java.util.List;

public class SetCombination implements ICombination {
    @Override
    public List<Card> checkSequence(List<Card> cards) {
        int foundSize = 1;
        int sequenceSize = 3;

        List<Card> result = new ArrayList<>();
        int j;
        for (int i = 0; i < cards.size() - 1; i++) {
            CardRank currCardRank = cards.get(i).getRank();
            result.add(cards.get(i));
            j = 0;
            while (j < cards.size()) {
                if (j == i) {
                    j++;
                    continue;
                }
                if (cards.get(j).getRank().equals(currCardRank)) {
                    result.add(cards.get(j));
                    foundSize++;
                    j++;
                }
                if (foundSize == sequenceSize) {
                    return result;
                }
                j++;
            }
            result.clear();
            foundSize = 1;
        }
        return null;
    }
}
