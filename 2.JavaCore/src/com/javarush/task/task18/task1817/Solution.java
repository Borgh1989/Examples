package com.javarush.task.task18.task1817;

/* 
Пробелы
*/
import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException{

//        через FileInputStream надо
        InputStream inputStream = new FileInputStream (new File(args[0]));

        int count = 0;
        int space=0;
        while(inputStream.available()>0) {
            int data = inputStream.read();
            count++;
            if (data==32)
                space++;
        }
        inputStream.close();



        double result = (double)space/count*100;
        System.out.println(String.format("%.2f", result));


    }
}
