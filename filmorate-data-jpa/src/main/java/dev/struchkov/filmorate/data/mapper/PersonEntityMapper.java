package dev.struchkov.filmorate.data.mapper;

import dev.strichkov.filmorate.domain.Person;
import dev.struchkov.filmorate.data.entity.PersonEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonEntityMapper {

    PersonEntity toEntity(Person person);

    Person toDomain(PersonEntity entity);

}
