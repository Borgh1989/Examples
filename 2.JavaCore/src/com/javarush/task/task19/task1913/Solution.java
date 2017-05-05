package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);
        testString.printSomething();
        String line = outputStream.toString();

        line = line.replaceAll("[^0-9]", "");

        System.setOut(consoleStream);
        System.out.println(line);
        stream.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
