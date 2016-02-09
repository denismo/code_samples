package com.denismo;

import org.junit.Test;

import java.util.Collections;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

/**
 * Unit test for BlackJackScoreEstimationStrategy.
 */
public class BlackJackScoreEstimationStrategyTest {

    private final BlackJackScoreEstimationStrategy estimator = new BlackJackScoreEstimationStrategy();
    private final BlackJackStringInputParser parser = new BlackJackStringInputParser();

    @Test
    public void testGetScore() {
        assertThat(estimator.getScore(parser.parse("AS, 2S")), equalTo(13));
    }

    @Test
    public void testScoreForCard() {
        assertThat(estimator.scoreForCard(Card.fromString("AS")), equalTo(11));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetScoreNull() {
        estimator.getScore(null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testscoreForCardNull() {
        estimator.getScore(null);
    }
    @Test(expected = UserInputException.class)
    @SuppressWarnings("unchecked")
    public void testGetScoreEmpty() {
        estimator.getScore(Collections.EMPTY_LIST);
    }
}