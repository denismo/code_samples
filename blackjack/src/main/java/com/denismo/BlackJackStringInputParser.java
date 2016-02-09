package com.denismo;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Class responsible for parsing the String input and returns collection of cards.
 */
public class BlackJackStringInputParser {
    /**
     * Parses the input into a list of card. The input should be in the form &ltcard&gt;[,&ltcard&gt;...],
     * where <code>card</code> is defined by {@link com.denismo.Card#fromString(String)}.
     * @param input the input string, must not be null
     * @return the collection of parsed cards
     * @throws UserInputException if the input contains invalid symbols, or does not comply with the pattern above,
     *  or the input is null
     */
    public Collection<Card> parse(String input) {
        if (input == null || "".equals(input)) throw new UserInputException("Empty input");
        String[] parts = input.split(",");
        return Arrays.stream(parts).map(Card::fromString).collect(Collectors.toList());
    }
}
