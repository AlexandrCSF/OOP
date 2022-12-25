package sc.vsu.Kotov;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameTexasHoldem game = new GameTexasHoldem();
        game.newGame(3, 100);
        game.deal();

        String newGame = "";
        while (true) {
            game.callFlop();
            game.betTurn();
            game.betRiver();
            game.printPlayers();
            game.printWinner();

            System.out.print("new game?\n>");
            newGame = scanner.nextLine();

            while (true) {
                if (Objects.equals(newGame, "yes")) {
                    game.newGame();
                    break;
                } else if (Objects.equals(newGame, "no")) {
                    break;
                } else {
                    System.out.print("new game?\n>");
                    newGame = scanner.nextLine();
                }
            }
            if(Objects.equals(newGame, "no"))
                break;
        }
    }
}

