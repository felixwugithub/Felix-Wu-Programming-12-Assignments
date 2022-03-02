package com.felixwu.mod;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Card> deck = new ArrayList<Card>(52);

        for (int i = 1; i <=13 ; i++){

            if(i > 1 || i < 11){
                    deck.add(new Card(i, Suit.SPADES));
                    deck.add(new Card(i, Suit.HEARTS));
                    deck.add(new Card(i, Suit.CLUBS));
                    deck.add(new Card(i, Suit.DIAMONDS));
            }else if( i == 1){
                deck.add(new FaceCard(i, Suit.SPADES, Face.ACE));
                deck.add(new FaceCard(i, Suit.HEARTS, Face.ACE));
                deck.add(new FaceCard(i, Suit.CLUBS, Face.ACE));
                deck.add(new FaceCard(i, Suit.DIAMONDS, Face.ACE));
            }else if(i == 11){
                deck.add(new FaceCard(i, Suit.SPADES, Face.JACK));
                deck.add(new FaceCard(i, Suit.HEARTS, Face.JACK));
                deck.add(new FaceCard(i, Suit.CLUBS, Face.JACK));
                deck.add(new FaceCard(i, Suit.DIAMONDS, Face.JACK));
            }else if(i == 12){
                deck.add(new FaceCard(i, Suit.SPADES, Face.QUEEN));
                deck.add(new FaceCard(i, Suit.HEARTS, Face.QUEEN));
                deck.add(new FaceCard(i, Suit.CLUBS, Face.QUEEN));
                deck.add(new FaceCard(i, Suit.DIAMONDS, Face.QUEEN));
            }else if(i == 13){
                deck.add(new FaceCard(i, Suit.SPADES, Face.KING));
                deck.add(new FaceCard(i, Suit.HEARTS, Face.KING));
                deck.add(new FaceCard(i, Suit.CLUBS, Face.KING));
                deck.add(new FaceCard(i, Suit.DIAMONDS, Face.KING));
            }
        }

        for (Card c: deck
             ) {
            System.out.println(c);

        }


    }
}

