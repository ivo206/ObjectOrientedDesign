package com.ivo.rakar;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<BlackJackCard> cards;
    private double bet;
    private boolean canStillBet;

    public Hand() {
        cards = new ArrayList<>();
        bet = 0;
        canStillBet = true;
    }

    public Hand(BlackJackCard card1, BlackJackCard card2) {
        cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);
        canStillBet = true;
    }

    public Hand(List<BlackJackCard> cards) {
        this.cards = cards;
        canStillBet = true;
    }

    public List<BlackJackCard> getCards() { return cards; }

    public void addCard(BlackJackCard card) {
        this.cards.add(card);
    }

    private List<Integer> getPossibleScores() {
        List<Integer> possibleScores = new ArrayList<>();
        possibleScores.add(0);
        for (BlackJackCard card : cards) {
            List<Integer> newScores = new ArrayList<>();
            possibleScores.forEach(score -> {
                newScores.add(score + card.getGameValue());
                if (card.getGameValue() == 1) newScores.add(score + 11);
            });
            possibleScores = newScores;
        }
        return possibleScores;
    }

    public int getScore() {
        List<Integer> scores = getPossibleScores();
        int maxUnder = Integer.MIN_VALUE;
        int minOver = Integer.MAX_VALUE;

        for (int score : scores) {
            if(score > 21 && score < minOver) {
                minOver = score;
            }
            if(score < 21 && score > maxUnder) {
                maxUnder = score;
            }
        }
        return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
    }

    public void makeBet(double amount) { bet += amount; }

    public double getBet() { return bet; }

    public boolean canStillBet() {
        return getScore() <= 21 && canStillBet;
    }

    public void stand() {
        canStillBet = false;
    }

    public void doubleDown (double amount) {
        bet += amount;
        canStillBet = false;
    }
}
