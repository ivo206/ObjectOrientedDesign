package com.ivo.rakar;

public class BlackJackCard extends Card {

    private int gameValue;

    public BlackJackCard(SUIT suit, int faceValue) {
        super(suit, faceValue);
        gameValue = Math.min(faceValue, 10);
    }

    public int getGameValue() {
        return gameValue;
    }

}
