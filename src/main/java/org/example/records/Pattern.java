package org.example.records;

public class Pattern {

    /*
        ----   RECORD PATTERNS
    Prior to Java 16
    if (obj instanceof String) {
    String s = (String)obj;
    ... use s ...
}

    // As of Java 16
    if (obj instanceof String s) {
    ... use s ...


    // As of Java 16
    record Point(int x, int y) {}

    static void printSum(Object obj) {
        if (obj instanceof Point p) {
            int x = p.x();
            int y = p.y();
        System.out.println(x+y);
    }
}
}

     */

    public static void main(String[] args) {
        MyPoint x = new MyPoint(10, 10);
        decision(x);

        Rectangle r = new Rectangle(new ColoredPoint(new Point(2,2),Color.BLUE),new ColoredPoint(new Point(2,2),Color.GREEN));
        printUpperLeftColoredPoint(r);

        up();

        recordInference(new MyPair<>("FURKAN -> ", 12));

        nestedBody(new Body<>(new Body<>(22)));
    }

    public static void decision(Object x) {
        if (x instanceof MyPoint(int y, int z)) {
            System.out.println(y + z);
        }
    }

    /*
       ---- NESTED RECORD PATTERNS
       // As of Java 16
        record Point(int x, int y) {}
        enum Color { RED, GREEN, BLUE }
        record ColoredPoint(Point p, Color c) {}
        record Rectangle(ColoredPoint upperLeft, ColoredPoint lowerRight) {}
     */

    static void printUpperLeftColoredPoint(Rectangle r) {
        if (r instanceof Rectangle(ColoredPoint ul, ColoredPoint lr)) {
            System.out.println(ul.p());
        }
    }

    static void up() {
        record Pair(Object x, Object y) {}

        Pair p = new Pair(42, 42);

        if (p instanceof Pair(String s, String t)) {
            System.out.println(s + ", " + t);
        } else {
            System.out.println("Not a pair of strings");
        }

    }

    record Point(int x, int y) {}
    enum Color { RED, GREEN, BLUE }
    record ColoredPoint(Point p, Color c) {}
    record Rectangle(ColoredPoint upperLeft, ColoredPoint lowerRight) {}

    record MyPair<S,T>(S fst, T snd){};
    record Body<T>(T request){};

    static void recordInference(MyPair<String, Integer> pair) {
        switch (pair) {
            case MyPair(var f, var s) -> System.out.println(f + s);
        }
    }

    static void nestedBody(Body<Body<Integer>> bodyBody) {
        switch (bodyBody) {
            case Body(var body) -> System.out.println(body.request);
        }

        if (bodyBody instanceof Body<Body<Integer>>(Body(var rq))) {
            System.out.println(rq);
        }
    }
}
