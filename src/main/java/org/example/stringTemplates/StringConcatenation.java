package org.example.stringTemplates;

public final class StringConcatenation {

    private StringConcatenation() {
        throw new RuntimeException("Cannot be instantiated");
    }

    public String calculateScore(String name, int score) {
        return "Player " + name + " scored " + score + " points" +
                " and " + (score > 100 ? "won" : "lost") + ".";
    }
}
