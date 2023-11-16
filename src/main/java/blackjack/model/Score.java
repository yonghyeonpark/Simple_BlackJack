package blackjack.model;

import java.util.HashMap;
import java.util.Map;

public class Score {

    private final Map<String, Integer> score;

    public Score() {
        score = new HashMap<>();
        setUp();
    }

    private void setUp() {
        score.put("승", 0);
        score.put("패", 0);
        score.put("무", 0);
    }

    public void addVictory() {
        score.put("승", score.get("승") + 1);
    }

    public void addDefeat() {
        score.put("패", score.get("패") + 1);
    }

    public void addDraw() {
        score.put("무", score.get("무") + 1);
    }
}
