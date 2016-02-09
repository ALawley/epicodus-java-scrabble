import org.junit.*;
import static org.junit.Assert.*;

public class ScrabbleScoreTest {

  @Test
  public void scrabbleScore_returnsAScrabbleScoreForALetter_1() {
    ScrabbleScore newScore = new ScrabbleScore();
    Integer score = 1;
    assertEquals(score, newScore.scoreCalculate("a"));
  }
  @Test
  public void scrabbleScore_returnsAScrabbleScoreForAWord_8() {
    ScrabbleScore newScore = new ScrabbleScore();
    Integer score =  8 ;
    assertEquals(score, newScore.scoreCalculate("hello"));
  }
  @Test
  public void scrabbleScore_returnsAScrabbleScoreForAllLetters_87() {
    ScrabbleScore newScore = new ScrabbleScore();
    Integer score = 87;
    assertEquals(score, newScore.scoreCalculate("abcdefghijklmnopqrstuvwxyz"));
  }
}
