package sk.sportradar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import sk.sportradar.data.Match;

/**
 * The Score board library class.
 */
public class ScoreBoard {

    private final List<Match> scoreList = new ArrayList<>();

    /**
     * Start new game match with initial score 0-0 and adding it the scoreboard.
     *
     * @param homeTeam the home team
     * @param awayTeam the away team
     * @return the match
     */
    public Match startNewGame(String homeTeam, String awayTeam) {
        Match match = new Match(homeTeam, awayTeam);
        scoreList.add(match);
        return match;
    }

    /**
     * Update score of the match.
     *
     * @param match the match
     * @param homeScore the home score
     * @param awayScore the away score
     */
    public void updateScore(Match match, int homeScore, int awayScore) {
        match.setHomeScore(homeScore);
        match.setAwayScore(awayScore);
    }

    /**
     * Finish game currently in progress. This removes a match from the scoreboard..
     *
     * @param match the match
     */
    public void finishGame(Match match) {
        scoreList.remove(match);
    }

    /**
     * Gets all games in progress ordered by their total score. The games with the same
     * total score will be returned ordered by the most recently started match in the scoreboard.
     *
     * @return the summary
     */
    public List<Match> getSummary() {
        List<Match> scoreBoardCopy = new ArrayList<>(scoreList);
        Collections.reverse(scoreBoardCopy);
        return scoreBoardCopy.stream().sorted(Comparator.comparingInt(Match::getTotalScore).reversed()).collect(Collectors.toList());
    }
}
