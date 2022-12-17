package sc.vsu.Kotov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class RankingTest {


    @Test
    void isRoyalFlash() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(CardSuit.DIAMONDS,CardRank.CARD_10));
        cards.add(new Card(CardSuit.DIAMONDS,CardRank.JACK));
        cards.add(new Card(CardSuit.DIAMONDS,CardRank.QUEEN));
        cards.add(new Card(CardSuit.DIAMONDS,CardRank.KING));
        cards.add(new Card(CardSuit.DIAMONDS,CardRank.ACE));
        Assertions.assertTrue(Ranking.isRoyalFlush(cards));
    }

    @Test
    void isStreet() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(CardSuit.SPADES,CardRank.CARD_5));
        cards.add(new Card(CardSuit.DIAMONDS,CardRank.CARD_9));
        cards.add(new Card(CardSuit.DIAMONDS,CardRank.CARD_7));
        cards.add(new Card(CardSuit.HEARTS,CardRank.CARD_6));
        cards.add(new Card(CardSuit.CLUBS,CardRank.CARD_8));
        Assertions.assertTrue(Ranking.isStreet(cards));
    }

    @Test
    void isFlush() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(CardSuit.SPADES,CardRank.ACE));
        cards.add(new Card(CardSuit.SPADES,CardRank.CARD_9));
        cards.add(new Card(CardSuit.SPADES,CardRank.JACK));
        cards.add(new Card(CardSuit.SPADES,CardRank.CARD_3));
        cards.add(new Card(CardSuit.SPADES,CardRank.CARD_4));
        Assertions.assertTrue(Ranking.isFlush(cards));
    }

    @Test
    void getSequence() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(CardSuit.DIAMONDS,CardRank.ACE));
        cards.add(new Card(CardSuit.DIAMONDS,CardRank.CARD_9));
        cards.add(new Card(CardSuit.CLUBS,CardRank.ACE));
        cards.add(new Card(CardSuit.SPADES,CardRank.ACE));
        cards.add(new Card(CardSuit.HEARTS,CardRank.CARD_4));
        Assertions.assertTrue(Ranking.getSequence(cards,3));
    }

    @Test
    void isFullHouse() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(CardSuit.DIAMONDS,CardRank.CARD_2));
        cards.add(new Card(CardSuit.CLUBS,CardRank.CARD_10));
        cards.add(new Card(CardSuit.HEARTS,CardRank.CARD_2));
        cards.add(new Card(CardSuit.HEARTS,CardRank.CARD_10));
        cards.add(new Card(CardSuit.DIAMONDS,CardRank.CARD_10));
        assertTrue(Ranking.isFullHouse(cards));
    }

    @Test
    void getHighCard() {
        Card[] cards = new Card[5];
        cards[0] = (new Card(CardSuit.DIAMONDS,CardRank.ACE));
        cards[1] = (new Card(CardSuit.DIAMONDS,CardRank.CARD_9));
        cards[2] = (new Card(CardSuit.CLUBS,CardRank.ACE));
        cards[3] = (new Card(CardSuit.SPADES,CardRank.ACE));
        cards[4] = (new Card(CardSuit.HEARTS,CardRank.CARD_4));
        Assertions.assertEquals(Ranking.getHighCard(cards), cards[3]);
    }
}