package dev.struchkov.filmorate.context.repository;

import dev.strichkov.filmorate.domain.Person;
import dev.strichkov.filmorate.domain.page.Pagination;
import dev.strichkov.filmorate.domain.page.Sheet;
import lombok.NonNull;

import java.util.Optional;

public interface PersonRepository {

    Person save(@NonNull Person person);

    Optional<Person> findById(@NonNull Long personId);

    void deleteById(@NonNull Long personId);

    Sheet<Person> findByAll(@NonNull Pagination pagination);

}
