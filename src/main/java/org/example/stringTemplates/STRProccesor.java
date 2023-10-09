package org.example.stringTemplates;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static java.lang.StringTemplate.STR;

public class STRProccesor {

    private final String channelName;

    public STRProccesor(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelName() {
        return channelName;
    }

    public static STRProccesor of(String channelName) {
        return new STRProccesor(channelName);
    }

    public static void main(String[] args) {
        printBasicStr("FOLKSDEV BASIC VALUE");
        printJsonStructure(
                "YOUTUBE",
                "FOLKSDEV"
        );
        printMethod("FOLKSDEV");

    }

    public static void printBasicStr(String value) {
        String s = STR. "paramters value = \{ value }";
        System.out.println(s);
    }

    public static void printJsonStructure(String oldValue, String newValue) {
        String json = STR. """
                {
                  "squadName": \{ oldValue },
                  "homeTown": \{ newValue},
                }
                """ ;

        System.out.println(json);
    }


    public static void printMethod(String value) {
        STRProccesor STRProccesor = org.example.stringTemplates.STRProccesor.of(value);
        String methodResult = STR. "channel name = \{ STRProccesor.getChannelName().toLowerCase() }" ;
        System.out.println(methodResult);
    }

    public static void innerFunctionInSTR() {
        String dateSTR = STR. "Current date is \{
                DateTimeFormatter
                        .ofPattern("HH:mm:ss")
                        .format(LocalTime.now())
                } deneme12" ;
        System.out.println(dateSTR);
    }


}