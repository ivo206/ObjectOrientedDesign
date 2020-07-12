package com.ivo.rakar;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private Person person;
    private double balance;
    private double initialBet;

    private List<Hand> hands;

    public Player(Person person, double balance) {
        this.person = person;
        this.balance = balance;
        initialBet = 0;
        hands = new ArrayList<>();
    }

    public Person getPerson() {
        return person;
    }

    public double getBalance() {
        return balance;
    }

    public List<Hand> getHands() { return hands; }

    public boolean canContinue() {
        for (Hand hand : hands) {
            if(hand.canStillBet()) return true;
        }
        return false;
    }

    public void addHand(Hand hand) {
        balance -= initialBet;
        hand.makeBet(initialBet);
        hands.add(hand);
    }

    public boolean isSplitAllowed() {
        if(hands.size() >= 2 || balance < initialBet) return false;
        List<BlackJackCard> cards = hands.get(0).getCards();
        return cards.size() > 1 && cards.get(0).getGameValue() == cards.get(1).getGameValue();
    }

    public void split(List<BlackJackCard> cards) {
        Hand hand = hands.get(0);
        List<BlackJackCard> handCards = hand.getCards();
        addHand(new Hand(handCards.get(0), cards.get(0)));
        addHand(new Hand(handCards.get(1), cards.get(1)));
        removeHand(hand);
    }

    private void removeHand(Hand hand) {
        balance += initialBet;
        hands.remove(hand);
    }

    public void makeInitialBet(double bet) {
        initialBet = bet;
    }

    public void doubleDown(Hand hand, BlackJackCard card) {
        balance -= initialBet;
        hand.addCard(card);
        hand.doubleDown(initialBet);
    }

    public boolean canDoubleDown() {
        return balance > initialBet;
    }

    public void addToBalance(double amount) {
        balance += amount;
    }

    public void newGame() {
        hands = new ArrayList<>();
        initialBet = 0;
    }

}
