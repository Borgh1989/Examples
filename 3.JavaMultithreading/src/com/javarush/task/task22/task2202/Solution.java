package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java.")); //JavaRush - лучший сервис обучения Java.
    }

    public static String getPartOfString(String string) {
        if(string==null) throw new TooShortStringException();

        int y = 0;
        int x = 0;
        x = string.indexOf(' ')+1;
        if (x==0) throw new TooShortStringException();
        int count=0;
        char[] array = string.toCharArray();
        for(int i=0; i<array.length; i++) {
            if(array[i]==' ') {
                count++;
            }
        }
        if (count<4) throw new TooShortStringException();
        count=0;
        for(int i=0; i<array.length; i++) {
            if(count==5) {
                y = i-2;
                break;
            } else if(i==array.length-1&&array[i]!=' ') {
                y=i;
                break;
            } else if(i==array.length-1&&array[i]==' ') {
                y = i - 1;
                break;
            }
            if(array[i]==' ') {
                count++;
            }
        }






        String word = string.substring(x,y+1);

        return word;
    }

    public static class TooShortStringException extends RuntimeException {
    }

    /*
    Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
        JavaRush[8]-[10]лучший[17]сервис[24]обучения[]Java.

     */
}
