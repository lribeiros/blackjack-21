package com.github.lribeiros.domain.game;

import com.github.lribeiros.domain.deck.Card;
import com.github.lribeiros.domain.deck.Deck;

public class Game {
    private final Deck deck;
    private final Player player;
    private final Dealer dealer;

    public Game(String playerName) {
        deck = new Deck();
        player = new Player(playerName);
        dealer = new Dealer("Dealer");
    }

    public void start() {
        deck.shuffle();

        player.addToHand(deck.giveCards(2));
        dealer.addToHand(deck.giveCards(2));

        System.out.println("Partida iniciada");
        displayInitialHands();
    }

    private void displayInitialHands() {
        System.out.printf("Mão do Jogador %s:", player.getName());
        player.getHand().forEach(System.out::println);

        System.out.println("Mão do Dealer:");
        Card firstCardOfDealer = dealer.getHand().get(0);
        System.out.println(firstCardOfDealer);
        System.out.println("Carta oculta");
    }

    public Player getPlayer() {
        return player;
    }

    public Dealer getDealer() {
        return dealer;
    }
}

