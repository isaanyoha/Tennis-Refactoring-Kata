public class TennisGame2 implements TennisGame {
    private int player1Points = 0;
    private int player2Points = 0;
    private String player1Name;
    private String player2Name;

    private static final String[] scoreNames = {"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";

        if (player1Points == player2Points) {
            if (player1Points < 4) {
                score = scoreNames[player1Points] + "-All";
            } else {
                score = "Deuce";
            }
        } else if (player1Points >= 4 || player2Points >= 4) {
            int difference = player1Points - player2Points;
            if (difference == 1) {
                score = "Advantage " + player1Name;
            } else if (difference == -1) {
                score = "Advantage " + player2Name;
            } else if (difference >= 2) {
                score = "Win for " + player1Name;
            } else {
                score = "Win for " + player2Name;
            }
        } else {
            score = scoreNames[player1Points] + "-" + scoreNames[player2Points];
        }

        return score;
    }

    public void setPlayer1Score(int number) {
        for (int i = 0; i < number; i++) {
            player1Scores();
        }
    }

    public void setPlayer2Score(int number) {
        for (int i = 0; i < number; i++) {
            player2Scores();
        }
    }

    public void player1Scores() {
        player1Points++;
    }

    public void player2Scores() {
        player2Points++;
    }

    public void wonPoint(String player) {
        if (player.equals(player1Name)) {
            player1Scores();
        } else if (player.equals(player2Name)) {
            player2Scores();
        }
    }
}
