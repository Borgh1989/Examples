package com.javarush.task.task14.task1419;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        //1
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        //2
        try {
            throw new IOException();
        }
        catch (IOException e) {
            exceptions.add(e);
        }
        //3
        try {
            throw new IllegalAccessException();
        }
        catch (IllegalAccessException e) {
            exceptions.add(e);
        }
        //4
        try {
            throw new NoSuchFieldException();
        }
        catch (NoSuchFieldException e) {
            exceptions.add(e);
        }
        //5
        try {
            throw new ClassNotFoundException();
        }
        catch (ClassNotFoundException e) {
            exceptions.add(e);
        }
        //6
        try {
            throw new NoSuchMethodException();
        }
        catch (NoSuchMethodException e) {
            exceptions.add(e);
        }
        //7
        try {
            throw new ReflectiveOperationException();
        }
        catch (ReflectiveOperationException e) {
            exceptions.add(e);
        }
        //8
        try {
            throw new FileNotFoundException();
        }
        catch (FileNotFoundException e) {
            exceptions.add(e);
        }
        //9
        try {
            throw new SQLException();
        }
        catch (SQLException e) {
            exceptions.add(e);
        }
        //10
        try {
            throw new EOFException();
        }
        catch (EOFException e) {
            exceptions.add(e);
        }
        //напишите тут ваш код

    }
}
