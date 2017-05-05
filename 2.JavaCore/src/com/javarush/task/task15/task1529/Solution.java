package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args)  {

    }
    
    static {


        reset();//add your code here - добавьте код тут
    }

    public static Flyable result;

    public static void reset() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String parameter = reader.readLine();
            if(parameter.equals("helicopter")) {
                result=new Helicopter();
            } else if(parameter.equals("plane")) {
                int pass = Integer.parseInt(reader.readLine());
                result = new Plane(pass);
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        //add your code here - добавьте код тут
    }
}
