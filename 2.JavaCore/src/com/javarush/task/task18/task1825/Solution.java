package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<String>();
        while(true) {
            String part="";
            if((part = reader.readLine()).equals("end")) break;
            list.add(part);
        }
        reader.close();
        Collections.sort(list);



        String newFile = list.get(0).substring(0, list.get(0).lastIndexOf('.'));


        BufferedOutputStream outputStream = new BufferedOutputStream(
                                                new FileOutputStream(newFile));


        for(String word : list) {
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(word));
            byte[] buffer = new byte[inputStream.available()];
            while(inputStream.available()>0) {
                 int count = inputStream.read(buffer);
                 outputStream.write(buffer, 0, count);
            }
            outputStream.flush();
            inputStream.close();
        }

        outputStream.close();

    }
}
