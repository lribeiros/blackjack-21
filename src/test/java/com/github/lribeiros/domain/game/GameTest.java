package com.github.lribeiros.domain.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    @Test
    void givenPlayer_whenNewGame_thenGameBegins() {
        Game game = new Game("player 1");
        game.start();

        assertEquals(2, game.getPlayer().getHand().size());
        assertEquals(2, game.getDealer().getHand().size());

    }

}