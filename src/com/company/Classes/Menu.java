package com.company.Classes;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    GameLogic gameLogic = new GameLogic();

    public Menu() {
    }

    public void printMenu() {
        System.out.println("Meny: För att använda menyn skriv in önskat nummer och tryck därefter på enter\n" +
                "Spela 1\nSpelregler 2\nStatistik 3\nAvsluta 4");
    }

    public void useMenu() {
        printMenu();
        String input = sc.next();
        switch (input) {
            case "1":
                gameLogic.play();
                gameLogic.saveScore();
                break;

            case "2":
                System.out.println("Två dolda kort tas ut från kortleken: " +
                        "\ndet ena kortet ges till dig och det andra kortet läggs ut öppet så att du kan se det. " +
                        "\nNu ska du gissa om ditt dolda kort är högre eller lägre än det öppna kortet. " +
                        "\nOm du gissar rätt/fel har du vunnit/förloratoch partiet är över.");
                break;
            case "3":
               gameLogic.loadScore();
               break;
            case "4":
                Main.setKeepPlaying(false);
                System.out.println("Hej då!" );
                System.exit(0);
            default:
                System.out.println("Välj ett nummer mellan 1-4");

        }

    }
}


