package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        Thread thr_1 = new Thread_1();
        threads.add(0, thr_1);
        Thread thr_2 = new Thread_2();
        threads.add(1, thr_2);
        Thread thr_3 = new Thread_3();
        threads.add(2, thr_3);
        Thread thr_4 = new Thread_4();
        threads.add(3, thr_4);
        Thread thr_5 = new Thread_5();
        threads.add(4, thr_5);
    }

    public static void main(String[] args) {


            threads.get(4).start();
    }
}

class Thread_1 extends Thread {
    @Override
    public void run() {
        while(true);
    }
}

class Thread_2 extends Thread {
    @Override
    public void run() {

        try {
            throw new InterruptedException();
        } catch(InterruptedException e) {
            System.out.println("InterruptedException");
        }

    }
}

class Thread_3 extends Thread {
    @Override
    public void run() {
        while(true) {
            System.out.println("Ура");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Thread_4 extends Thread implements Message {
    @Override
    public void run() {
        super.run();
    }
    @Override
    public void showWarning() {
        if(this.isAlive()) {
            this.interrupt();
        }
    }
}

class Thread_5 extends Thread {
    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum=0;
        try {

            while(true) {
                String number = reader.readLine();
                if(number.equals("N")) {
                    System.out.println(sum);
                    break;
                } else {
                    sum += Integer.parseInt(number);
                }
            }


            } catch(IOException e) {
                e.printStackTrace();
            } finally {
            try {
                reader.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }



    }
}