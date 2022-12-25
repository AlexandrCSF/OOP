package sc.vsu.Kotov;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Player implements Serializable {

	public boolean isFold = false;

	private int bank;

	private int bet;

	private Card[] cards = new Card[2];

	private RankingEnum rankingEnum = null;

	private List<Card> rankingList = null;

	public int getRankingToInt(){
		return getRankingEnum().ordinal();
	}

	public int getBank() {
		return bank;
	}

	public void setBank(int bank) {
		this.bank = bank;
	}

	public int getBet() {
		return bet;
	}

	public void setBet(int bet) {
		this.bet = bet;
	}

	public RankingEnum getRankingEnum() {
		return rankingEnum;
	}

	public void setRankingEnum(RankingEnum rankingEnum) {
		this.rankingEnum = rankingEnum;
	}

	public List<Card> getRankingList() {
		return rankingList;
	}

	public void setRankingList(List<Card> rankingList) {
		this.rankingList = rankingList;
	}

	public Card[] getCards() {
		return cards;
	}

	public void setCards(Card[] cards) {
		this.cards = cards;
	}

	public Player() {
		this.bank = 10000;
	}
	public void call(GameTexasHoldem game){
		this.setBet(game.getCallBet());
	}
	public Card getHighCard(){
		int highestRank = CardRank.CARD_2.ordinal();
		Card result = null;
		for (Card card : cards) {
			if (card.getRankToInt() >= highestRank) {
				highestRank = card.getRankToInt();
				result = card;
			}
		}
		return result;
	}
}

