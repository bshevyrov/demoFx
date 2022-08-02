package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public  class WifiUtils {
    private static String commamd = "iwconfig";

   static List<String> getWlanDevicesName() {


        Process p = null;
        String line = "";
        try {
            p = Runtime.getRuntime().exec(commamd);


        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

        return reader.lines()
                .collect(Collectors.filtering(s -> s.startsWith("w"),Collectors.toList()))
                .stream()
                .map(s -> s.substring(0,s.indexOf(" ")))
                .collect(Collectors.toList());
//                .peek(System.out::println)
//                .filter(s -> s.startsWith("w"))
//                .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}