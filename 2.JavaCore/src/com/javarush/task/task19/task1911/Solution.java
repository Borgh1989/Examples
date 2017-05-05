package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException{
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArray);

        System.setOut(stream);

        testString.printSomething();

        String line = byteArray.toString();
        line = line.toUpperCase();

        System.setOut(consoleStream);
        System.out.println(line);
        stream.close();

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
