package com.ivo.rakar;

public class Main {

    public static void main(String[] args) {
        Player player = new Player(new Person("Ivo", "Rakar"), 100);
        Dealer dealer = new Dealer(new Person("SomeName", "Surname"));
	    Game game = new Game(player, dealer);
	    game.start();
    }
}
