package sc.vsu.Kotov.combinations.Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sc.vsu.Kotov.Card;
import sc.vsu.Kotov.CardRank;
import sc.vsu.Kotov.CardSuit;
import sc.vsu.Kotov.combinations.FullHouseCombination;
import sc.vsu.Kotov.combinations.TwoPairsCombination;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FullHouseCombinationTest {

    @Test
    void checkSequence() {
        FullHouseCombination combination = new FullHouseCombination();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardSuit.DIAMONDS, CardRank.CARD_10));
        cards.add(new Card(CardSuit.HEARTS,CardRank.CARD_10));
        cards.add(new Card(CardSuit.CLUBS,CardRank.JACK));
        cards.add(new Card(CardSuit.SPADES,CardRank.JACK));
        cards.add(new Card(CardSuit.HEARTS,CardRank.JACK));
        List<Card> result = combination.checkSequence(cards);
        Assertions.assertEquals(result,cards);
    }
}