package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, Double> map = new TreeMap<String, Double>();
        BufferedReader reader = new BufferedReader(
                                    new FileReader(args[0]));

        while(reader.ready()) {
            String line = reader.readLine();
            String words[] = line.split(" ");
            String name = words[0];
            double value = Double.parseDouble(words[1]);

            if(map.containsKey(name)) {
                map.put(name, map.get(name)+value);
            } else map.put(name, value);

        }

        double count=0.0;
        for(Map.Entry <String, Double> entry : map.entrySet()) {
            if(entry.getValue()>count) count = entry.getValue();
        }
        for(Map.Entry <String, Double> entry : map.entrySet()) {
            if(entry.getValue()==count)
                System.out.println(entry.getKey());
        }



        reader.close();

    }
}
