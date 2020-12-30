package com.freshworks.exceptions;

public class LimitsExceededException extends RuntimeException{
    public LimitsExceededException() {
    }

    public LimitsExceededException(String message) {
        super(message);
    }

    public LimitsExceededException(String message, Throwable cause) {
        super(message, cause);
    }

    public LimitsExceededException(Throwable cause) {
        super(cause);
    }

    public LimitsExceededException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
