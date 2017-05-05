package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(fileName);
        Properties p = new Properties();
        p.load(inputStream);
        inputStream.close();

        load(inputStream);





        //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception {

        Properties p = new Properties();
        for(Map.Entry<String, String> maps : properties.entrySet()) {
            p.setProperty(maps.getKey(), maps.getValue());
        }
        p.store(outputStream, " ");



        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {

        Properties p = new Properties();
        p.load(inputStream);
        Enumeration e = p.propertyNames();
        while(e.hasMoreElements()) {
            String key = (String)e.nextElement();
            properties.put(key, p.getProperty(key));
        }

        //implement this method - реализуйте этот метод
    }

    public static void main(String[] args) {

    }
}
