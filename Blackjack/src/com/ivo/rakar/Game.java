package com.ivo.rakar;

import java.util.List;
import java.util.Scanner;

public class Game {
    private Player player;
    private Dealer dealer;

    public Game(Player player, Dealer dealer) {
        this.player = player;
        this.dealer = dealer;
    }

    public void start() {
        player.makeInitialBet(getBet());
        createHands();
        if(player.isSplitAllowed() && offerSplit()) split();
        while(player.canContinue()) {
            for(Hand hand : player.getHands()) {
                if(!hand.canStillBet()) continue;
                String action = getNextAction(hand);
                playAction(action, hand);
            }
        }
        for (Hand hand : player.getHands()) { stand(hand); }
        System.out.println("Your balance is: "+player.getBalance());
        System.out.println("Press Y if you want to play another game");
        if(getUserInput().equals("Y")) restart();
    }

    private void restart() {
        dealer.getNewDeck();
        player.newGame();
        start();
    }

    private void createHands() {
        dealer.createHand();
        List<BlackJackCard> cards = dealer.dealCards(2);
        player.addHand(new Hand(cards));
    }

    private void playAction(String action, Hand hand) {
        switch (action) {
            case "hit": {
                hit(hand);
                break;
            }
            case "double": {
                doubleDown(hand);
                break;
            }
            case "stand": {
                hand.stand();
                break;
            }
            default: System.out.println("Wrong action"); break;
        }
    }

    public void doubleDown(Hand hand) {
        if(!player.canDoubleDown()) {
            System.out.println("I am sorry. You don't have enough money to double down. ");
            return;
        }
        BlackJackCard card = dealer.dealCard();
        player.doubleDown(hand, card);
    }

    private void stand(Hand hand) {
        int playersScore = hand.getScore();
        int dealersScore = dealer.getScore();

        if(playersScore > 21) {
            playerLoses(hand);
            return;
        }
        if(playersScore == 21 && dealersScore == 21) {
            draw(hand);
            return;
        }
        if(playersScore == 21) {
            playerWinsBlackjack(hand);
            return;
        }
        if(dealersScore > 21 || playersScore > dealersScore) {
            playerWins(hand);
            return;
        }
        playerLoses(hand);
    }

    private void playerWins(Hand hand) {
        showPlayersCards(hand);
        showDealersCards();
        player.addToBalance(hand.getBet() + hand.getBet());
        System.out.println("Congratulations!!! You won!");
    }

    private void playerLoses(Hand hand) {
        showPlayersCards(hand);
        showDealersCards();
        System.out.println("I am sorry this is a losing hand.");
    }

    private void playerWinsBlackjack(Hand hand) {
        showPlayersCards(hand);
        showDealersCards();
        player.addToBalance(hand.getBet() + (hand.getBet() * 1.5));
        System.out.println("Congratulations!!! You have a blackjack!");
    }

    private void draw(Hand hand) {
        player.addToBalance(hand.getBet());
        showPlayersCards(hand);
        showDealersCards();
        System.out.println("Your have the same score as the dealer. You'll get your bat back");
    }

    private void split() {
        player.split(dealer.dealCards(2));
    }

    private void hit(Hand hand) {
        BlackJackCard card = dealer.dealCard();
        hand.addCard(card);
    }

    private void showPlayersCards(Hand hand) {
        System.out.println("This are your cards: ");
        showCards(hand);
    }

    private void showDealersCards() {
        System.out.println("This are dealers cards: ");
        showCards(dealer.getHand());
    }

    private void showCards(Hand hand) {
        System.out.println("Hand: ");
        for (BlackJackCard card : hand.getCards()) {
            System.out.print(card.getGameValue() + " ");
        }
        System.out.println();
    }

    private void showDealersCard() {
        System.out.println("This is dealer's card: ");
        System.out.print(dealer.showHandCard().getGameValue());
        System.out.println();
    }

    private boolean offerSplit() {
        showPlayersCards(player.getHands().get(0));
        showDealersCard();
        System.out.println("Type Y if you want to split, if not press any other button.");
        return getUserInput().equals("Y");
    }

    private String getNextAction(Hand hand) {
        showCards(hand);
        showDealersCard();
        System.out.println("Select one of the following actions by typing the words: double, hit or stand");
        return getUserInput();
    }

    private double getBet() {
        System.out.println("Place your bet:");
        String input = getUserInput();
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("You entered an invalid number. Try again!");
            return getBet();
        }
    }

    private String getUserInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
