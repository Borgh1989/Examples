package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 23.03.2017.
 */
public class Hippodrome {

    //constructor
    public Hippodrome (List<Horse> horses) {
        this.horses=horses;
    }
    //fields
    private List<Horse> horses;
    public static Hippodrome game;

    //getter
    public List<Horse> getHorses() {
        return horses;
    }

    //methods
    public void run() {

        for(int i=0; i<100; i++) {
            this.move();
            this.print();
            try{
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public void print() {
        for(Horse horse : horses) {
            horse.print();
        }
        for(int i=0; i<10; i++) {
            System.out.println();
        }
    }
    public void move() {
        for(Horse horse : horses) {
            horse.move();
        }
    }
    public Horse getWinner() {
        Horse winner=null;
        double maxDistance=0.0d;
        for(int i=0; i<horses.size(); i++) {
            if (horses.get(i).getDistance()>maxDistance)
                maxDistance=horses.get(i).getDistance();
        }
        for(Horse horse : horses) {
            if(horse.getDistance()==maxDistance)
                winner=horse;
        }
        return winner;
    }
    public void printWinner() {
        System.out.println("Winner is "+this.getWinner().getName()+"!");
    }

    //MAIN
    public static void main(String[] args) {
        Horse horse1 = new Horse("Horse_1", 3, 0);
        Horse horse2 = new Horse("Horse_2", 3, 0);
        Horse horse3 = new Horse("Horse_3", 3, 0);


        game = new Hippodrome(new ArrayList<Horse>());
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);
        game.run();
        game.printWinner();
    }

}
