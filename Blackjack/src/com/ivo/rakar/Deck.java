package com.ivo.rakar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<BlackJackCard> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        for(int i = 1; i<=13; i++) {
            for (SUIT suit : SUIT.values()) {
                cards.add(new BlackJackCard(suit, i));
            }
        }
    }

    public void shuffle() {
        Random r = new Random();
        for (int i = 0; i < cards.size(); i++) {
            int index = r.nextInt(cards.size());
            BlackJackCard temp = cards.get(i);
            cards.set(i, cards.get(index));
            cards.set(index, temp);
        }
    }

    public BlackJackCard getCard() {
        return cards.remove(cards.size()-1);
    }
}
