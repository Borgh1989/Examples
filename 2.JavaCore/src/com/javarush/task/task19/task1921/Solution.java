package com.javarush.task.task19.task1921;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.*;


/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {

        String fileName = args[0];

        BufferedReader reader  = new BufferedReader(new FileReader(fileName));






        while(reader.ready()) {
            String line = reader.readLine();
            String[] words = line.split(" ");

            String year  = words[words.length-1];
            String month = words[words.length-2];
            String day   = words[words.length-3];
            StringBuilder birthDay = new StringBuilder();
            birthDay = birthDay.append(day).append(" ").append(month).append(" ").append(year);


            SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");



            StringBuilder builder = new StringBuilder();
            for(int i=0; i<words.length-3; i++) {
                builder = builder.append(words[i]);
                builder = builder.append(" ");
            }
            String name = builder.toString();
            name = name.substring(0, name.length()-1);
            PEOPLE.add(new Person(name, format.parse(birthDay.toString())));




        }
        reader.close();

    }
}
