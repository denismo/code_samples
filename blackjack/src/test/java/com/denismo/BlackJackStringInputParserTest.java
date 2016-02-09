package com.denismo;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

/**
 * Test for BlackJackStringInputParser.
 */
public class BlackJackStringInputParserTest {

    private final BlackJackStringInputParser parser = new BlackJackStringInputParser();


    @Test
    public void testParse1() {
        assertThat(parser.parse("AS"), equalTo(Collections.singletonList(Card.fromString("AS"))));
    }
    @Test(expected = UserInputException.class)
    public void testParseNull() {
        parser.parse(null);
    }
    @Test(expected = UserInputException.class)
    public void testParseEmpty() {
        parser.parse("");
    }
    @Test
    public void testParse2() {
        assertThat(parser.parse("AS,2D"), equalTo(Arrays.asList(Card.fromString("AS"), Card.fromString("2D"))));
    }
    @Test
    public void testParse2WithSpace() {
        assertThat(parser.parse("AS, 2D"), equalTo(Arrays.asList(Card.fromString("AS"), Card.fromString("2D"))));
    }
}