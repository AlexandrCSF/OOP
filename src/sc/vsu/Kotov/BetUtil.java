package sc.vsu.Kotov;

public class BetUtil {
    public static void calculateBet(Player player,GameTexasHoldem game){
        if(player.isFold)
            return;
        switch (player.getRankingEnum()){
            case ROYAL_FLUSH:
            case STRAIGHT_FLUSH:
            case FOUR_OF_A_KIND:
                player.setBet(Math.max(game.getCallBet(), player.getBank()));
                game.setCallBet(Math.max(game.getCallBet(), player.getBet()));
                return;
            case FULL_HOUSE:
                player.setBet(Math.max(game.getCallBet(), (player.getBank() / 3) * 2));
                game.setCallBet(Math.max(game.getCallBet(), player.getBet()));
                return;
            case FLUSH:
            case STRAIGHT:
                player.setBet(Math.max(game.getCallBet(), (player.getBank() / 4) * 3));
                game.setCallBet(Math.max(game.getCallBet(), player.getBet()));
                return;
            case THREE_OF_A_KIND:
            case TWO_PAIR:
            case ONE_PAIR:
                player.setBet(game.getCallBet());
                return;
            case HIGH_CARD:
                if(player.getHighCard().getRank().equals(CardRank.ACE) ||
                        player.getHighCard().getRank().equals(CardRank.KING) ||
                        player.getHighCard().getRank().equals(CardRank.QUEEN)){
                    if(game.getCallBet() < player.getBank() / 5)
                    player.setBet(game.getCallBet());
                    else player.isFold = true;
                }
                else
                    if(game.getCallBet() == game.getBigBlind())
                        player.setBet(game.getCallBet());
                    else player.isFold = true;
                }
        }

        public static void calculateBank(GameTexasHoldem game){
            for(Player player: game.getPlayers()){
                if(game.getWinner().contains(player)){
                    player.setBank(player.getBank() + game.getBank());
                } else player.setBank(player.getBank() - player.getBet());

            }
        }
    }
