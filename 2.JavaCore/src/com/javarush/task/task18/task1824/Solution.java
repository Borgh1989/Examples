package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName ="";
        try {
            while (true) {
                fileName = reader.readLine();
                FileReader fileReader = new FileReader(fileName);
                fileReader.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println(fileName);
        } finally {
            reader.close();

        }



    }
}