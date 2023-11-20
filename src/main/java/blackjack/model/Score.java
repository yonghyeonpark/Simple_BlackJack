package blackjack.model;

import java.util.HashMap;
import java.util.Map;

public class Score {

    private static final int INITIAL_VALUE = 0;
    private static final int INCREASE_VALUE = 1;
    private static final String VICTORY = "승";
    private static final String DEFEAT = "패";
    private static final String DRAW = "무";
    private static final String SPACE = " ";


    private final Map<String, Integer> score;

    public Score() {
        score = new HashMap<>();
        setUp();
    }

    private void setUp() {
        score.put(VICTORY, INITIAL_VALUE);
        score.put(DEFEAT, INITIAL_VALUE);
        score.put(DRAW, INITIAL_VALUE);
    }

    public void addVictory() {
        score.put(VICTORY, score.get(VICTORY) + INCREASE_VALUE);
    }

    public void addDefeat() {
        score.put(DEFEAT, score.get(DEFEAT) + INCREASE_VALUE);
    }

    public void addDraw() {
        score.put(DRAW, score.get(DRAW) + INCREASE_VALUE);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        existDraw(stringBuilder);
        notExistDraw(stringBuilder);
        return stringBuilder.toString();
    }

    private void existDraw(StringBuilder stringBuilder) {
        if (score.get(DRAW) != INITIAL_VALUE) {
            stringBuilder.append(score.get(VICTORY))
                    .append(VICTORY)
                    .append(SPACE)
                    .append(score.get(DRAW))
                    .append(DRAW)
                    .append(SPACE)
                    .append(score.get(DEFEAT))
                    .append(DEFEAT);
        }
    }

    private void notExistDraw(StringBuilder stringBuilder) {
        if (score.get(DRAW) == INITIAL_VALUE) {
            stringBuilder.append(score.get(VICTORY))
                    .append(VICTORY)
                    .append(SPACE)
                    .append(score.get(DEFEAT))
                    .append(DEFEAT);
        }
    }
}
