package org.example.PatternMatching;

import java.awt.*;

public class PatternMatching {
    record Point(int x, int y) {};

    sealed interface Shape permits Circle, Rectangle, Triangle, Shapes {};
    record Circle(double radius) implements Shape {}
    record Rectangle(double length, double width) implements Shape {}
    record Triangle(double base, double height) implements Shape {}
    public enum Shapes implements Shape {CIRCLE, RECTANGLE, TRIANGLE};

    public static void main(String[] args) {

        // Nesneleri tiplerine göre filtreleme

        // Nested if lerin oluşması

        // Seale dile beraber patterrn matching

    }

    public static void filterObjectsByType(Object o) {
        // Java 21'den önce
        if (o instanceof String s) {
            System.out.println(String.format("This is a string -> %s", s));
        } else if(o instanceof Integer i) {
            System.out.println(String.format("This is a int -> %d", i));
        } else if(o instanceof Long l) {
            System.out.println(String.format("This is a long -> %d", l));
        } else if (o instanceof Point(int x, int y)) {
            System.out.println(String.format("This is a Temp Object -> (%d, %d)", x, y));
        } else {
            System.out.println("Unknown Type");
        }

        // Java 21
        // Birden çok case i tek seferde kontrol edebiliyoruz.
        switch (o) {
            case Integer i -> System.out.println(String.format("This is a int -> %d", i));
            case Long l -> System.out.println(String.format("This is a long -> %d", l));
            case Double d -> System.out.println(String.format("This is a double -> %f", d));
            case String s -> System.out.println(String.format("This is a string -> %f", s));
            case null, default -> System.out.println("This is a NULL value!!!");
        }
    }

    public static boolean nestedCases(String msg) {
        switch (msg) {
            case String s
                    when s.equals("YES") -> {
                System.out.println("WELCOME!!!");
                return true;
            }
            case String s
                    when s.equals("NO") -> {
                System.out.println("BY BY!!!");
                return false;
            }
            case "y", "Y" -> {
                System.out.println("WELCOME!!!");
                return true;
            }
            case "n", "N" -> {
                System.out.println("BY BY!!!");
                return false;
            }
            case null, default -> {
                System.out.println("Unfortunately we could not understand that you said");
                return false;
            }
        }
    }

    public static void exhaustiveSwitch(Shape s) {
        switch (s) {
            case Shapes.CIRCLE -> System.out.println("It is circle");
            case Shapes.RECTANGLE -> System.out.println("It is rectangle");
            case Shapes.TRIANGLE -> System.out.println("It is a triangle");
            default -> System.out.println("Unknown Shape");
        }
    }

    public static void enumSwitch(Shapes s) {
        switch (s) {
            case CIRCLE -> System.out.println("It is circle");
            case RECTANGLE -> System.out.println("It is rectangle");
            case TRIANGLE -> System.out.println("It is a triangle");
            default -> System.out.println("Unknown Shape");
        }
    }

    public static void subClassSwitch(Object o) {
        switch (o) {
            case String s ->    // charsequence tarafından baskılanıyor
                    System.out.println("A string: " + s);
            case CharSequence cs ->
                    System.out.println("A sequence of length " + cs.length());
            default -> {
                break;
            }
        }
    }

    public static int multipleCaseSwitch(Integer i) {
        switch (i) {
            case -1, 1 -> {
                return 0;
            }
            case Integer j when j > 0 -> {
                return 1;
            }
            default -> {
                return -1;
            }
        }
    }

    public static void exhaustiveSwitch(Shapes s) {
        switch (s) {
            case TRIANGLE -> System.out.println("NOT EXHAUSTIVE");
        }

        switch (s) {
            case TRIANGLE, RECTANGLE -> System.out.println("EXHAUSTIVE");
            case CIRCLE -> System.out.println("EXHAUSTIVE");
        }
    }
}
