package com.ivo.rakar;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
    private Person person;
    private Hand hand;
    private Deck deck;

    public Dealer(Person personName) {
        person = personName;
        hand = new Hand();
        deck = new Deck();
        deck.shuffle();
    }

    public void getNewDeck() {
        deck = new Deck();
        deck.shuffle();
    }

    public Person getPerson() {
        return person;
    }

    public BlackJackCard showHandCard() {
        return hand.getCards().get(0);
    }

    public void createHand() {
        hand = new Hand();
        for (int i = 0; i < 2; i++) {
            hand.addCard(deck.getCard());
        }
    }

    private void addCardToHand() {
        hand.addCard(deck.getCard());
    }

    public List<BlackJackCard> dealCards(int number) {
        List<BlackJackCard> cards = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            cards.add(deck.getCard());
        }
        return cards;
    }

    public int getScore() {
        while(hand.getScore() < 17) {
            addCardToHand();
        }
        return hand.getScore();
    }

    public Hand getHand() { return hand; }

    public BlackJackCard dealCard() { return deck.getCard(); }
}
