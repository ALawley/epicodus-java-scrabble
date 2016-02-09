import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class ScrabbleScore {
  public static void main( String[] args ) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/calculator", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/calculator.vtl");

      String word = request.queryParams("word");
      Integer result = scoreCalculate(word);

      model.put("result", result);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
  public static Integer scoreCalculate(String word) {
    Integer wordScore = 0;
    char[] letters = word.toLowerCase().toCharArray();
    HashMap<Character, Integer> values = new HashMap<Character, Integer>();
      values.put('a', 1);
      values.put('e', 1);
      values.put('i', 1);
      values.put('o', 1);
      values.put('u', 1);
      values.put('l', 1);
      values.put('n', 1);
      values.put('r', 1);
      values.put('s', 1);
      values.put('t', 1);
      values.put('d', 2);
      values.put('g', 2);
      values.put('b', 3);
      values.put('c', 3);
      values.put('m', 3);
      values.put('p', 3);
      values.put('f', 4);
      values.put('h', 4);
      values.put('v', 4);
      values.put('w', 4);
      values.put('y', 4);
      values.put('k', 5);
      values.put('j', 8);
      values.put('x', 8);
      values.put('q', 10);
      values.put('z', 10);

    for (char letter : letters) {
      wordScore += values.get(letter);
    }
    return wordScore;
  }
}
