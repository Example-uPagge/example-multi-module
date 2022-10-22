package dev.struchkov.filmorate.data.repository;

import dev.strichkov.filmorate.domain.Person;
import dev.strichkov.filmorate.domain.page.Pagination;
import dev.strichkov.filmorate.domain.page.Sheet;
import dev.struchkov.filmorate.context.repository.PersonRepository;
import lombok.NonNull;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class PersonLocalRepository implements PersonRepository {

    private final Map<Long, Person> storage = new HashMap<>();
    private long gen = 0;

    @Override
    public Person save(@NonNull Person person) {
        person.setId(gen++);
        storage.put(person.getId(), person);
        return person;
    }

    @Override
    public Optional<Person> findById(@NonNull Long personId) {
        return Optional.ofNullable(storage.get(personId));
    }

    @Override
    public void deleteById(@NonNull Long personId) {
        storage.remove(personId);
    }

    @Override
    public Sheet<Person> findByAll(@NonNull Pagination pagination) {
        throw new UnsupportedOperationException("Не работает");
    }

}
