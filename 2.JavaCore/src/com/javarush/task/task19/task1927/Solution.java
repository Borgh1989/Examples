package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);


        String reklame = "JavaRush - курсы Java онлайн";


        testString.printSomething();
        String result = outputStream.toString();

        System.setOut(consoleStream);

        int counter = 0;
        for (String s : result.split("\n")) {
            System.out.println(s);
            counter++;
            if (counter % 2 == 0) {
                System.out.println(reklame);
            }
        }
        stream.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
