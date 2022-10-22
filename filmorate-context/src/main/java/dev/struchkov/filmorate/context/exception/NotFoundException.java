package dev.struchkov.filmorate.context.exception;

import java.util.function.Supplier;

public class NotFoundException extends FilmorateException{

    public NotFoundException(String message, Object... args) {
        super(message, args);
    }

    public static Supplier<NotFoundException> notFoundException(String message, Object... args) {
        return () -> new NotFoundException(message, args);
    }

}
