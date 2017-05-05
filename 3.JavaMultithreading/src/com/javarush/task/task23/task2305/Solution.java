package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public static class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] solutionArray = new Solution[2];
        solutionArray[0] = new Solution();
        solutionArray[0].innerClasses[0] = new InnerClass();
        solutionArray[0].innerClasses[1] = new InnerClass();
        solutionArray[1] = new Solution();
        solutionArray[1].innerClasses[0] = new InnerClass();
        solutionArray[1].innerClasses[1] = new InnerClass();
        return solutionArray ;
    }

    public static void main(String[] args) {

    }
}
/*
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
 */