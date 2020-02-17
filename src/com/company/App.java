package com.company;

import com.company.Objects.Circle;
import com.company.Objects.Dot;
import com.company.Objects.Square;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {
    private int collisionCounter;
    private int totalCollisions = 0;
    private int boardSize;
    private int squareCount;
    private int circleCount;
    private int dotCount;
    private List<Collision> list = new ArrayList<>();
    private List<Circle> circleList = new ArrayList<>();

    void run() {
        new Menu().mainMenu();
    }

    void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    void setSquareCount(int squareCount) {
        this.squareCount = squareCount;
    }

    void setCircleCount(int circleCount) {
        this.circleCount = circleCount;
    }

    void setDotCount(int dotCount) {
        this.dotCount = dotCount;
    }

    void collisionCheck() {
        System.out.println("Du har valt: Spelplan " + boardSize + "x" + boardSize + " " + squareCount + " Kvadrater, " + circleCount + " Cirklar och " + dotCount + " Punkter.");
        collisionCounter = 0;
        list.clear();
        add();

        for (int i = 0; i < list.size(); i++) {
            //System.out.println("kollar " + list.get(i));
            for (int j = i + 1; j < list.size(); j++) {
                //System.out.println("mot " + list.get(j));
                if (list.get(i).getBounds().intersects(list.get(j).getBounds())) {
                    collisionCounter++;
                    System.out.println("Kollision mellan " + list.get(i) + " och " + list.get(j));
                }
            }
        }
        circleVsCircle();
        totalCollisions += collisionCounter;
        System.out.print("Antal kollisioner denna omgång: " + collisionCounter + "\nTotalt antal Kollisioner: " + totalCollisions + "\n");
    }

    private void circleVsCircle() {
        for (int i = 0; i < circleList.size(); i++) {
            //System.out.println("kollar " + list.get(i));
            for (int j = i + 1; j < circleList.size(); j++) {
                //System.out.println("mot " + list.get(j));
                if (circleList.get(i).isColliding(circleList.get(j))) {
                    collisionCounter++;
                    System.out.println("Kollision mellan " + circleList.get(i) + " och " + circleList.get(j));
                }
            }
            for (Collision collision : list) {
                if (circleList.get(i).isColliding(collision)) {
                    collisionCounter++;
                    System.out.println("Kollision mellan " + circleList.get(i) + " och " + collision);
                }
            }
        }
    }

    private void add(){
        for(int i = 0; i < squareCount; i++) {
            list.add(new Square(numberRandomizer(boardSize), numberRandomizer(boardSize), 10, boardSize));
        }
        for(int i = 0; i < circleCount; i++) {
            circleList.add(new Circle(numberRandomizer(boardSize), numberRandomizer(boardSize), 10));
        }
        for(int i = 0; i < dotCount; i++) {
            list.add(new Dot(numberRandomizer(boardSize), numberRandomizer(boardSize)));
        }
    }

    private float numberRandomizer(int boardSize) {
        Random randomizer = new Random();
        return (float) randomizer.nextInt(boardSize);
    }
}
