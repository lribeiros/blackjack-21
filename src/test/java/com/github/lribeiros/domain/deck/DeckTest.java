package com.github.lribeiros.domain.deck;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DeckTest {

    private Deck deck;

    @BeforeEach
    void setUp() {
        deck = new Deck();
    }


    @Test
    void givenDeck_whenStarting_thenReturnCards() {
        List<Card> cardsFromDeck = deck.cards();
        assertEquals(52, cardsFromDeck.size());

        System.out.printf(cardsFromDeck.toString());
    }

    @Test
    void givenDeck_whenStarted_thenShuffleCards() {
        List<Card> originalOrderCards = new ArrayList<>(deck.cards());

        deck.shuffle();
        List<Card> shuffledCards = deck.cards();

        assertNotEquals(originalOrderCards, shuffledCards);

        System.out.println(originalOrderCards);
        System.out.println(shuffledCards);
    }
}