package com.MeLi.model;

public class Position {
    private double x;
    private double y;

    public Position(double positionX, double positionY) {
        this.x = positionX;
        this.y = positionY;
    }
    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
