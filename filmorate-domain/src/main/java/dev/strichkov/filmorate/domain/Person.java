package dev.strichkov.filmorate.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Person {

    private Long id;

    private String name;

    private String email;

    private String login;

    private LocalDateTime birthday;

}
