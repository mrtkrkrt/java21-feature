package org.example.stringTemplates;

import java.util.List;

import static java.lang.StringTemplate.RAW;

public class RAWprocessor {

    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        StringTemplate st = RAW. "\{ x } plus \{ y } equals \{ x + y }" ;
        List<String> fragments = st.fragments();
        List<Object> values = st.values();
        String result = String.join("\\{}", fragments);
        System.out.println("\n\n");
        System.out.println(fragments);
        System.out.println(values);
        System.out.println(result);


        for (int k = 0; k < 3; k++) {
            st = RAW. "\{ k } plus \{ y } equals \{ k + y }" ;
            System.out.println(st);
        }
    }
}
