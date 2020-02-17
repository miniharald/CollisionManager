package com.company.Objects;

import com.company.Collision;

import java.awt.*;

public class Circle extends Shape implements Collision {
    private float radius;
    private float diameter;

    public Circle(float x, float y, float radius) {
        super(x, y);
        this.radius = radius;
        this.diameter = radius * 2;
    }

    private float getRadius() {
        return radius;
    }

    public boolean isColliding(Circle circle) {
        return Math.pow(getX() - circle.getX(), 2) + Math.pow(getY() - circle.getY(), 2)
                <= Math.pow(radius + circle.radius, 2);
    }

    public boolean isColliding(Collision shape) {
        Rectangle rectangle = shape.getBounds();
        float closestX = getClosest(getX(), (float)rectangle.getX(), (float)rectangle.getX() + (float)rectangle.getWidth());
        float closestY = getClosest(getY(), (float)rectangle.getY() - (float)rectangle.getHeight(), (float)rectangle.getY());

        float distanceX = getX() - closestX;
        float distanceY = getY() - closestY;

        return Math.pow(distanceX, 2) + Math.pow(distanceY, 2) < Math.pow(getRadius(), 2);
    }

    private static float getClosest(float value, float min, float max) {
        float closest = value;
        if (closest < min) {
            closest = min;
        } else if (closest > max) {
            closest = max;
        }
        return closest;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)(this.x - this.radius), (int)(this.y + this.radius), (int)this.diameter,
                (int)this.diameter);
    }

    @Override
    public String toString() {
        return "Cirkel{" +
                "Radius = " + radius +
                ", Diameter = " + diameter +
                ", X = " + x +
                ", Y = " + y +
                '}';
    }
}
