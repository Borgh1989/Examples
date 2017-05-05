package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufreader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = bufreader.readLine();
        String file2 = bufreader.readLine();

        List<Integer> list = new ArrayList<Integer>();

        FileReader reader = new FileReader(file1);
        FileWriter writer = new FileWriter(file2);

        while(reader.ready()) {
            list.add(reader.read());

        }

        for (int i=0; i<list.size(); i++) {
            if(i==1) {

                writer.write(list.get(i));
            } else if(i%2!=0) {

                writer.write(list.get(i));
            }
        }
        bufreader.close();
        reader.close();
        writer.close();

    }
}
