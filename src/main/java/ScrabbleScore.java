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
    HashMap<Character, Integer> values = new HashMap<Character, Integer>(){{
      put('a', 1);
      put('e', 1);
      put('i', 1);
      put('o', 1);
      put('u', 1);
      put('l', 1);
      put('n', 1);
      put('r', 1);
      put('s', 1);
      put('t', 1);
      put('d', 2);
      put('g', 2);
      put('b', 3);
      put('c', 3);
      put('m', 3);
      put('p', 3);
      put('f', 4);
      put('h', 4);
      put('v', 4);
      put('w', 4);
      put('y', 4);
      put('k', 5);
      put('j', 8);
      put('x', 8);
      put('q', 10);
      put('z', 10);
    }};

    for (char letter : letters) {
      wordScore += values.get(letter);
    }
    return wordScore;
  }
}
