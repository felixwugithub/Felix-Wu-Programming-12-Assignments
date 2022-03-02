package com.felixwu.mod;

public class FaceCard extends Card{
    private Face face;

    public FaceCard(int value, Suit suit, Face face) {
        super(value, suit);
        this.face = face;
    }
    public Face getFace() {
        return face;
    }
}
