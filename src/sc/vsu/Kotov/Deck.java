package sc.vsu.Kotov;

import java.io.Serializable;
import java.util.*;


public class Deck implements Serializable {

	private List<Card> cards;


	public Deck() {
		createDeck();
	}

	private void createDeck() {
		cards = new ArrayList<>();
		for (CardSuit suit : CardSuit.values()) {
			for (CardRank rank : CardRank.values()) {
				cards.add(new Card(suit, rank));
			}
		}
		Collections.shuffle(cards);
	}

	public Card pop() {
		Card card = cards.get(0);
		cards.remove(0);
		return card;
	}
}
