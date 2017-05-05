package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.*;
import java.util.regex.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {

        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);
        testString.printSomething();

        String result = outputStream.toString();
        System.setOut(consoleStream);
        int a=0;
        int b=0;
        int c=0;







            String[] array = result.split(" ");
            a=Integer.parseInt(array[0]);
            b=Integer.parseInt(array[2]);
            String line = "";
            for (int i=0; i<array.length-1;i++)
                line+=array[i]+" ";
            if(array[1].equals("+")) {
                c=a+b;

            } else if(array[1].equals("-")) {
                c=a-b;

            } else if(array[1].equals("*")) {
                c=a*b;

            }
            line += String.valueOf(c);
            System.out.println(line);






        stream.close();


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

/*
Возможные операции: + — *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов — нет.
 */

