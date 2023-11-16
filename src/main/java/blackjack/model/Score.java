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
    }
}
