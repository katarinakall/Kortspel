package com.company.Classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {
    static private List<Card> deck;

    public static List<Card> getDeck() {
        return deck;
    }

    public DeckOfCards() {
        deck = initalizeDeckOfCards();
    }

    public List<Card> initalizeDeckOfCards() {
        List<Card> deckOfCards = new ArrayList<>();
        for (int i = 0; i < Card.suits.length; i++) {
            for (int j = 0; j < Card.values.length; j++) {
                deckOfCards.add(new Card(Card.suits[i], Card.values[j]));
            }
        }
        return deckOfCards;
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Card getCardFromDeck(List<Card> deck) {
        if (!deck.isEmpty())
            return deck.remove(0);
        else
            return null;
    }

    public List<Card> addCardToTheDeck() {
        deck.add(getCardFromDeck(deck));
        return deck;
    }
}