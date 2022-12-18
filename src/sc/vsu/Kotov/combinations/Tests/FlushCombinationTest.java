package sc.vsu.Kotov.combinations.Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sc.vsu.Kotov.Card;
import sc.vsu.Kotov.CardRank;
import sc.vsu.Kotov.CardSuit;
import sc.vsu.Kotov.combinations.FlushCombination;
import sc.vsu.Kotov.combinations.FlushRoyalCombination;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlushCombinationTest {

    @Test
    void checkSequence() {
        FlushCombination combination = new FlushCombination();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardSuit.SPADES, CardRank.CARD_10));
        cards.add(new Card(CardSuit.SPADES,CardRank.CARD_8));
        cards.add(new Card(CardSuit.SPADES,CardRank.QUEEN));
        cards.add(new Card(CardSuit.SPADES,CardRank.CARD_4));
        cards.add(new Card(CardSuit.SPADES,CardRank.ACE));
        List<Card> result = combination.checkSequence(cards);
        Assertions.assertEquals(result,cards);
    }
}