package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        List<Double> list = new ArrayList<Double>();

        BufferedReader bfr = new BufferedReader(new FileReader(file1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));

        while(bfr.ready()) {
            String line = bfr.readLine();
            String[] words = line.split(" ");
            double count;
            for(String word : words) {
                count = Double.parseDouble(word);
                list.add(count);
            }
        }

        for(int i=0; i<list.size(); i++) {
            int rounded = (int)Math.round(list.get(i));
            writer.write(String.valueOf(rounded));
            if(i+1<list.size())
                writer.write(" ");
        }
        writer.flush();
        bfr.close();
        writer.close();

    }
}
