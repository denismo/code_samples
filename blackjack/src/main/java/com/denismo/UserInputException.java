package com.denismo;

/**
 * Special exception indicating user input error as opposed to the unexpected program condition.
 * User exception will have a human-friendly error message which can be displayed to a User (if makes sense).
 */
public class UserInputException extends RuntimeException {
    public UserInputException(String message) {
        super(message);
    }
}
