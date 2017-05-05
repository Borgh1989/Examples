package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader reader = new BufferedReader(
                                    new InputStreamReader(System.in));

        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private static String fullFileName;
        private static String lines = "";
        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName=fullFileName;
        }

        @Override
        public String getFileContent() {
            return lines;
        }

        public synchronized void run() {
            BufferedReader in = null;
            try {
                in = new BufferedReader (new FileReader(fullFileName));
                String line;
                while ((line = in.readLine()) != null) {

                    lines += line+" ";

                }
                in.close();

            } catch (IOException e) {
                e.printStackTrace();

            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }


    }//add your code here - добавьте код тут

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);

        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();//add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
}
