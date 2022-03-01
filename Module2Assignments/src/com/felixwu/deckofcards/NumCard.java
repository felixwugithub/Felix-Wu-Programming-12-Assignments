package com.felixwu.deckofcards;

public class NumCard extends Card {
    int number;

    public NumCard(int value, Suit suit, int number){
        super(value, suit);
        this.number = number;
    }
}
