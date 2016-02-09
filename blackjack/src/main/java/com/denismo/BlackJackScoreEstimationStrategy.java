package com.denismo;

import com.google.common.collect.ImmutableMap;

import java.util.Collection;
import java.util.Map;

/**
 * Class responsible for performing estimates of a hand (collection of cards).
 */
public class BlackJackScoreEstimationStrategy {
    private static Map<String, Integer> CARD_VALUES =
            ImmutableMap.<String, Integer>builder()
                    .put("2", 2)
                    .put("3", 3)
                    .put("4", 4)
                    .put("5", 5)
                    .put("6", 6)
                    .put("7", 7)
                    .put("8", 8)
                    .put("9", 9)
                    .put("10", 10)
                    .put("A", 11)
                    .put("Q", 10)
                    .put("K", 10)
                    .put("J", 10)
                    .build();

    /**
     * Returns a score for a hand.
     * @param cards the list of cards in the hand
     * @return the score, positive integer
     */
    public int getScore(Collection<Card> cards) {
        if (cards == null) throw new IllegalArgumentException("Cards should not be null");
        if (cards.size() != 2) throw new UserInputException("Input should consist of two cards, separated by comma");
        return cards.stream().mapToInt(this::scoreForCard).sum();
    }

    /**
     * Returns blackjack score for a single card.
     * @param card the card to be estimated
     * @return card score, positive integer
     */
    public int scoreForCard(Card card) {
        if (card == null) throw new IllegalArgumentException("com.denismo.Card should not be null");

        if (!CARD_VALUES.containsKey(card.getValue())) throw new IllegalArgumentException("Invalid card value: " + card);
        return CARD_VALUES.get(card.getValue());
    }
}
