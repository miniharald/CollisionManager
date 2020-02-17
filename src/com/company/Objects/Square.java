package com.company.Objects;

import com.company.Collision;

import java.awt.*;

public class Square extends Shape implements Collision {

    private int width;
    private int height;
    private float endX;
    private float endY;

    public Square(float x, float y, int size, int boardSize) {
        super(x, y);
        width = size;
        height = size;
        endX = x + width;
        endY = y + height;
        if(endX > boardSize) {
            endX = x - 10;
        } else if(endY > boardSize) {
            endY = y - 10;
        }
    }


    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, width, height);
    }

    @Override
    public String toString() {
        return "Kvadrat{" +
                "Storlek = " + width +
                ", Start X = " + x +
                ", Start Y = " + y +
                ", Slut X = " + endX +
                ", Slut Y = " + endY +
                '}';
    }
}
