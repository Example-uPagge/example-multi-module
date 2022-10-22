package dev.struchkov.filmorate.context.exception;

import java.text.MessageFormat;

public abstract class FilmorateException extends RuntimeException {

    protected FilmorateException(String message) {
        super(message);
    }

    protected FilmorateException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }

}
