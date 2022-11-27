package sc.vsu.Kotov;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        GameTexasHoldem game = new GameTexasHoldem();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insert amount of players\n>");
        int playerAmount = scanner.nextInt();
        while (playerAmount < 2) {
            System.out.print("Insert amount of players(more than 1)\n>");
            playerAmount = scanner.nextInt();
        }

        ArrayList<Player> players = new ArrayList<>();

        for (int i = 0; i < playerAmount; i++) {
            players.add(new Player());
        }
        Player dealer = new Player();
        game.newGame(new Deck(), dealer, players, 100);

        String currAction;

        game.deal();

        while (true) {
            int tableCardsAmount = game.getTableCards().size();

            if (tableCardsAmount == 5) {
                printWinner(game);
                System.out.print("new game?\n>");
                currAction = scanner.nextLine();
                if (Objects.equals(currAction, "yes")) {
                    ArrayList<Integer> banks = new ArrayList<>();
                    for (int i = 0; i < game.getPlayers().size(); i++) {
                        banks.add(game.getPlayers().get(i).getBank());
                    }
                    dealer = game.getPlayers().get(0);
                    game.getPlayers().remove(0);
                    game.newGame(new Deck(), dealer, game.getPlayers(), 100, banks);
                } else break;
            }

            System.out.print(">");
            currAction = scanner.nextLine();

            switch (currAction) {
                case "continue":
                    tableCardsAmount = game.getTableCards().size();
                    if (tableCardsAmount == 0) {
                        game.callFlop();
                    }
                    if (tableCardsAmount == 3) {
                        game.betTurn();
                    }
                    if (tableCardsAmount == 4) {
                        game.betRiver();
                    }
                    break;
                case "getCards":
                    for (int i = 0; i < game.getPlayers().size(); i++) {
                        System.out.println("Player " + (i + 1) + " Cards :" + Arrays.toString(new List[]{Arrays.asList(game.getPlayers().get(i).getCards())}) +
                                "; Fold:" + game.getPlayers().get(i).isFold + "; Bet: " + game.getPlayers().get(i).getBet() +
                        ";Bank: " + game.getPlayers().get(i).getBank());
                    }
                    System.out.println("Table Cards: " + Arrays.toString(new List[]{game.getTableCards()}));
                    break;
            }
        }
    }

    public static void printWinner(GameTexasHoldem game) {
        Player winner = game.getWinner().get(0);
        int winnerIndex = 0;
        BetUtil.calculateBank(game);
        for (int i = 0; i < game.getPlayers().size(); i++) {
            if (Arrays.equals(winner.getCards(), game.getPlayers().get(i).getCards())) {
                winnerIndex = i;
            }
        }

        System.out.println(Arrays.toString(new String[]{"Table cards: " + Arrays.toString(new List[]{game.getTableCards()})}));
        System.out.println(Arrays.toString(new String[]{"Player " + (winnerIndex + 1) + " Cards :" + Arrays.toString(Arrays.stream(winner.getCards()).toArray()) + " "
                + game.getPlayers().get(winnerIndex).getRankingEnum() + "; Bet: " + game.getPlayers().get(winnerIndex).getBet() +
                "; Bank: " + game.getPlayers().get(winnerIndex).getBank()}));
    }
}

