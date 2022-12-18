package sc.vsu.Kotov.combinations.Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sc.vsu.Kotov.Card;
import sc.vsu.Kotov.CardRank;
import sc.vsu.Kotov.CardSuit;
import sc.vsu.Kotov.combinations.FourOfAKindCombination;
import sc.vsu.Kotov.combinations.SetCombination;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SetCombinationTest {

    @Test
    void checkSequence() {
        SetCombination combination = new SetCombination();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardSuit.DIAMONDS, CardRank.CARD_3));
        cards.add(new Card(CardSuit.HEARTS,CardRank.CARD_6));
        cards.add(new Card(CardSuit.CLUBS,CardRank.CARD_6));
        cards.add(new Card(CardSuit.SPADES,CardRank.CARD_8));
        cards.add(new Card(CardSuit.SPADES,CardRank.KING));
        cards.add(new Card(CardSuit.SPADES,CardRank.CARD_10));
        cards.add(new Card(CardSuit.SPADES,CardRank.CARD_2));
        List<Card> result = combination.checkSequence(cards);
        assertNull(result);

    }
}