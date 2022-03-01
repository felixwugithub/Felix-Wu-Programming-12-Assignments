package com.felixwu.deckofcards;

public class FaceCard extends Card {
    Face face;

    public FaceCard(int value, Suit suit, Face face){
        super(value, suit);
        this.face = face;
    }
}
