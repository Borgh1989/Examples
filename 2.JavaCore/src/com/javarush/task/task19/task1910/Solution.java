package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2));

        Pattern p = Pattern.compile("\\p{Punct}|\\n");
        while(fileReader.ready()) {
            String line = fileReader.readLine();
            Matcher m = p.matcher(line);
            line = m.replaceAll("");
            fileWriter.write(line);
        }


        fileReader.close();
        fileWriter.close();
    }
}
