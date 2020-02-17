package com.company.Objects;

import com.company.Collision;

import java.awt.*;

public class Dot extends Shape implements Collision {

    private final int WIDTH = 1;
    private final int HEIGHT = 1;

    public Dot(float x, float y) {
        super(x, y);
    }


    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, WIDTH, HEIGHT);
    }

    @Override
    public String toString() {
        return "Punkt{" +
                "X = " + x +
                ", Y = " + y +
                '}';
    }
}
