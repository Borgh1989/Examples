package com.javarush.task.task31.task3102;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.io.File;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {

        File dir = new File(root);
        if(!dir.exists()) return null;
        List<String> fileTree = new ArrayList<String>();


        File[] arrayOfFiles = dir.listFiles();
        if(arrayOfFiles==null) return null;


        List<File> list = Arrays.asList(arrayOfFiles);
        ArrayList<File> listOfDir = new ArrayList<File>(list);

        while(!listOfDir.isEmpty()) {



            for(int i=0; i<listOfDir.size(); i++) {
                if(listOfDir.get(i).isFile()) {
                    fileTree.add(listOfDir.get(i).getAbsolutePath());
                    listOfDir.remove(listOfDir.get(i));
                    i--;
                }   else if(listOfDir.get(i).isDirectory()) {
                         arrayOfFiles = listOfDir.get(i).listFiles();
                         if (arrayOfFiles!=null) {
                             listOfDir.remove(listOfDir.get(i));
                             listOfDir.addAll(new ArrayList<File>(Arrays.asList(arrayOfFiles)));

                             i=-1;

                         } else{
                             listOfDir.remove(listOfDir.get(i));
                             i--;
                           }


                    }
            }

        }




        return fileTree;

    }

    public static void main(String[] args) throws IOException {
        String path = "c:\\Мои файлы\\Тестовая папка";
        List<String> list = getFileTree(path);
        for(String string : list) {
            System.out.println(string);
        }
    }
}
