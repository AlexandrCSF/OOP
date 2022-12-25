package sc.vsu.Kotov.combinations.Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sc.vsu.Kotov.Card;
import sc.vsu.Kotov.CardRank;
import sc.vsu.Kotov.CardSuit;
import sc.vsu.Kotov.combinations.FlushRoyalCombination;
import sc.vsu.Kotov.combinations.FourOfAKindCombination;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FourOfAKindCombinationTest {

    @Test
    void checkSequence() {
        FourOfAKindCombination combination = new FourOfAKindCombination();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardSuit.DIAMONDS, CardRank.CARD_10));
        cards.add(new Card(CardSuit.HEARTS,CardRank.CARD_10));
        cards.add(new Card(CardSuit.CLUBS,CardRank.QUEEN));
        cards.add(new Card(CardSuit.SPADES,CardRank.QUEEN));
        cards.add(new Card(CardSuit.SPADES,CardRank.ACE));
        List<Card> result = combination.checkSequence(cards);
        cards.remove(new Card(CardSuit.SPADES,CardRank.ACE));
        Assertions.assertNull(result);
    }
}