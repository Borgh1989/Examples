package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;
import java.util.*;


public class Solution {
    public static List<String> list;
    public static BufferedReader reader;
    public static FileInputStream inputStream1;
    public static FileOutputStream outputStream2;
    public static FileOutputStream outputStream3;
    public static void main(String[] args) throws IOException {

        reader = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<String>();
        createFiles(list);
        reader.close();


        inputStream1 = new FileInputStream(list.get(0));
        outputStream2 = new FileOutputStream(list.get(1));
        outputStream3 = new FileOutputStream(list.get(2));
        byte[] byff = new byte[inputStream1.available()];
       if(inputStream1.available()>0) {


           double data = inputStream1.read(byff);
           double count = Math.ceil(data / 2);


           outputStream2.write(byff, 0, (int)count);
           outputStream3.write(byff, (int) count, (int) data/2);

       }

        inputStream1.close();
        outputStream2.close();
        outputStream3.close();




    }

    public static  void createFiles(List<String> list) throws IOException {
        for (int i=0; i<3;i++){
            String name = reader.readLine();
            list.add(name);

        }
    }
}
