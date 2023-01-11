package sk.sportradar.data;

public class Match {

    private final String homeTeam;

    private final String awayTeam;

    private int homeScore;

    private int awayScore;

    public Match(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public void setHomeScore(int homeScore) {

        this.homeScore = homeScore;
    }

    public void setAwayScore(int awayScore) {

        this.awayScore = awayScore;
    }

    public String getHomeTeam() {

        return homeTeam;
    }

    public int getHomeScore() {

        return homeScore;
    }

    public int getAwayScore() {

        return awayScore;
    }

    public String getAwayTeam() {

        return awayTeam;
    }

    public int getTotalScore() {
        return homeScore + awayScore;
    }

    @Override
    public String toString() {

        return homeTeam + " " + homeScore + " - " + awayTeam + " " + awayScore;
    }
}
