package com.ivo.rakar;

public class Card {

    private SUIT suit;
    private int faceValue;

    public SUIT getSuit() {
        return suit;
    }

    public void setSuit(SUIT suit) {
        this.suit = suit;
    }

    public int getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(int faceValue) {
        this.faceValue = faceValue;
    }

    public Card(SUIT suit, int faceValue) {
        this.suit = suit;
        this.faceValue = faceValue;
    }
}
