package dev.struchkov.filmorate.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Schema(description = "Пользователь системы")
public class PersonDto {

    @Schema(description = "Идентификатор")
    private Long id;

    @Schema(description = "Имя")
    private String name;

    @Schema(description = "Почта")
    private String email;

    @Schema(description = "Логин")
    private String login;

    @Schema(description = "День рождения")
    private LocalDateTime birthday;

}
