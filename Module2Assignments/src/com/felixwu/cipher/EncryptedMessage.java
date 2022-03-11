package com.felixwu.cipher;

public class EncryptedMessage {
    private int key;
    private String message;

    public EncryptedMessage(int key, String message){
        this.key = key;
        this.message = message;
    }
}
