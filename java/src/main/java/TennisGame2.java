public class TennisGame2 implements TennisGame {
    // Variables to track player scores and names
    private int player1Points = 0;
    private int player2Points = 0;
    private String player1Name;
    private String player2Name;

    // Array to store score names
    private static final String[] scoreNames = {"Love", "Fifteen", "Thirty", "Forty"};

    // Constructor to initialize player names
    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    // Method to calculate and return current score
    public String getScore() {
        if (player1Points == player2Points) {
            // Handle tied scores
            return player1Points < 4 ? scoreNames[player1Points] + "-All" : "Deuce";
        } else if (player1Points >= 4 || player2Points >= 4) {
            // Handle advantage and win scenarios
            int difference = player1Points - player2Points;
            return Math.abs(difference) == 1 ? "Advantage " + (difference == 1 ? player1Name : player2Name) :
                    "Win for " + (difference > 1 ? player1Name : player2Name);
        } else {
            // Handle regular scoring
            return scoreNames[player1Points] + "-" + scoreNames[player2Points];
        }
    }

    // Method to increment player 1's score
    public void setPlayer1Score(int number) {
        for (int i = 0; i < number; i++) {
            player1Scores();
        }
    }

    // Method to increment player 2's score
    public void setPlayer2Score(int number) {
        for (int i = 0; i < number; i++) {
            player2Scores();
        }
    }

    // Helper method to increment player 1's score
    private void player1Scores() {
        player1Points++;
    }

    // Helper method to increment player 2's score
    private void player2Scores() {
        player2Points++;
    }

    // Method to record a point won by a player
    public void wonPoint(String player) {
        if (player.equals(player1Name)) {
            player1Scores();
        } else if (player.equals(player2Name)) {
            player2Scores();
        }
    }
}
