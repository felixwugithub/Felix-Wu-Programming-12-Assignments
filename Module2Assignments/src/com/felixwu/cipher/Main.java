package com.felixwu.cipher;

public class Main {
    public static void main(String[] args) {
        Cipher ciph = new Cipher(3);
        String hiddenMsg = ciph.encrypt("abcdefxyz");
        System.out.println(hiddenMsg);
        System.out.println("decrypting msg: ");
        System.out.println(ciph.decrypt(hiddenMsg));
    }
}
