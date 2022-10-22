package dev.struchkov.filmorate.web.controller;

import dev.strichkov.filmorate.domain.page.Pagination;
import dev.strichkov.filmorate.domain.page.Sheet;
import dev.struchkov.filmorate.context.service.PersonService;
import dev.struchkov.filmorate.web.dto.PersonDto;
import dev.struchkov.filmorate.web.mapper.PersonMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("api/person")
@Tag(name = "Пользователи системы", description = "Эндпойнты для работы с пользователями системы")
public class PersonController {

    private final PersonService personService;
    private final PersonMapper personMapper;

    @Operation(summary = "Регистрация нового пользователя")
    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonDto> create(@RequestBody PersonDto personDto) {
        return ResponseEntity.ok(
                personMapper.toDto(
                        personService.create(
                                personMapper.toDomain(personDto)
                        )
                )
        );
    }

    @Operation(summary = "Обновление пользователя")
    @PutMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonDto> update(@RequestBody PersonDto personDto) {
        return ResponseEntity.ok(
                personMapper.toDto(
                        personService.update(
                                personMapper.toDomain(personDto)
                        )
                )
        );
    }

    @Operation(summary = "Получение пользователя по идентификатору")
    @PutMapping(value = "{personId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonDto> getById(@PathVariable Long personId) {
        return ResponseEntity.ok(
                personMapper.toDto(
                        personService.getByIdOrThrow(personId)
                )
        );
    }

    @Operation(summary = "Получение всех пользователей с пагинацией")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Sheet<PersonDto>> getAllByFilter(
            @Parameter(description = "Номер страницы", required = true) @Min(0) @RequestParam Integer pageNum,
            @Parameter(description = "Количество элементов", required = true) @Min(1) @Max(100) @RequestParam Integer pageSize
    ) {
        return ResponseEntity.ok(
                personService.getAll(new Pagination(pageNum, pageSize))
                        .map(personMapper::toDto)
        );
    }

}
