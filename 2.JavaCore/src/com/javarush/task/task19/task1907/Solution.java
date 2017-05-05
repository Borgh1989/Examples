package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        reader.close();
        String line="";
        int count=0;
        Pattern p = Pattern.compile("\\W");

        while(fileReader.ready()) {
//            String lines = fileReader.readLine();
//            line=line.concat(lines);
            String[] arr = fileReader.readLine().split("world");
            count += arr.length - 1;

        }
//        line = line.replaceAll("\\p{Punct}", " ");

//        String[] array1 = line.split("/n");
//        for (String s:array1)
//        {
//            String[] array2 = s.split(" ");
//            for (String s2:array2)
//            {
//                if (s2.equals("world"))
//                    count++;
//            }
//        }

//        Matcher m = p.matcher(line);
//        line=m.replaceAll(" ");
//
//        String words[] = line.split(" ");
//        for(String word : words) {
//            if(word.equals("world"))
//                count++;
//        }
        // заменить знаки препинания на пробелы потом получить по пробелу маасив слов и найти совпадения








        System.out.println(count);


        fileReader.close();
    }
}
