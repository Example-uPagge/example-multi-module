package dev.struchkov.filmorate.web.controller;

import dev.strichkov.filmorate.domain.Film;
import dev.strichkov.filmorate.domain.page.Pagination;
import dev.strichkov.filmorate.domain.page.Sheet;
import dev.struchkov.filmorate.context.service.FilmService;
import dev.struchkov.filmorate.web.dto.FilmDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/film")
@Tag(name = "Фильмы", description = "Эндпойнты для работы с фильмами")
public class FilmController {

    private final FilmService filmService;
    private final ConversionService conversionService;

    @Operation(summary = "Добавление нового фильма")
    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<FilmDto> create(@RequestBody FilmDto filmDto) {
        return ResponseEntity.ok(
                conversionService.convert(
                        filmService.create(
                                conversionService.convert(filmDto, Film.class)
                        ),
                        FilmDto.class
                )
        );
    }

    @Operation(summary = "Обновление фильма")
    @PutMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<FilmDto> update(@RequestBody FilmDto filmDto) {
        return ResponseEntity.ok(
                conversionService.convert(
                        filmService.update(conversionService.convert(filmDto, Film.class)),
                        FilmDto.class
                )
        );
    }

    @Operation(summary = "Получение фильма по идентификатору")
    @PutMapping(value = "{filmId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<FilmDto> getById(@PathVariable Long filmId) {
        return ResponseEntity.ok(
                conversionService.convert(
                        filmService.getByIdOrThrow(filmId),
                        FilmDto.class
                )
        );
    }

    @Operation(summary = "Получение всех фильмов с пагинацией")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Sheet<FilmDto>> getAllByFilter(
            @Parameter(description = "Номер страницы", required = true) @Min(0) @RequestParam Integer pageNum,
            @Parameter(description = "Количество элементов", required = true) @Min(1) @Max(100) @RequestParam Integer pageSize
    ) {
        return ResponseEntity.ok(
                filmService.getAll(new Pagination(pageSize, pageSize))
                        .map(film -> conversionService.convert(film, FilmDto.class))
        );
    }

}
