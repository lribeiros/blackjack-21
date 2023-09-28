package com.github.lribeiros.domain.deck;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Deck {

    private final List<Card> cards;

    public Deck() {
        cards = Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Rank.values())
                        .map(rank -> new Card(rank, suit)))
                .collect(Collectors.toList());
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public List<Card> cards() {
        return cards;
    }

    public List<Card> giveCards(int numberOfCards) {
        if (numberOfCards <= 0 || numberOfCards > cards.size()) {
            throw new IllegalArgumentException("Quantidade de cartas inválida para distribuir.");
        }

        return IntStream.range(0, numberOfCards)
                .mapToObj(i -> cards.remove(0))
                .collect(Collectors.toList());
    }
}
