package com.company.Classes;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.zip.DeflaterInputStream;

public class Card {

    private static final char SPADES = '\u2660';
    private static final char HEARTS = '\u2665';
    private static final char DIAMOND = '\u2666';
    private static final char CLUBS = '\u2663';

    static public char[] suits = {CLUBS, DIAMOND, HEARTS, SPADES};
    static public String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};//

    private char suit;
    private String value;

    public char getSuit() {
        return suit;
    }

    public String getValue() {
        return value;
    }

    public Card(char suit, String value) {
        this.suit = suit;
        this.value = value;

    }
    @Override
    public String toString() {
        return suit + " - " + value +"\n";
    }

    public boolean isHigher(Card card){
        int thisCardValue = Arrays.asList(values).indexOf(value);
        int cardValue = Arrays.asList(values).indexOf(card.value);
        if(thisCardValue < cardValue)
            return false;
        if(thisCardValue > cardValue)
            return true;
        int thisSuit = Arrays.asList(suits).indexOf(suit);
        int cardSuit = Arrays.asList(suits).indexOf(card.suit);
        return (thisSuit>cardSuit);

    }
}




