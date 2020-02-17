package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    boolean isValidInput = false;
    App app = new App();
    Scanner scan = new Scanner(System.in);
    boolean isRunning =true;

    protected void mainMenu() {
        while (isRunning) {
            System.out.println("1) Starta simulatorn\n2) Avsluta");
            int input = scan.nextInt();
            try {
                switch (input) {
                    case 1:
                        boardMenu();
                        break;
                    case 2:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Du valde inget av följande val, testa igen!");
                        mainMenu();
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Du skrev inte in en siffra, testa igen!");
                mainMenu();
            }
        }
    }

    protected void boardMenu() {
        System.out.println("Hur stor spelplan vill du ha?");
        int input = scan.nextInt();
        app.setBoardSize(input);
        System.out.println("Hur många kvadrater?");
        input = scan.nextInt();
        app.setSquareCount(input);
        System.out.println("Hur många cirklar?");
        input = scan.nextInt();
        app.setCircleCount(input);
        System.out.println("Hur många punkter?");
        input = scan.nextInt();
        app.setDotCount(input);
        app.collisionCheck();
    }
}
