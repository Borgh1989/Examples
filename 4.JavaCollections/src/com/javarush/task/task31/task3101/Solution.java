package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void method (File[] arrayOfFiles, List<String> list) {
        for (File file : arrayOfFiles) {

            if(file.isFile()) {
                if(file.length()>50) {
                    FileUtils.deleteFile(file);
                } else if(file.length()<=50) {
                    list.add(file.getAbsolutePath());
                }
            } else if(file.isDirectory()) {
                File[] array = file.listFiles();
                method(array, list);
            }


        }
    }
    public static void main(String[] args) throws IOException {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);

        List<String> list = new ArrayList<String>();

        File allFilesContent = new File(resultFileAbsolutePath.getParent()+"/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);

        try(BufferedWriter buffWriter = new BufferedWriter(new FileWriter(allFilesContent));
        ) {
            File[] arrayOfFiles = path.listFiles();
            method(arrayOfFiles, list);

            Collections.sort(list);



            for(String name : list) {


                BufferedReader reader = new BufferedReader(new FileReader(name));

                while (reader.ready()) {
                    String line = reader.readLine();
                    buffWriter.write(line);
                }
                buffWriter.write(System.lineSeparator());
                buffWriter.flush();
                reader.close();

            }
        }



    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }
}
