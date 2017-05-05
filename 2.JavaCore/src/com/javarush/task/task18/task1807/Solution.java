package com.javarush.task.task18.task1807;

/* 
Подсчет запятых &#044
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filName = reader.readLine();
        reader.close();
        int count=0;
        InputStream in = new FileInputStream(filName);
        while(in.available()>0) {
            int b = in.read();
            if(b==44) {
                count++;
            }
        }
        in.close();
        System.out.println(count);

    }
}
