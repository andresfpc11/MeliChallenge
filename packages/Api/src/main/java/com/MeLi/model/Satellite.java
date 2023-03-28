package com.MeLi.model;

import java.util.ArrayList;

public class Satellite {
    private String name;
    private int distance;
    private ArrayList<String> message;

    public Satellite(){

    }

    public Satellite(String name, int distance, ArrayList<String> message) {
        this.name = name;
        this.distance = distance;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public ArrayList<String> getMessage() {
        return message;
    }

    public void setMessage(ArrayList<String> message) {
        this.message = message;
    }
}
