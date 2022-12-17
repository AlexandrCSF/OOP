package sc.vsu.Kotov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Ranking {
    public static RankingEnum checkRanking(ArrayList<Card> cards, ArrayList<Card> tableCards){
        cards.addAll(tableCards);
        return checkRanking(cards);
    }
    public static RankingEnum checkRanking(ArrayList<Card> cards) {
        boolean isFlush = isFlush(cards);
        boolean isStreet = isStreet(cards);
        if(isRoyalFlush(cards))
            return RankingEnum.ROYAL_FLUSH;
        if(isStreet && isFlush)
            return RankingEnum.STRAIGHT_FLUSH;
        if(getSequence(cards,4))
            return RankingEnum.FOUR_OF_A_KIND;
        if(isFullHouse(cards))
            return RankingEnum.FULL_HOUSE;
        if(isFlush)
            return RankingEnum.FLUSH;
        if(isStreet)
            return RankingEnum.STRAIGHT;
        if(getSequence(cards,3))
            return RankingEnum.THREE_OF_A_KIND;
        if(getSequence(cards,2))
            return RankingEnum.ONE_PAIR;
        return RankingEnum.HIGH_CARD;
    }

    protected static boolean isRoyalFlush(ArrayList<Card> cards){
        boolean isFlash = isFlush(cards);
        ArrayList<CardRank> ranks = new ArrayList<>();
        for (int i = 0; i < cards.size(); i++) {
            ranks.add(cards.get(i).getRank());
        }
        return ranks.contains(CardRank.CARD_10) && ranks.contains(CardRank.JACK) && ranks.contains(CardRank.QUEEN) && ranks.contains(CardRank.KING) && ranks.contains(CardRank.ACE) && isFlash;
    }

    protected static boolean isStreet(ArrayList<Card> cards) {
        ArrayList<Integer> ordinals = new ArrayList<>();

        for (Card card : cards) {
            ordinals.add(card.getRankToInt());
        }

        for (int i = 0; i < 2; i++) {
            int currCardOrdinal = cards.get(i).getRankToInt();
            if (ordinals.contains(currCardOrdinal + 1) && ordinals.contains(currCardOrdinal + 2) && ordinals.contains(currCardOrdinal + 3)
                    && ordinals.contains(currCardOrdinal + 4)) {
                return true;
            }
        }
        return false;
    }

    protected static boolean isFlush(ArrayList<Card> cards) {
        for (Card card : cards) {
            CardSuit currCardSuit = card.getSuit();
            if (countSameSuits(cards, currCardSuit) >= 5) {
                return true;
            }
        }
        return false;
    }

    protected static int countSameSuits(ArrayList<Card> cards, CardSuit suit) {
        int sameSuitCounter = 0;
        for (Card card : cards) {
            if (card.getSuit().equals(suit)) {
                sameSuitCounter++;
            }
        }
        return sameSuitCounter;
    }

    protected static boolean getSequence(ArrayList<Card> cards, int size) {
        int foundSize = 1;
        for (int i = 0; i < cards.size() - 1; i++) {
            CardRank currCardRank = cards.get(i).getRank();
            for (int j = i + 1; j < cards.size(); j++) {
                if(cards.get(j).getRank().equals(currCardRank)){
                    foundSize++;
                }
            }
            if(foundSize == size){
                return true;
            }
        }
        return false;
    }
    protected static boolean isFullHouse(ArrayList<Card> cards){
        int foundSize = 1;
        int size = 3;
        ArrayList<Integer> cardIndices = new ArrayList<>();
        for (int i = 0; i < cards.size() - 1; i++) {
            CardRank currCardRank = cards.get(i).getRank();
            cardIndices.add(i);
            for (int j = i + 1; j < cards.size(); j++) {
                if(cards.get(j).getRank().equals(currCardRank)){
                    cardIndices.add(j);
                    foundSize++;
                }
            }
            if(foundSize == size && size != 2){
                for (Integer cardIndex : cardIndices) {
                    cards.remove(cardIndex);
                }
                i = 0;
                size = 2;
                cardIndices.clear();
                foundSize = 1;
            }else if(foundSize == size){
                return true;
            }
            else {
                foundSize = 1;
                cardIndices.clear();
            }
        }
        return false;
    }

    protected static Card getHighCard(Card[] cards){
        CardRank cardRank = null;
        CardSuit cardSuit = null;
        int maxRank = CardRank.CARD_2.ordinal();
        for (Card card: cards) {
            if(card.getRankToInt() >= maxRank){
                maxRank = card.getRankToInt();
                cardRank = card.getRank();
                cardSuit = card.getSuit();
            }
        }
        return new Card(cardSuit,cardRank);
    }

    public static int getRankingToInt(Player player){
        return player.getRankingEnum().ordinal();
    }
    public static ArrayList<Card> arrayToList(Card[] cards){
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

