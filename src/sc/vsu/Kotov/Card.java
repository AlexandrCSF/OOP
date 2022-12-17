package sc.vsu.Kotov;

import java.io.Serializable;


public class Card implements Serializable {

	private final CardSuit suit;
	private final CardRank rank;

	public Card(CardSuit suit, CardRank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public CardSuit getSuit() {
		return suit;
	}

	public CardRank getRank() {
		return rank;
	}

	public Integer getRankToInt() {
		return rank.ordinal();
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (!(obj instanceof Card)) {
			return false;
		} else {
			Card card2 = (Card) obj;
			return rank.equals(card2.getRank()) && suit.equals(card2.getSuit());
		}
	}

	@Override
	public String toString() {
		return "Suit: " + suit.toString() + ", Rank :" + rank.toString();
	}
}
