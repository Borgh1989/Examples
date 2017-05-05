package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        InputStream inputStream = new FileInputStream(reader.readLine());

        while(inputStream.available()>0){

            System.out.print((char)inputStream.read());

        }
        System.out.println();
        reader.close();
        inputStream.close();


//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        Scanner scanner = new Scanner(new FileInputStream(reader.readLine()));
//        while (scanner.hasNextLine()) {
//            String data = scanner.nextLine();
//            System.out.print(data);
//        }
//        scanner.close();
//        reader.close();


        // напишите тут ваш код
    }
}