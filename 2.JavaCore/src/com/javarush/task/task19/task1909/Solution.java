package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1= reader.readLine();
        String file2= reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(file1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file2));

        Pattern p = Pattern.compile("\\.");

        while(fileReader.ready()) {
            String line = fileReader.readLine();
            Matcher m = p.matcher(line);
            line = m.replaceAll("!");
            fileWriter.write(line);
        }


        fileReader.close();
        fileWriter.close();





    }
}
