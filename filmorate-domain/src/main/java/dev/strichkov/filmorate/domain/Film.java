package dev.strichkov.filmorate.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class Film {

    private Long id;

    private String name;

    private String description;

    private LocalDate dateRelease;

    private Integer durationInMinutes;

    private LocalDateTime dateCreated;

    private LocalDateTime dateUpdated;

    private Long ownerId;

}
