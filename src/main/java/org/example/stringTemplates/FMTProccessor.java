package org.example.stringTemplates;

import static java.util.FormatProcessor.FMT;

public class FMTProccessor {

    public static void main(String[] args) {
        System.out.println(interpolationOfJSONBlockWithFMT("34", 3.4f, "selam"));
    }

    static String interpolationOfJSONBlockWithFMT(String feelsLike, float temperature, String unit) {
        return FMT
                . """
      {
        "feelsLike": "%10s\{ feelsLike }",
        "temperature": "%2.3f\{ temperature }",
        "unit": "%1s\{ unit }"
      }
      """ ;
    }

}
