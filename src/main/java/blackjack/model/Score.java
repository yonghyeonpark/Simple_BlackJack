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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        existDraw(stringBuilder);
        notExistDraw(stringBuilder);
        return stringBuilder.toString();
    }

    private void existDraw(StringBuilder stringBuilder) {
        if (score.get("무") != 0) {
            stringBuilder.append("현재 전적: ")
                    .append(score.get("승"))
                    .append("승 ")
                    .append(score.get("무"))
                    .append("무 ")
                    .append(score.get("패"))
                    .append("패");
        }
    }

    private void notExistDraw(StringBuilder stringBuilder) {
        if (score.get("무") == 0) {
            stringBuilder.append("현재 전적: ")
                    .append(score.get("승"))
                    .append("승 ")
                    .append(score.get("패"))
                    .append("패");
        }
    }
}
