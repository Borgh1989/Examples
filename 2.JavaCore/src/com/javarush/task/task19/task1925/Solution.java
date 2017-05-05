package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {

        String fileName_1 = args[0]; //"c:/test/testFile.txt";
        String fileName_2 = args[1]; //"c:/test/testFile2.txt";

        List<String> list = new ArrayList<String>();

        Reader fileReader = new FileReader(fileName_1);
        BufferedReader bfr = new BufferedReader(fileReader);

        FileWriter writer = new FileWriter(fileName_2);

        while(bfr.ready()) {

            String line = bfr.readLine();
            String[] words = line.split(" ");

            for(int i=0; i<words.length; i++) {
                if(words[i].length()>6) {
                    list.add(words[i]);
                }
            }
        }
        int k=list.size();
        for(String word : list) {
            writer.write(word);

            if(k>1) {
                writer.write(",");
                k--;
            }

        }


        bfr.close();
        writer.close();

    }
}
