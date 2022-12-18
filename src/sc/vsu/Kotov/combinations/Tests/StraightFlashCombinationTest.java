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
        cards.add(new Card(CardSuit.DIAMONDS, CardRank.CARD_5));
        cards.add(new Card(CardSuit.DIAMONDS,CardRank.CARD_9));
        cards.add(new Card(CardSuit.DIAMONDS,CardRank.CARD_7));
        cards.add(new Card(CardSuit.DIAMONDS,CardRank.CARD_6));
        cards.add(new Card(CardSuit.DIAMONDS,CardRank.CARD_8));
        StraightFlushCombination combination = new StraightFlushCombination();
        List<Card> result = combination.checkSequence(cards);
        Assertions.assertEquals(result, cards);
    }
}