package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {

        String fileName1 = readFileName();
        String fileName2 = readFileName();

        readFile(allLines, fileName1);
        readFile(forRemoveLines, fileName2);



        Solution sol = new Solution();
        sol.joinData();




    }
    //чтение имени файла
    private static String readFileName() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        return fileName;

    }
    //чтение данных из файла и запись в нужный список
    private static void readFile(List<String> list, String fileName) throws IOException {
        BufferedReader readFile1 = new BufferedReader(new FileReader(fileName));
        while(readFile1.ready()) {
            String line = readFile1.readLine();
            list.add(line);
        }

        readFile1.close();
    }
    //проверка данных на корректность
    public void joinData () throws CorruptedDataException {

        for(String line : forRemoveLines) {
            if(!allLines.contains(line)) {
                allLines.clear();
                throw new CorruptedDataException();
            }
        }
        allLines.removeAll(forRemoveLines);


    }
}
