package dev.struchkov.filmorate.data.mapper;

import dev.strichkov.filmorate.domain.Film;
import dev.struchkov.filmorate.data.entity.FilmEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FilmEntityMapper {

    FilmEntity toEntity(Film film);

    Film toDomain(FilmEntity film);

}
