package com.javarush.task.task18.task1823;

import java.util.*;
import java.io.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String fileName = reader.readLine();
            if(fileName.equals("exit")) {

                break;
            }
            ReadThread readThread = new ReadThread(fileName);
            readThread.start();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            this.fileName=fileName;
            //implement constructor body
        }
        private String fileName;

        public void run() {
//            InputStream is = null;
//            BufferedInputStream bis = null;
//            try {
//                is = new FileInputStream(fileName);
//                bis = new BufferedInputStream(is);
//                int[] array = new int[256];
//                if(is.available()>0) {
//                    array[is.read()]++;
//                }
//                int count=0;
//                for(int i = 0; i<array.length; i++) {
//                    if(array[i]>count)
//                        count = array[i];
//                }
//                for(int i = 0; i<array.length; i++) {
//                    if(count==array[i])
//                        synchronized (resultMap) {
//                            resultMap.put(fileName, i);
//                        }
//
//                }
//
//
//
//            } catch(IOException e) {
//                e.printStackTrace();
//            }
//            finally {
//                if(bis!=null)
//                    try{
//                        bis.close();
//                    } catch(IOException e) {
//                        e.printStackTrace();
//                    }
//
//            }
            try {
                FileInputStream file = new FileInputStream(fileName);
                TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
                while (file.available() > 0) {
                    int data = file.read();
                    if (!map.containsKey(data))
                    {
                        map.put(data, 1);
                    } else
                    {
                        map.put(data, map.get(data) + 1);
                    }
                }
                file.close();
                int maxCount = 0;
                int maxMetByte = 0;
                for (Map.Entry<Integer, Integer> pair : map.entrySet())
                {
                    if (maxCount < pair.getValue()){
                        maxCount = pair.getValue();
                        maxMetByte = pair.getKey();
                    }
                }
                synchronized (resultMap)
                {
                    resultMap.put(fileName, maxMetByte);
                }
            } catch (IOException e)
            {
            }
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
