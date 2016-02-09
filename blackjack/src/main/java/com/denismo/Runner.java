package com.denismo;

import java.util.Collection;

/**
 * The example runner.
 * Runs in 2 modes:
 * 1. Command line: provide card input as a single String argument with two cards comma-separated
 * 2. No arguments: enter the cards after a prompt
 */
public class Runner {
    public static void main(String[] args) {
        BlackJackScoreEstimationStrategy estimator = new BlackJackScoreEstimationStrategy();
        BlackJackStringInputParser parser = new BlackJackStringInputParser();

        String input;
        if (args.length < 1) {
            System.out.println("Enter 2 cards, separated by comma, or run the application with 2 cards separated by comma.");
            System.out.println("Card consists of 2 characters. The first represents the\n" +
                    "face value from 2-10, plus A, K, Q, J. The second represents the\n" +
                    "suit S, C, D, H.");
            input = System.console().readLine("Cards:");
        } else {
            input = args[0];
        }

        try {
            Collection<Card> cards = parser.parse(input);
            System.out.println("Score: " + estimator.getScore(cards));
        } catch (UserInputException ue) {
            System.out.println(ue.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
