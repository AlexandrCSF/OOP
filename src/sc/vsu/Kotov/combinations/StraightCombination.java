package sc.vsu.Kotov.combinations;

import sc.vsu.Kotov.Card;
import sc.vsu.Kotov.CardRank;

import java.util.ArrayList;
import java.util.List;

public class StraightCombination implements ICombination {
    @Override
    public List<Card> checkSequence(List<Card> cards) {
        List<Card> result = new ArrayList<>();
        List<Integer> ranks = new ArrayList<>();
        List<Integer> foundRanks = new ArrayList<>();
        for (Card card : cards) {
            ranks.add(card.getRankToInt());
        }
        for (int i = 0; i < cards.size(); i++) {
            int currCardRankToInt = cards.get(i).getRankToInt();
            if (ranks.contains(currCardRankToInt + 1) && ranks.contains(currCardRankToInt + 2) && ranks.contains(currCardRankToInt + 3) && ranks.contains(currCardRankToInt + 4)) {
                result.add(cards.get(i));
                for (int j = 0; j < cards.size(); j++) {
                    if (j == i)
                        continue;
                    if (cards.get(j).getRankToInt() - currCardRankToInt <= 4 && !foundRanks.contains(cards.get(j).getRankToInt())) {
                        result.add(cards.get(j));
                        foundRanks.add(cards.get(j).getRankToInt());
                    }
                }
                return result;
            }
        }
        return null;
    }
}
