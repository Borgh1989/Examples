package com.javarush.task.task18.task1803;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

        FileInputStream inputStream = new FileInputStream(reader.readLine());
        ArrayList<Integer> bytes = new ArrayList<Integer>();
        Map<Integer, Integer> repeatBytes = new HashMap<Integer, Integer>();

        while (inputStream.available()>0) {
            int data = inputStream.read();
            bytes.add(data);
        }
        inputStream.close();

        for(int i=0; i<bytes.size(); i++) {
            int count = bytes.get(i);
            int repeat = 1;
            bytes.remove(i);
            i--;
            for(int j=0; j<bytes.size(); j++) {
                if (count==bytes.get(j)) {
                    bytes.remove(j);
                    repeat++;
                    j--;
                }

            }
            repeatBytes.put(count, repeat);
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = repeatBytes.entrySet().iterator();
        bytes.clear();
        int max=0;

        while(iterator.hasNext()) {

            Map.Entry<Integer, Integer> pair = iterator.next();
            int value = pair.getValue();
            if(value>max) {
                max=value;
                int key = pair.getKey();
                bytes.clear();
                bytes.add(key);
            } else if(value==max) {
                int key = pair.getKey();
                bytes.add(key);
            }


        }
        for(int b : bytes) {
            System.out.print(b+" ");
        }

    }
}
