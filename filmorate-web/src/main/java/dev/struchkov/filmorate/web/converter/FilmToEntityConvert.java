package dev.struchkov.filmorate.web.converter;

import dev.strichkov.filmorate.domain.Film;
import dev.struchkov.filmorate.web.dto.FilmDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FilmToEntityConvert implements Converter<FilmDto, Film> {

    @Override
    public Film convert(FilmDto source) {
        final Film film = new Film();
        film.setId(source.getId());
        film.setName(source.getName());
        film.setDescription(source.getDescription());
        film.setDateRelease(source.getDateRelease());
        film.setDurationInMinutes(source.getDurationInMinutes());
        return film;
    }

}
