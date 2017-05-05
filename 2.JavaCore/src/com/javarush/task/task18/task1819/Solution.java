package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {



        BufferedReader reader = new BufferedReader(
                                    new InputStreamReader(System.in));

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        InputStream in = new FileInputStream(fileName1);
        int[] buffer0 = new int[in.available()];
        while (in.available()>0) {
            for(int i=0; i<buffer0.length;i++)
            buffer0[i]=in.read();
        }

        in.close();


        in = new FileInputStream(fileName2);
        OutputStream out = new FileOutputStream(fileName1);

        byte[] buffer = new byte[in.available()];
        while (in.available()>0) {
            int count = in.read(buffer);
            out.write(buffer, 0 , count);
        }

        for(int i=0; i<buffer0.length;i++)
        out.write(buffer0[i]);



        in.close();
        out.close();
    }
}
