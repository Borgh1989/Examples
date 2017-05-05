package com.javarush.task.task21.task2113;

/**
 * Created by Андрей on 23.03.2017.
 */
public class Horse {

    //constructor
    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    //fields
    private String name;
    private double speed;
    private double distance;

    //geters & setters
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    //methods
    public void move() {
        distance += speed * Math.random();
    }
    public void print() {
        StringBuilder builder = new StringBuilder();
        String point =".";
        for(int i=0; i<(int)distance; i++) {
            builder.append(point);
        }

        System.out.println(builder.append(name).toString());
    }

}
