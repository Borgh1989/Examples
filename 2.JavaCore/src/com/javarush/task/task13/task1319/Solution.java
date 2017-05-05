package com.javarush.task.task13.task1319;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Запись в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        String fileName = reader.readLine();
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(fileName));
        List<String> list = new ArrayList<String>();
        while(true) {
            String text=reader.readLine();
            list.add(text);
            if(text.equals("exit")) {

                break;
            }
        }



        for(String line : list)
            bufferedWriter.write(line+"\n");


        reader.close();
        bufferedWriter.close();

        // напишите тут ваш код
    }
}
