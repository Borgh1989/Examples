package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    String name;
    int i;
    public static void main(String[] args) {

    }

    public Solution()
    {

    }

    private Solution(String name)
    {
        this.name=name;
    }

    Solution(int i)
    {
        this.i=i;
    }

    protected Solution(String name, int i)
    {
        this.name=name;
        this.i=i;
    }
}

