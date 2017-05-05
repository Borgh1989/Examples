package com.javarush.task.task18.task1818;

/* 
Два в одном
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileNme0 = reader.readLine();
        String fileNme1 = reader.readLine();
        String fileNme2 = reader.readLine();
        reader.close();
        FileOutputStream out0 = new FileOutputStream(fileNme0);
        FileInputStream in1 = new FileInputStream(fileNme1);
        FileInputStream in2 = new FileInputStream(fileNme2);

        byte[] buffer = new byte[1000];
        while(in1.available()>0) {
            int count = in1.read(buffer);
            out0.write(buffer, 0, count);

        }
        while(in2.available()>0) {
            int count = in2.read(buffer);
            out0.write(buffer, 0, count);

        }
        in1.close();
        in2.close();
        out0.close();
    }
}
