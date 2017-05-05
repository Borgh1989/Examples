package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.*;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        Map<String, Double> map = new TreeMap<String, Double>();
        BufferedReader reader = new BufferedReader(
                new FileReader(args[0]));




        while(reader.ready()) {
            String line = reader.readLine();


            String [] words = line.split(" ");

            String name = words[0];
            double value = Double.parseDouble(words[1]);

            if(map.containsKey(name)) {
                double d = map.get(name);
                d+=value;
                map.put(name, d);
            } else map.put(name, value);

        }
        reader.close();



        for(Map.Entry<String, Double> entry : map.entrySet() ) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
