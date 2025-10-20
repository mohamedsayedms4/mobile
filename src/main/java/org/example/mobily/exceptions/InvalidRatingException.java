package org.example.mobily.exceptions;

public class InvalidRatingException extends RuntimeException {
    public InvalidRatingException(int value) {
        super("Rating '" + value + "' is not supported. Must be between 1 and 5.");
    }
}
