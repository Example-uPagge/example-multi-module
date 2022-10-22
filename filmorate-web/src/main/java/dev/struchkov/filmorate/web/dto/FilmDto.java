package dev.struchkov.filmorate.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Schema(description = "Фильм")
public class FilmDto {

    @Schema(name = "Идентификатор")
    private Long id;

    @Schema(name = "Название")
    private String name;

    @Schema(name = "Описание")
    private String description;

    @Schema(name = "Дата релиза")
    private LocalDate dateRelease;

    @Schema(name = "Продолжительность")
    private Integer durationInMinutes;

    @Schema(name = "Дата Создания")
    private LocalDateTime dateCreated;

    @Schema(name = "Дата обновления")
    private LocalDateTime dateUpdated;

    @Schema(name = "Владелец фильма")
    private Long ownerId;

}
