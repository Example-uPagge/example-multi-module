package dev.struchkov.filmorate.web.converter;

import dev.strichkov.filmorate.domain.Film;
import dev.struchkov.filmorate.web.dto.FilmDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FilmToDtoConvert implements Converter<Film, FilmDto> {

    @Override
    public FilmDto convert(Film source) {
        final FilmDto filmDto = new FilmDto();
        filmDto.setId(source.getId());
        filmDto.setName(source.getName());
        filmDto.setDurationInMinutes(source.getDurationInMinutes());
        filmDto.setDateRelease(source.getDateRelease());
        filmDto.setDescription(source.getDescription());
        return filmDto;
    }

}
