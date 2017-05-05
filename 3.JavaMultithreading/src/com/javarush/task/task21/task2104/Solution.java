package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {


    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }


    public boolean equals(Object o) {
        if(this==o) return true;
        if(!(o instanceof Solution)) return false;
        Solution sol = (Solution) o;

        return (first!=null ? sol.first.equals(first) : sol.first==null) &&
                (last!=null ? sol.last.equals(last) : sol.last==null);
    }

    public int hashCode() {
        int result = 1;
        result = (first!=null ? result*37 + first.hashCode() : 0);
        result = (last!=null ? result*37 + last.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
