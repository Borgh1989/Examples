package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner=fileScanner;
        }


        @Override
        public Person read() throws IOException {
            String line="";
            while(fileScanner.hasNextLine())
            line = fileScanner.nextLine();
            String[] lines = line.split(" ");
            int day = Integer.parseInt(lines[3]);
            int month = Integer.parseInt(lines[4])-1;
            int year = Integer.parseInt(lines[5]);

            Date date = new Date(day, month, year);
            Person person = new Person(lines[0], lines[1], lines[2], date);

            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
