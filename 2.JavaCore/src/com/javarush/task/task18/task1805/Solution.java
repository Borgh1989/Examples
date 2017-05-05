package com.javarush.task.task18.task1805;

import java.io.FileInputStream;
import java.io.*;
import java.util.*;
/* 
Сортировка байт
*/

public class Solution {
    public static FileInputStream inputStream;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        inputStream = new FileInputStream(reader.readLine());
        List<Integer> list = new ArrayList<Integer>();
        addListBytes(list);
        inputStream.close();

        sorBytes(list);
        printBytes(list);


    }


    private static void sorBytes(List<Integer> list) {
        int count=0;
        for(int i=0; i<list.size()-1; i++){
            for(int j=0; j<list.size()-1-i; j++){
                if (list.get(j+1)<list.get(j)) {
                    count = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, count);
                }
                    else if (list.get(j)==list.get(j+1)) {
                    list.remove(j);
                    j--;
                }


            }
        }
    }

    public static void addListBytes (List<Integer> list) throws IOException {
        while(inputStream.available()>0) {
            list.add(inputStream.read());
        }
    }
    private static void printBytes(List<Integer> list) {
        for(int el : list) {
            System.out.print(el+" ");
        }
    }
}
