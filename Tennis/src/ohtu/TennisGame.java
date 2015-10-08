package ohtu;

public class TennisGame {

    private static final int OVER_FOURTY = 4;
    private static final int ONE_POINT = 1;
    private static final String SAME_SCORE_SUFFIX = "-All";

    private int player1Score = 0;
    private int player2Score = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if ("player1".equals(playerName)) {
            player1Score += ONE_POINT;
        } else {
            player2Score += ONE_POINT;
        }
    }

    public String getScore() {
        String tennisScore = "";
        if (player1Score == player2Score) {
            tennisScore = generateTennisScoreForEqualScores();
        } else if (eitherPlayerOverFourty()) {
            tennisScore = generateTennisScoreOverFourty();
        } else {
            tennisScore += convertPlayerScoreToTennisScore(player1Score);
            tennisScore += "-";
            tennisScore += convertPlayerScoreToTennisScore(player2Score);
        }
        return tennisScore;
    }

    private String convertPlayerScoreToTennisScore(int score) {
        String tennisScore;
        switch (score) {
            case 0:
                tennisScore = "Love";
                break;
            case ONE_POINT:
                tennisScore = "Fifteen";
                break;
            case 2:
                tennisScore = "Thirty";
                break;
            case 3:
                tennisScore = "Forty";
                break;
            default:
                throw new IllegalArgumentException();
        }
        return tennisScore;
    }

    private String generateTennisScoreOverFourty() {
        String tennisScore;
        int minusResult = player1Score - player2Score;
        if (minusResult == ONE_POINT) {
            tennisScore = "Advantage player1";
        } else if (minusResult == -1) {
            tennisScore = "Advantage player2";
        } else if (minusResult >= 2) {
            tennisScore = "Win for player1";
        } else {
            tennisScore = "Win for player2";
        }
        return tennisScore;
    }

    private boolean eitherPlayerOverFourty() {
        return player1Score >= OVER_FOURTY || player2Score >= OVER_FOURTY;
    }

    private String generateTennisScoreForEqualScores() {
        String convertedPlayerScoreToTennisScore;
        try {
            convertedPlayerScoreToTennisScore = convertPlayerScoreToTennisScore(player1Score);
            return convertedPlayerScoreToTennisScore + SAME_SCORE_SUFFIX;
        } catch (IllegalArgumentException iae) {
            return "Deuce";
        }
    }
}
