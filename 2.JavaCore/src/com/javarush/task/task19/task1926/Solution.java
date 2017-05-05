package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(
                                    new InputStreamReader(System.in));
        String fileName = bfr.readLine();
        bfr.close();
        BufferedReader reader = new BufferedReader(
                                    new FileReader(fileName));

        while(reader.ready()) {
            String line = reader.readLine();
            char[] letters = line.toCharArray();
            for(int i=0; i<letters.length/2; i++) {
                char ch = letters[i];
                letters[i] = letters[letters.length-1-i];
                letters[letters.length-1-i] = ch;

            }
            System.out.println(letters);


            /*
            0 1 2 3 4 5
            5 4 3 2 1 0
            c:/test/testFile.txt
             */

        }

        reader.close();

    }
}
