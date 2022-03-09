package com.felixwu.deck;

import java.util.Objects;

/**
 * Face card subclass
 *
 * has a Enum representing its face.
 */

public class FaceCard extends Card{
    private Face face;

    public FaceCard(int value, Suit suit, Face face) {
        super(value, suit);
        this.face = face;
    }

    @Override
    public String toString() {
        return (face + " of " + String.valueOf(super.getSuit()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FaceCard faceCard = (FaceCard) o;
        return face == faceCard.face;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), face);
    }

    public Face getFace() {
        return face;
    }
}
