import java.util.HashMap;

public class ScrabbleScore {
  public static void main( String[] args ) {

  }
  public static Integer scoreCalculate(String word) {
    Integer wordScore = 0;
    char[] letters = word.toCharArray();
    HashMap<Character, Integer> values = new HashMap<Character, Integer>(){{
      put('a', 1);
    }};

    for (char letter : letters) {
      wordScore += values.get(letter);
    }
    return wordScore;
  }
}
