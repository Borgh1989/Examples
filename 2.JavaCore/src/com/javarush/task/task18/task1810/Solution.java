package com.javarush.task.task18.task1810;

/* 
DownloadException
*/
import java.io.*;


public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    while(true) {
        String fileName = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        byte[] b = new byte[1000];

            int count = inputStream.read(b);
            if(count<1000) {
                reader.close();
                inputStream.close();
                throw new DownloadException();
            }


    }



    }

    public static class DownloadException extends Exception {

    }
}
