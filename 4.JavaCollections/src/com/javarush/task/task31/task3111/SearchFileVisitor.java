package com.javarush.task.task31.task3111;



import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private List<Path> foundFiles = new ArrayList<Path>();
    public List<Path> getFoundFiles() {
        return foundFiles;
    }
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;


    public void setPartOfName(String partOfName) {
        this.partOfName=partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent=partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize=minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize=maxSize;
    }


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean flag = true;
        if(partOfName!=null&&flag) {
            if(file.getFileName().toString().contains(partOfName)) {

            } else flag=false;
        }

        if(partOfContent!=null&&flag) {
            List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);
            for(String line : lines) {
                if(line.contains(partOfContent)) {
                    break;
                } else flag=false;
            }
        }


        if(minSize>0&&flag){
            if(Files.size(file)>=minSize)
                flag=true;
            else flag=false;
        }

        if(maxSize>0&&flag){
            if(Files.size(file)<=maxSize)
                flag=true;
            else flag=false;
        }
        if(flag)
            foundFiles.add(file);


        return FileVisitResult.CONTINUE;
    }








}

/*
Требования:
1. В классе SearchFileVisitor нужно создать поля partOfName, partOfContent, minSize, maxSize и сеттеры для них.
2. В классе SearchFileVisitor нужно создать поле foundFiles и геттер для него. Поле должно быть сразу инициализировано.
3. Если в SearchFileVisitor задан критерий поиска partOfName, метод visitFile должен добавить файл в foundFiles, если в названии содержится строка partOfName.
4. Если в SearchFileVisitor задан критерий поиска partOfContent, метод visitFile должен добавить файл в foundFiles, если в содержимом встречается строка partOfContent.
5. Если в SearchFileVisitor задан критерий поиска maxSize, метод visitFile должен добавить файл в foundFiles, если размер файла меньше maxSize.
6. Если в SearchFileVisitor задан критерий поиска minSize, метод visitFile должен добавить файл в foundFiles, если размер файла больше maxSize.
7. Метод visitFile должен быть реализован так, чтобы учитывать сразу несколько критериев поиска.
 */