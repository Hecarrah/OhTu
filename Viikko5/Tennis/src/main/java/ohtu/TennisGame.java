package ohtu;

public class TennisGame {

    private int player1score = 0;
    private int player2score = 0;
    private String player1Name;
    private String player2Name;
    private final String[] scores = {"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            player1score += 1;
        } else {
            player2score += 1;
        }
    }

    private boolean overFour() {
        return (player1score >= 4 || player2score >= 4);
    }

    private boolean even() {
        return (player1score == player2score);
    }

    private String StringEven() {
        if (player1score < 4) {
            return scores[player1score] + "-All";
        }
        return "Deuce";
    }

    private String lead() {
        if (player1score > player2score) {
            return player1Name;
        } else {
            return player2Name;
        }
    }

    private String advantage() {
        return "Advantage " + lead();
    }

    private boolean win() {
        return overFour() && (Math.abs(player1score - player2score) >= 2);
    }

    private String getStringScore(int score) {
        if (score < 4) {
            return scores[score];
        } else {
            return null;
        }
    }

    public String getScore() {
        if (win()) {
            return "Win for " + lead();
        }
        if (even()) {
            return StringEven();
        }
        if (overFour()) {
            return advantage();
        }
        return getStringScore(player1score) + "-" + getStringScore(player2score);
    }
}
