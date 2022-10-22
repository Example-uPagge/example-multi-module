package dev.struchkov.filmorate.context;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class Message {

    @UtilityClass
    public static class NotFound {
        public static final String FILM = "Фильм не найден. Идентификатор: {0}";
        public static final String PERSON = "Пользователь не найден. Идентификатор: {0}";
    }

    @UtilityClass
    public static class Error {

    }

}
