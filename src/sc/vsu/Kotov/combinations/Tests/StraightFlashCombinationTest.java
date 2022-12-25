package sc.vsu.Kotov.combinations.Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sc.vsu.Kotov.Card;
import sc.vsu.Kotov.CardRank;
import sc.vsu.Kotov.CardSuit;
import sc.vsu.Kotov.combinations.StraightFlushCombination;

import java.util.ArrayList;
import java.util.List;

class StraightFlashCombinationTest {

    @Test
    void checkSequence() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardSuit.SPADES, CardRank.ACE));
        cards.add(new Card(CardSuit.SPADES,CardRank.CARD_5));
        cards.add(new Card(CardSuit.CLUBS,CardRank.CARD_3));
        cards.add(new Card(CardSuit.DIAMONDS,CardRank.QUEEN));
        cards.add(new Card(CardSuit.CLUBS,CardRank.QUEEN));
        cards.add(new Card(CardSuit.HEARTS,CardRank.CARD_10));
        cards.add(new Card(CardSuit.SPADES,CardRank.KING));
        StraightFlushCombination combination = new StraightFlushCombination();
        List<Card> result = combination.checkSequence(cards);
        Assertions.assertNull(result);
    }
}