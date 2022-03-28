package com.felixwu.deck;

import java.util.Objects;

/**
 * Class representing a playing card in a deck.
 *
 * Standard 52 card deck with suit, face, and value attributes.
 *
 * https://en.wikipedia.org/wiki/Standard_52-card_deck
 *
 */

public class Card implements Comparable<Card>{
    private int value;
    private Suit suit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return value == card.value && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, suit);
    }

    public Card(int value, Suit suit){
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public void setValue(int value) {
        this.value = value;
    }


    public String toString(){
        String card = "";
        card += String.valueOf(this.value) + " of " + this.getSuit();
        return card;

    }

    //compares two cards. Numbers take precedence, suit is secondary (Intentional)
    @Override
    public int compareTo(Card otherCard) {
        if(otherCard != null){
            if(this.getValue() > ((Card) otherCard).getValue()){
                return 1;
            }else if(this.getValue() == ((Card) otherCard).getValue()) {
                return Integer.compare(((Card) otherCard).getSuit().ordinal(), this.getSuit().ordinal());
            }else{
                return -1;
            }
        }else{
            return Integer.MAX_VALUE;
        }
    }

}
