package sc.vsu.Kotov;

import sc.vsu.Kotov.combinations.*;

import java.util.*;

public class Ranking {
    private final List<ICombination> combinations;
    private final List<RankingEnum> ranking;

    public Ranking(){
        combinations = new ArrayList<>();
        combinations.add(new FlushRoyalCombination());
        combinations.add(new StraightFlushCombination());
        combinations.add(new FourOfAKindCombination());
        combinations.add(new FullHouseCombination());
        combinations.add(new FlushCombination());
        combinations.add(new StraightCombination());
        combinations.add(new SetCombination());
        combinations.add(new TwoPairsCombination());
        combinations.add(new PairCombination());
        combinations.add(new HighCardCombination());
        ranking = new ArrayList<>();
        ranking.addAll(Arrays.asList(RankingEnum.ROYAL_FLUSH,RankingEnum.STRAIGHT_FLUSH,RankingEnum.FOUR_OF_A_KIND,RankingEnum.FULL_HOUSE,
                RankingEnum.FLUSH,RankingEnum.STRAIGHT,RankingEnum.THREE_OF_A_KIND,RankingEnum.TWO_PAIR,RankingEnum.ONE_PAIR,RankingEnum.HIGH_CARD));
    }

    public List<Card> getWinningSequence(List<Card> cards, List<Card> tableCards){
        cards.addAll(tableCards);
        return getWinningSequence(new ArrayList<>(cards));
    }
    public List<Card> getWinningSequence(List<Card> cards) {
        for (ICombination combination : combinations) {
            if (combination.checkSequence(cards) != null) {
                return combination.checkSequence(cards);
            }
        }
        return null;
    }

    public RankingEnum checkRanking(List<Card> cards, ArrayList<Card> tableCards) {
        cards.addAll(tableCards);
        return checkRanking(new ArrayList<>(cards));
    }

    public RankingEnum checkRanking(ArrayList<Card> cards){
        for (int i = 0; i < combinations.size(); i++) {
            if(combinations.get(i).checkSequence(cards) != null){
                return ranking.get(i);
            }
        }
        return null;
    }
}

