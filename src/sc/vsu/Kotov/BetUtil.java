package sc.vsu.Kotov;

import java.util.ArrayList;

public class BetUtil {
    public static void calculateBet(Player player){
        if(player.isFold)
            return;
        switch (player.getRankingEnum()){
            case ROYAL_FLUSH:
            case STRAIGHT_FLUSH:
            case FOUR_OF_A_KIND:
                player.setBet(player.getBank());
                return;
            case FULL_HOUSE:
                player.setBet((player.getBank()/3) * 2);
                return;
            case FLUSH:
            case STRAIGHT:
                player.setBet((player.getBank() / 4) * 3);
                return;
            case THREE_OF_A_KIND:
                player.setBet((player.getBank() /5) * 2);
                return;
            case TWO_PAIR:
            case ONE_PAIR:
                player.setBet((player.getBank() / 10));
                return;
            case HIGH_CARD:
                if(player.getHighCard().getRank().equals(CardRankEnum.ACE) ||
                        player.getHighCard().getRank().equals(CardRankEnum.KING) ||
                        player.getHighCard().getRank().equals(CardRankEnum.QUEEN)){
                    player.setBet((player.getBank() / 10));}
                else  player.isFold = true;
                }
        }
        public static void calculateBank(GameTexasHoldem game){
            for(Player player: game.getPlayers()){
                if(game.getWinner().contains(player)){
                    player.setBank(player.getBank() + player.getBet());
                } else player.setBank(player.getBank() - player.getBet());

            }
        }
    }
