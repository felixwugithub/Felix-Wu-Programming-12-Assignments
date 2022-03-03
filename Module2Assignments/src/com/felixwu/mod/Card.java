package com.felixwu.mod;

import java.util.Objects;

public class Card {
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

    public int compareValue(Object otherCard){
        if(otherCard instanceof Card){
            if(this.getValue() > ((Card) otherCard).getValue()){
                return 1;
            }else if(this.getValue() == ((Card) otherCard).getValue()) {
                if(this.getSuit().ordinal() < ((Card) otherCard).getSuit().ordinal()){
                    return 1;
                }else if(this.getSuit().ordinal() == ((Card) otherCard).getSuit().ordinal()){
                    return 0;
                }else{
                    return -1;
                }
            }else{
                return -1;
            }
        }else{
            return 99999;
        }
    }


    public String toString(){
        String card = "";
        card += String.valueOf(this.value) + " of " + this.getSuit();
        return card;

    }

    public int compareSuit(Object otherCard){
        if(otherCard instanceof Card){
            if(this.getSuit().ordinal() < ((Card) otherCard).getSuit().ordinal()){
                return 1;
            }else if(this.getSuit().ordinal() == ((Card) otherCard).getSuit().ordinal()) {

                if (this.getValue() > ((Card) otherCard).getValue()) {
                    return 1;
                } else if (this.getValue() == ((Card) otherCard).getValue()) {
                    return 0;
                } else {
                    return -1;
                }
            }else{
                return -1;
            }
        }else{
            return 99999;
        }
    }



}
