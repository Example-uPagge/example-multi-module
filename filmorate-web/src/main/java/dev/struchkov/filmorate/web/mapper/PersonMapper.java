package dev.struchkov.filmorate.web.mapper;

import dev.strichkov.filmorate.domain.Person;
import dev.struchkov.filmorate.web.dto.PersonDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonDto toDto(Person person);

    Person toDomain(PersonDto personDto);

}
