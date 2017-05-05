package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
;

/* 
Serializable Solution
*/
public class Solution implements Serializable  {
    public static void main(String[] args) throws IOException {
        System.out.println(new Solution(4));
        File file = new File("c:/test/test.txt");
        file.createNewFile();
        FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream outputStream = new FileOutputStream(file);


        Solution savedObject = new Solution(15);

        ObjectOutputStream objectOutput = new ObjectOutputStream(outputStream);
        objectOutput.writeObject(savedObject);

        outputStream.close();
        objectOutput.close();


        Solution loadedObject = new Solution(20);

        ObjectInputStream objectinput = new ObjectInputStream(inputStream);
        try {
            loadedObject = (Solution)objectinput.readObject();
            if(savedObject.string.equals(loadedObject.string))
                System.out.println("yes");
            else System.out.println("no");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            objectinput.close();
            inputStream.close();

        }



    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;


    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
