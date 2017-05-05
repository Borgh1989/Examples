package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/
import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException{
        List<Integer> list = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        Scanner scanner = new Scanner(new FileInputStream(fileName));

        while(scanner.hasNextInt()) {
            int data = scanner.nextInt();
            if(data%2==0)
                list.add(data);


        }
        scanner.close();
        Collections.sort(list);
        for(int i : list) {

            System.out.println(i);
        }

        // напишите тут ваш код
    }
}
