package com.denismo;

import lombok.Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Object holding information about a card.
 */
@Data
public class Card {
    /**
     * The suit of the card.
     */
    public enum Suit {
        Spades("S"),
        Hearts("H"),
        Diamonds("D"),
        Clubs("C");
        private final String code;
        Suit(String code) {
            this.code = code;
        }

        /**
         * Converts a single letter code of the suit (S,D,G,H) into the corresponding Suit enum.
         * @param code the suit code
         * @return the matching Suit enum
         * @throws IllegalArgumentException if no matching suit is found for the code or the code is null
         */
        public static Suit fromString(String code) {
            if (code != null) {
                for (Suit suit : Suit.values()) {
                    if (code.equalsIgnoreCase(suit.code)) {
                        return suit;
                    }
                }
            }
            throw new IllegalArgumentException("Could not find matching Suit enum for " + code);
        }
    }

    private static Pattern CARD_PAT = Pattern.compile("([2-9AQJK]|10)([SCDH])");

    private final Suit suit;
    private final String value;

    Card(String value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    /**
     * Parse the input string for the card into the Card object.
     * @param input the input string in the format ([2-9AQJK]|10)[SCDH].
     * @return the corresponding card
     * @throws UserInputException if the input contains invalid characters
     * @throws IllegalArgumentException if the input is null
     */
    public static Card fromString(String input) {
        if (input == null) throw new IllegalArgumentException("Input cannot be null");
        input = input.trim().toUpperCase();
        Matcher matcher = CARD_PAT.matcher(input);
        if (!matcher.matches()) throw new UserInputException("Input should consist of card value 2-10, or A,K,Q,J, followed by suit S,D,C,H");

        Suit suit = Suit.fromString(matcher.group(2));
        return new Card(matcher.group(1), suit);
    }
}
