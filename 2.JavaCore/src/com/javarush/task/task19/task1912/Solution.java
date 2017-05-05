package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
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
        line = line.replaceAll("te", "??");
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
