package com.freshworks.exceptions;

public class KeyNonExistentException extends RuntimeException{
    public KeyNonExistentException() {
        super();
    }

    public KeyNonExistentException(String message) {
        super(message);
    }

    public KeyNonExistentException(String message, Throwable cause) {
        super(message, cause);
    }

    public KeyNonExistentException(Throwable cause) {
        super(cause);
    }

    protected KeyNonExistentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
