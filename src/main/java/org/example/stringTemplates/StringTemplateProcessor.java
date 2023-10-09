package org.example.stringTemplates;

import org.example.stringTemplates.component.JSONException;
import org.example.stringTemplates.component.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static java.lang.StringTemplate.interpolate;

public class StringTemplateProcessor {
    public static void main(String[] args) {
        java.lang.StringTemplate.Processor<JSONObject, JSONException> JSON_VALIDATE =
                (StringTemplate st1) -> {
                    String quote = "\"";
                    List<Object> filtered = new ArrayList<>();
                    for (Object value : st1.values()) {
                        if (value instanceof String str) {
                            if (str.contains(quote)) {
                                throw new JSONException();
                            }
                            filtered.add(quote + str + quote);
                        } else if (value instanceof Number ||
                                value instanceof Boolean) {
                            filtered.add(value);
                        } else {
                            throw new JSONException();
                        }
                    }
                    String jsonSource =
                            interpolate(st1.fragments(), filtered);
                    return new JSONObject(jsonSource);
                };

        String name = "Joan Smith";
        String phone = "555-123-4567";
        String address = "1 Maple Drive, Anytown";
        try {
            JSONObject doc = JSON_VALIDATE. """
        {
            "name":    \{ name },
            "phone":   \{ phone },
            "address": \{ address }
        };
        """ ;

        } catch (JSONException ex) {
            System.out.println("JSON hatası");
        }
    }
}
