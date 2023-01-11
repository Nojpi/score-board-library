import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sk.sportradar.ScoreBoard;
import sk.sportradar.data.Match;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreBoardTest {

    ScoreBoard scoreBoard;
    @BeforeEach
    void init() {
        scoreBoard = new ScoreBoard();
    }

    @Test
    void addMatchTest() {
        assertEquals(0, scoreBoard.getSummary().size());
        scoreBoard.startNewGame("England", "France");
        assertEquals(1, scoreBoard.getSummary().size());
        assertEquals(0, scoreBoard.getSummary().get(0).getTotalScore());
    }

    @Test
    void updateScoreTest() {
        Match match = scoreBoard.startNewGame("England", "France");
        assertEquals(0, scoreBoard.getSummary().get(0).getTotalScore());
        scoreBoard.updateScore(match, 2, 1);
        assertEquals(3, scoreBoard.getSummary().get(0).getTotalScore());
        assertEquals(2, scoreBoard.getSummary().get(0).getHomeScore());
        assertEquals(1, scoreBoard.getSummary().get(0).getAwayScore());
    }

    @Test
    void finishGameTest() {
        Match match1 = scoreBoard.startNewGame("Argentina", "Croatia");
        Match match2 = scoreBoard.startNewGame("France", "Morocco");
        assertEquals(2, scoreBoard.getSummary().size());
        scoreBoard.finishGame(match1);
        assertEquals(1, scoreBoard.getSummary().size());
        scoreBoard.finishGame(match1);
        assertEquals(1, scoreBoard.getSummary().size());
        scoreBoard.finishGame(match2);
        assertEquals(0, scoreBoard.getSummary().size());
    }


    @Test
    void getSummaryExampleTest() throws InterruptedException {
        Match match1 = scoreBoard.startNewGame("Mexico", "Canada");
        Match match2 = scoreBoard.startNewGame("Spain", "Brazil");
        Match match3 = scoreBoard.startNewGame("Germany", "France");
        Match match4 = scoreBoard.startNewGame("Uruguay", "Italy");
        Match match5 = scoreBoard.startNewGame("Argentina", "Australia");
        scoreBoard.updateScore(match1, 0, 5);
        scoreBoard.updateScore(match2, 10, 2);
        scoreBoard.updateScore(match3, 2, 2);
        scoreBoard.updateScore(match4, 6, 6);
        scoreBoard.updateScore(match5, 3, 1);
        List<Match> summary = scoreBoard.getSummary();
        assertEquals("Uruguay", summary.get(0).getHomeTeam());
        assertEquals("Italy", summary.get(0).getAwayTeam());
        assertEquals("Spain", summary.get(1).getHomeTeam());
        assertEquals("Mexico", summary.get(2).getHomeTeam());
        assertEquals("Argentina", summary.get(3).getHomeTeam());
        assertEquals("Germany", summary.get(4).getHomeTeam());

    }
}
