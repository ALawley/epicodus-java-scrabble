import org.junit.*;
import static org.junit.Assert.*;

public class ScrabbleScoreTest {

  @Test
  public void scrabbleScore_returnsAScrabbleScoreForALetter_1() {
    ScrabbleScore newScore = new ScrabbleScore();
    Integer score = 1;
    assertEquals(score, newScore.scoreCalculate("a"));
  }
}
