package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    @Test
    public void testVictoryPlayerNumberOne() {
        Game game = new Game();
        Player player1 = new Player(1, "Игрок 1", 800);
        Player player2 = new Player(2, "Игрок 2", 500);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Игрок 1", "Игрок 2");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testVictoryPlayerNumberTwo() {
        Game game = new Game();
        Player player1 = new Player(1, "Игрок 1", 80);
        Player player2 = new Player(2, "Игрок 2", 500);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Игрок 1", "Игрок 2");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEqualForces() {
        Game game = new Game();
        Player player1 = new Player(1, "Игрок 1", 80);
        Player player2 = new Player(2, "Игрок 2", 80);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Игрок 1", "Игрок 2");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testNoRegisteredPlayerSecond() {
        Game game = new Game();
        Player player1 = new Player(1, "Игрок 1", 80);
        Player player2 = new Player(2, "Astrid", 80);
        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Игрок 1", "Игрок 2");
        });
    }

    @Test
    public void testNoRegisteredPlayerFirst() {
        Game game = new Game();
        Player player1 = new Player(1, "Harald", 80);
        Player player2 = new Player(2, "Игрок 2", 80);

        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Игрок 1", "Игрок 2");
        });
    }

    @Test
    public void testNoRegisteredAllPlayer() {
        Game game = new Game();

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Игрок 1", "Игрок 2");
        });
    }
}