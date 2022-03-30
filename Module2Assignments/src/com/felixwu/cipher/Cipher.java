package com.felixwu.cipher;

import java.util.HashMap;
import java.util.Locale;

public class Cipher {

    /*
    Caesar Cipher Class

The Caesar cipher is one of the earliest known and simplest ciphers.
 It is a type of substitution cipher in which each letter in the plaintext
 is 'shifted' a certain number of places down the alphabet.
 For example, with a shift of 1, A would be replaced by B, B would become C,
  and so on. The method is named after Julius Caesar,
 who apparently used it to communicate with his generals.

 plain:  abcdefghijklmnopqrstuvwxyz
cipher: bcdefghijklmnopqrstuvwxyza

     */

    private final static char alphabet[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private int key;
    private HashMap charMap = new HashMap<Character, Integer>();


    //Using Maps create a class that allows someone to instantiate with a number between 1 and 25
    // representing the number of shifts.  Have 2 methods one that
    // encrypts a message from their chosen shift and one that decrypts from chosen shift.

    public Cipher(int key){
        this.key = key;
        charMap.put('A', 0);
        charMap.put('B', 1);
        charMap.put('C', 2);
        charMap.put('D', 3);
        charMap.put('E', 4);
        charMap.put('F', 5);
        charMap.put('G', 6);
        charMap.put('H', 7);
        charMap.put('I', 8);
        charMap.put('J', 9);
        charMap.put('K', 10);
        charMap.put('L', 11);
        charMap.put('M', 12);
        charMap.put('N', 13);
        charMap.put('O', 14);
        charMap.put('P', 15);
        charMap.put('Q', 16);
        charMap.put('R', 17);
        charMap.put('S', 18);
        charMap.put('T', 19);
        charMap.put('U', 20);
        charMap.put('V', 21);
        charMap.put('W', 22);
        charMap.put('X', 23);
        charMap.put('Y', 24);
        charMap.put('Z', 25);
    }



    public String encrypt(String in){
        String encryptedText = "";
        String string = in.toUpperCase();
        for(int i = 0; i < string.length(); i++){
            char letter = string.charAt(i);
            int lookUp = ((int)charMap.get(letter) + key ) % 26;
            encryptedText += alphabet[lookUp];
        }
        return encryptedText;
    }

    public String decrypt(String in){
        String decrypted = "";
        String string = in.toUpperCase();
        for(int i = 0; i < string.length(); i++){
            char letter = string.charAt(i);
            int lookUp = ((int)charMap.get(letter) - key + 266666) % 26;
            decrypted += alphabet[lookUp];
        }
        return decrypted;
    }






}


