package org.example.stringTemplates;

public final class StringBuilderOrBuffer {

    private StringBuilderOrBuffer() {
        throw new RuntimeException("Cannot be instantiated");
    }

    public String calculateScore(String name, int score) {
        return new StringBuilder("Player ")
                .append(name)
                .append(" scored ")
                .append(score)
                .append(" points")
                .append(" and ")
                .append(score > 100 ? "won" : "lost")
                .append(".")
                .toString();
    }
}
