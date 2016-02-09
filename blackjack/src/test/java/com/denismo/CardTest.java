package com.denismo;

import org.junit.Test;

/**
 * Unit test for the com.denismo.Card class.
 */
public class CardTest {

    @Test(expected = UserInputException.class)
    public void testEmpty() {
        Card.fromString("");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testNull() {
        Card.fromString(null);
    }
    @Test
    public void testValid() {
        Card.fromString("AS");
    }

    @Test
    public void testSuit() {
        Card.Suit.fromString("H");
        Card.Suit.fromString("S");
        Card.Suit.fromString("D");
        Card.Suit.fromString("C");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidSuit() {
        Card.Suit.fromString("A");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testNullSuit() {
        Card.Suit.fromString(null);
    }
}