package sc.vsu.Kotov;

import sc.vsu.Kotov.combinations.*;

import java.util.*;

public class Ranking {
    public static List<Card> getWinningSequence(List<Card> cards, List<Card> tableCards){
        cards.addAll(tableCards);
        return getWinningSequence(new ArrayList<>(cards));
    }
    public static List<Card> getWinningSequence(List<Card> cards) {

        List<ICombination> combinations = new ArrayList<>();
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

        for (ICombination combination : combinations) {
            if (combination.checkSequence(cards) != null) {
                return combination.checkSequence(cards);
            }
        }
        return null;
    }

    public static RankingEnum checkRanking(List<Card> cards, ArrayList<Card> tableCards) {
        cards.addAll(tableCards);
        return checkRanking(new ArrayList<>(cards));
    }
    public static RankingEnum checkRanking(ArrayList<Card> cards){

        List<RankingEnum> ranking = new ArrayList<>();
        ranking.add(RankingEnum.ROYAL_FLUSH);
        ranking.add(RankingEnum.STRAIGHT_FLUSH);
        ranking.add(RankingEnum.FOUR_OF_A_KIND);
        ranking.add(RankingEnum.FULL_HOUSE);
        ranking.add(RankingEnum.FLUSH);
        ranking.add(RankingEnum.STRAIGHT);
        ranking.add(RankingEnum.THREE_OF_A_KIND);
        ranking.add(RankingEnum.TWO_PAIR);
        ranking.add(RankingEnum.ONE_PAIR);
        ranking.add(RankingEnum.HIGH_CARD);

        List<ICombination> combinations = new ArrayList<>();
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

        for (int i = 0; i < combinations.size(); i++) {
            if(combinations.get(i).checkSequence(cards) != null){
                return ranking.get(i);
            }
        }
        return null;
    }
    public static int getRankingToInt(Player player){
        return player.getRankingEnum().ordinal();
    }
    public static List<Card> arrayToList(Card[] cards){
        return new ArrayList<>(Arrays.asList(cards));
    }
    public static String cardsToString(Card[] cards){
        String result = "Cards: ";
        HashMap<CardSuit,Character> suitToString = new HashMap<>();
        suitToString.put(CardSuit.HEARTS,'❤');
        suitToString.put(CardSuit.CLUBS,'♠');
        suitToString.put(CardSuit.DIAMONDS,'♢');
        suitToString.put(CardSuit.SPADES,'♧');

        for (Card card : cards) {
            result += card.getRank() + String.valueOf(suitToString.get(card.getSuit()) + " ");
        }
        return result;
    }
    public static String cardsToString(ArrayList<Card> cards){
        String result = "Cards: ";
        HashMap<CardSuit,Character> suitToString = new HashMap<>();
        suitToString.put(CardSuit.HEARTS,'❤');
        suitToString.put(CardSuit.CLUBS,'♠');
        suitToString.put(CardSuit.DIAMONDS,'♢');
        suitToString.put(CardSuit.SPADES,'♧');

        for (Card card : cards) {
            result += card.getRank() + String.valueOf(suitToString.get(card.getSuit()) + " ");
        }
        return result;
    }

}

