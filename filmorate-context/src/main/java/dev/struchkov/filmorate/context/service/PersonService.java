package dev.struchkov.filmorate.context.service;

import dev.strichkov.filmorate.domain.Person;
import dev.strichkov.filmorate.domain.page.Pagination;
import dev.strichkov.filmorate.domain.page.Sheet;
import lombok.NonNull;

import java.util.Optional;

public interface PersonService {

    Person create(@NonNull Person person);

    Person update(@NonNull Person person);

    void deleteById(@NonNull Long personId);

    Optional<Person> getById(@NonNull Long personId);

    Person getByIdOrThrow(@NonNull Long personId);

    Sheet<Person> getAll(@NonNull Pagination pagination);

}
