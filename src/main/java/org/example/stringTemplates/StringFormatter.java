package org.example.stringTemplates;

public class StringFormatter {
    private StringFormatter() {
        throw new RuntimeException("Cannot be instantiated");
    }

    public static String calculateScore(String name, int score) {
        return String.format("Player %s scored %d points and %s.",
                name, score, score > 100 ? "won" : "lost");
    }
}
