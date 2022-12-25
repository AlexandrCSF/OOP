package sc.vsu.Kotov.combinations.Tests;

import org.junit.jupiter.api.Test;
import sc.vsu.Kotov.Card;
import sc.vsu.Kotov.CardRank;
import sc.vsu.Kotov.CardSuit;
import sc.vsu.Kotov.combinations.StraightCombination;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StraightCombinationTest {

    @Test
    void checkSequence() {
        StraightCombination combination = new StraightCombination();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardSuit.SPADES, CardRank.CARD_5));
        cards.add(new Card(CardSuit.DIAMONDS,CardRank.CARD_9));
        cards.add(new Card(CardSuit.DIAMONDS,CardRank.CARD_7));
        cards.add(new Card(CardSuit.HEARTS,CardRank.CARD_6));
        cards.add(new Card(CardSuit.CLUBS,CardRank.CARD_8));
        cards.add(new Card(CardSuit.HEARTS,CardRank.CARD_10));
        List<Card> result = combination.checkSequence(cards);

        assertNotNull(result);
    }
}