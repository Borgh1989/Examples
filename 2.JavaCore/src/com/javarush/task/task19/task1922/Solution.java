package com.javarush.task.task19.task1922;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader readName = new BufferedReader(
                                        new InputStreamReader(System.in));

        String fileName = readName.readLine();
        readName.close();

        BufferedReader reader = new BufferedReader(
                                        new FileReader(fileName));


        while(reader.ready()) {
            String line = reader.readLine();
            getWords(line);

        }

        reader.close();


    }

    public static void getWords(String line) {
        int count=0;
        String [] wordsOfFile = line.split(" ");

        for (int i=0; i<wordsOfFile.length; i++) {
            for(int j=0; j<words.size(); j++) {
                if(wordsOfFile[i].equals(words.get(j))) {
                    count++;
                }
            }
        }
        if(count==2) {
            System.out.println(line);

        }



    }
}
