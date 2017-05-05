package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1=reader.readLine();
        String file2=reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(file1));
        BufferedWriter fileWriter = new BufferedWriter (new FileWriter (file2));

        while(fileReader.ready()) {

            String line = fileReader.readLine();
            String[] words = line.split(" ");
            for(String word : words) {
                try {
                    int count = Integer.parseInt(word);
                    fileWriter.write(Integer.toString(count).concat(" "));
                } catch (Exception e) {

                }
            }
        }



        fileReader.close();
        fileWriter.close();
    }
}
