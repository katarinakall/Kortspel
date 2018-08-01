package com.company.Classes;

import java.io.*;
import java.util.Scanner;

public class GameLogic {
    Scanner sc = new Scanner(System.in);
    private DeckOfCards cardDeck;
    private int numberOfBananas;
    private int numberOfGamesPlayed;

    public int getNumberOfBananas() {
        return numberOfBananas;
    }

    public int getNumberOfGamesPlayed() {
        return numberOfGamesPlayed;
    }

    public GameLogic() {
        cardDeck = new DeckOfCards();
    }

    public void gameSetUp() {
        cardDeck.shuffle();
    }

    public void play() {
        gameSetUp();
        Card firstCard = cardDeck.getCardFromDeck(DeckOfCards.getDeck());
        System.out.println(firstCard);
        System.out.println("Kommer nästa kort vara högre (h) eller lägre (l)?");
        Card nextCard = cardDeck.getCardFromDeck(DeckOfCards.getDeck());
        String guess = sc.next();
        System.out.println(nextCard);
        if (guess.equalsIgnoreCase("l")) {

            if (firstCard.isHigher(nextCard)) {
                System.out.println("Du vann! Som belöning får du en banan " + '\uD83C' + '\uDF4C');
                numberOfBananas++;
                numberOfGamesPlayed++;
            } else {
                System.out.println("Du förlorade. Du får ingen banan.");
                numberOfGamesPlayed++;
            }

        }
        if (guess.equalsIgnoreCase("h")) {
            if (nextCard.isHigher(firstCard)) {
                System.out.println("Du vann! Som belöning får du en banan " + '\uD83C' + '\uDF4C');
                numberOfBananas++;
                numberOfGamesPlayed++;
            } else {
                System.out.println("Du förlorade. Du får ingen banan.");
                numberOfGamesPlayed++;
            }

        }
        System.out.println("Vill du spela igen? (J/N) ");
        String responce = sc.next();
        if (responce.equalsIgnoreCase("j")) {
            play();
        }
    }

    public void saveScore(){
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter("Statistik.txt", true)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.println(numberOfBananas + " " + numberOfGamesPlayed);
        out.close();
    }

    public void loadScore() {

        try {
            Scanner fileReader = new Scanner(new File("Statistik.txt"));
            while (fileReader.hasNextInt())
                System.out.println("Antalet vunna bananer är: " + fileReader.nextInt() + " Antaler spelade spel är: " + fileReader.nextInt());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}


