package sc.vsu.Kotov;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Deck implements Serializable {

	private List<Card> cards;
	private final Random random;

	public Deck() {
		this(new Random());
	}

	public Deck(Random random) {
		this.random = random;
		createDeck();
	}

	private void createDeck() {
		cards = new ArrayList<Card>();
		for (CardSuitEnum suit : CardSuitEnum.values()) {
			for (CardRankEnum rank : CardRankEnum.values()) {
				cards.add(new Card(suit, rank));
			}
		}
	}

	public Card pop() {
		return cards.remove(random.nextInt(cards.size()));
	}
}
