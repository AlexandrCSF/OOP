package sc.vsu.Kotov;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameTexasHoldem implements Serializable {

	Ranking ranking = new Ranking();
	BetUtil betCalculator =new BetUtil();
	private int callBet = 0;

    private int Bank = 0;

	private int bigBlind;

	private Deck deck;

	private ArrayList<Player> players;

	private ArrayList<Card> tableCards;

	public void newGame(int playersAmount,int bigBlind) {
		this.players = new ArrayList<>();
		this.tableCards = new ArrayList<Card>();
		for (int i = 0; i < playersAmount; i++) {
			players.add(new Player());
		}
		this.callBet = bigBlind;
		this.bigBlind = bigBlind;
		this.deck = new Deck();
	}
	public void newGame(){
		this.Bank = 0;
		this.callBet = 0;
		this.deck = new Deck();
		tableCards.clear();
	}

	public int getBigBlind() {
		return bigBlind;
	}

	public void setBigBlind(int bigBlind) {
		this.bigBlind = bigBlind;
	}

	public int getBank() {
		return Bank;
	}

	public void setBank(int bank) {
		Bank = bank;
	}

	public int getCallBet() {
		return callBet;
	}

	public void setCallBet(int callBet) {
		this.callBet = callBet;
	}

	public void removePlayer(Player player) {
		players.remove(player);
	}
	public void addPlayer(Player player){
		players.add(player);
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void deal() {
		players.get(1).setBet(bigBlind / 2);
		players.get(2).setBet(bigBlind);
		for (Player player : players) {
			player.getCards()[0] = deck.pop();
			player.getCards()[1] = deck.pop();
		}
		for (Player player : players) {
			setBank(getBank() + player.getBet());
		}
	}
	public void callFlop() {
		deck.pop();
		tableCards.add(deck.pop());
		tableCards.add(deck.pop());
		tableCards.add(deck.pop());
		checkPlayersRanking();
		for(Player player : players){
			BetUtil.calculateBet(player,this);
		}
		setBank(0);
		for (Player player : players) {
			setBank(getBank() + player.getBet());
		}
	}

	public void betTurn() {
		deck.pop();
		tableCards.add(deck.pop());
		checkPlayersRanking();
		for(Player player : players){
			BetUtil.calculateBet(player,this);
		}
		setBank(0);
		for (Player player : players) {
			setBank(getBank() + player.getBet());
		}
	}

	public void betRiver() {
		deck.pop();
		tableCards.add(deck.pop());
		checkPlayersRanking();
		for(Player player : players){
			BetUtil.calculateBet(player,this);
		}
		setBank(0);
		for (Player player : players) {
			setBank(getBank() + player.getBet());
		}
	}

	public List<Player> getWinner() {
		checkPlayersRanking();
		List<Player> winnerList = new ArrayList<Player>();
		Player winner = players.get(0);
		int winnerRank = winner.getRankingToInt();
		winnerList.add(winner);
		for (int i = 1; i < players.size(); i++) {
			if(players.get(i).isFold)
				continue;
			Player player = players.get(i);
			int playerRank = player.getRankingToInt();
			if (winnerRank == playerRank) {
				Player highHandPlayer = checkHighSequence(winner, player);
				if (highHandPlayer == null) {
					highHandPlayer = checkHighCardWinner(winner, player);
				}
				if (highHandPlayer != null && !winner.equals(highHandPlayer)) {
					winner = highHandPlayer;
					winnerList.clear();
					winnerList.add(winner);
				} else if (highHandPlayer == null) {
					winnerList.add(winner);
				}
			} else if (winnerRank < playerRank) {
				winner = player;
				winnerList.clear();
				winnerList.add(winner);
			}
			winnerRank = winner.getRankingToInt();
		}
		return winnerList;
	}

	private Player checkHighSequence(Player player1, Player player2) {
		int player1Rank = player1.getRankingEnum().ordinal();
		int player2Rank = player2.getRankingEnum().ordinal();
		if (player1Rank > player2Rank) {
			return player1;
		} else if (player1Rank < player2Rank) {
			return player2;
		}
		return null;
	}

	private Player checkHighCardWinner(Player player1, Player player2) {
		Player winner = compareHighCard(player1, player1.getHighCard(),
				player2, player2.getHighCard());
		if (winner == null) {
			Card player1Card = player1.getHighCard();
			Card player2Card = player2.getHighCard();
			winner = compareHighCard(player1, player1Card, player2, player2Card);
			 if (winner == null) {
				 player1Card = getSecondHighCard(player1, player1Card);
				player2Card = getSecondHighCard(player2, player2Card);
				winner = compareHighCard(player1, player1Card, player2,
						player2Card);
			}
		}
		return winner;
	}

	private Player compareHighCard(Player player1, Card player1HighCard,
								   Player player2, Card player2HighCard) {
		if (player1HighCard.getRankToInt() > player2HighCard.getRankToInt()) {
			return player1;
		} else if (player1HighCard.getRankToInt() < player2HighCard.getRankToInt()) {
			return player2;
		}
		return null;
	}
	private Card getSecondHighCard(Player player, Card card) {
		if (player.getCards()[0].equals(card)) {
			return player.getCards()[1];
		}
		return player.getCards()[0];
	}

	public ArrayList<Card> getTableCards() {
		return tableCards;
	}

	public void checkPlayersRanking() {
		for (Player player : players) {
			if(player.isFold){
				return;
			}
			player.setRankingList(ranking.getWinningSequence(GameUtils.arrayToList(player.getCards()), tableCards));
			player.setRankingEnum(ranking.checkRanking(GameUtils.arrayToList(player.getCards()),tableCards));
		}
	}

	public void printPlayers(){
		for (int i = 0; i < getPlayers().size(); i++) {
			System.out.print("Player " + (i + 1) + " " +
					GameUtils.cardsToString(getPlayers().get(i).getCards()) +
					";Fold:" + getPlayers().get(i).isFold + " " +
					";Bet: " + getPlayers().get(i).getBet() + " " +
					";Bank: " + getPlayers().get(i).getBank() + " " +
					"Rank: " + getPlayers().get(i).getRankingEnum());
			System.out.println();
		}
	}
	public void printWinner() {
		Player winner = getWinner().get(0);
		int winnerIndex = 0;
		BetUtil.calculateBank(this);
		for (int i = 0; i < getPlayers().size(); i++) {
			if (Arrays.equals(winner.getCards(), getPlayers().get(i).getCards())) {
				winnerIndex = i;
			}
		}

		System.out.println("Table cards: " + GameUtils.cardsToString(getTableCards()));
		System.out.println(Arrays.toString(new String[]{"Player " + (winnerIndex + 1) + " " + GameUtils.cardsToString(getPlayers().get(winnerIndex).getCards()) + " "
				+ getPlayers().get(winnerIndex).getRankingEnum() + "; Bet: " + getPlayers().get(winnerIndex).getBet() +
				"; Bank: " + getPlayers().get(winnerIndex).getBank()}));
	}
}
