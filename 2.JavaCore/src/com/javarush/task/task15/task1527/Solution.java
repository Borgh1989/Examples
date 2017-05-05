package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

/*
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        List<String> list = new ArrayList<String>();
        String object="";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String[] array = url.split("\\?");
        if(array[1].contains("&")) {
            String[] newArray = array[1].split("\\&");
            list = Arrays.asList(newArray);
        } else list.add(array[1]);

        for(int i=0; i<list.size(); i++) {
            if(list.get(i).contains("=")) {
                String[] p = list.get(i).split("=");
                if(p[0].equals("obj")) {
                    object=p[1];
                }
                System.out.print(p[0]);
            } else
                System.out.print(list.get(i));

            if(i<list.size()-1)System.out.print(" ");
        }
        if(!object.equals("")) {
            System.out.println();
            try {
                double d = Double.parseDouble(object);
                alert(d);
            } catch(Exception e) {
                alert(object);
            }
        }

        //add your code here
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
