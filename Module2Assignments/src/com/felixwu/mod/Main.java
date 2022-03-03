package com.felixwu.mod;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


//Cards will be sorted in the order: 2, 3, ... , 10, Jack, Queen, King, Ace based on the card game "Fight the Landlord"
//sorted from weakest card to superior, so from low values to high, and also by suit, so from diamonds to spades

public class Main {
    public static void main(String[] args) {

        List<Card> deck = new ArrayList<Card>(52);

        for (int i = 2; i <= 14; i++) {

            if (i < 11) {
                deck.add(new Card(i, Suit.SPADES));
                deck.add(new Card(i, Suit.HEARTS));
                deck.add(new Card(i, Suit.CLUBS));
                deck.add(new Card(i, Suit.DIAMONDS));
            } else if (i == 11) {
                deck.add(new FaceCard(i, Suit.SPADES, Face.JACK));
                deck.add(new FaceCard(i, Suit.HEARTS, Face.JACK));
                deck.add(new FaceCard(i, Suit.CLUBS, Face.JACK));
                deck.add(new FaceCard(i, Suit.DIAMONDS, Face.JACK));
            } else if (i == 12) {
                deck.add(new FaceCard(i, Suit.SPADES, Face.QUEEN));
                deck.add(new FaceCard(i, Suit.HEARTS, Face.QUEEN));
                deck.add(new FaceCard(i, Suit.CLUBS, Face.QUEEN));
                deck.add(new FaceCard(i, Suit.DIAMONDS, Face.QUEEN));
            } else if (i == 13) {
                deck.add(new FaceCard(i, Suit.SPADES, Face.KING));
                deck.add(new FaceCard(i, Suit.HEARTS, Face.KING));
                deck.add(new FaceCard(i, Suit.CLUBS, Face.KING));
                deck.add(new FaceCard(i, Suit.DIAMONDS, Face.KING));
            } else if(i == 14){
                deck.add(new FaceCard(i, Suit.SPADES, Face.ACE));
                deck.add(new FaceCard(i, Suit.HEARTS, Face.ACE));
                deck.add(new FaceCard(i, Suit.CLUBS, Face.ACE));
                deck.add(new FaceCard(i, Suit.DIAMONDS, Face.ACE));
            }
        }

        shuffleDeck(deck);
        sortDeck(deck);
        printDeck(deck);

        System.out.println("HANDING OUT CARDS!!!!!" +
                "\n ----------------------");
        List<Card> hand = buildHand(deck, 15);
        printDeck(hand);

        System.out.println("----------------- \n remaining cards:" +
                "\n -------------------------");
        printDeck(deck);



    }

    public static void sortDeck(List<Card> deck) {
        Collections.sort(deck);
        System.out.println("deck has been completely sorted. " +
                "" +
                "Cards sorted in the order: 2, 3, ... , 10, Jack, Queen, King, Ace based on the card game \"Fight the Landlord\"." +
                " Each number is additionally sorted in the order diamonds, clubs, hearts, spades (weakest to superior) ");
    }
    public static void printDeck(List<Card> deck){for (Card c: deck) {System.out.println(c);}}

    public static void shuffleDeck(List<Card> deck){
        Collections.shuffle(deck);
        System.out.println("Deck shuffled!");
    }
    public static List<Card> buildHand(List<Card> deck, int size){
        List hand = new ArrayList();
        for (int i = 0; i < size; i++) {
            hand.add(deck.get(i));
        }
        for (int i = 0; i < size; i++) {
            deck.remove(hand.get(i));
        }
        
        return hand;
    }
}

