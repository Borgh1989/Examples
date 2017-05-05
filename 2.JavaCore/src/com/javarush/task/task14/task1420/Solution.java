package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        int A;
        int B;


            A = Integer.parseInt(reader.readLine());
            if (A <= 0) throw new NumberFormatException();
            B = Integer.parseInt(reader.readLine());
            if (B <= 0) throw new NumberFormatException();
            int NOD=NOD(A, B);
            System.out.println(NOD);








    }

    public static int NOD (int a, int b)
    {
        if (b==0)
            return a;
        else
            return NOD (b, a%b);
    }
}
