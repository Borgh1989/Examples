package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static BufferedReader reader;
    public static FileOutputStream outputStream;
    public static FileInputStream inputStream;

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        inputStream = new FileInputStream(file1);
        outputStream = new FileOutputStream(file2);
        byte[] byffer = new byte[inputStream.available()];
        while (inputStream.available()>0) {
            int count = inputStream.read(byffer);
            for(int i=0, j=byffer.length-1; i<j; i++, j--) {
                byte zero= byffer[i];
                byffer[i]=byffer[j];
                byffer[j] = zero;
            }
            outputStream.write(byffer, 0, count);
        }

        inputStream.close();
        outputStream.close();

    }


}
