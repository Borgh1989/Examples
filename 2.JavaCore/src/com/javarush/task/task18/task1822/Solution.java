package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader readerFileName = new BufferedReader (new InputStreamReader(System.in));
        String name = readerFileName.readLine();
        readerFileName.close();







        BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(name)));

        while(bfr.ready()) {
            String line = bfr.readLine();
            String[] words = line.split(" ");
            if (words[0].equals(args[0])) {
                System.out.println(line);

            }
        }

        bfr.close();





    }


}
