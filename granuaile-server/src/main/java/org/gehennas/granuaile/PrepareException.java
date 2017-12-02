package org.gehennas.granuaile;

public class PrepareException extends Exception {

    private static final String MSG = "Granuaile Server Failed to start: ";

    public PrepareException() {
        super();
    }

    public PrepareException(String message) {
        super(MSG + message);
    }

    public PrepareException(String message, Throwable cause) {
        super(MSG + message, cause);
    }

    public PrepareException(Throwable cause) {
        super(MSG, cause);
    }

    protected PrepareException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(MSG + message, cause, enableSuppression, writableStackTrace);
    }
}
