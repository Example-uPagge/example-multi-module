package dev.struchkov.filmorate.core.service;

import dev.strichkov.filmorate.domain.Person;
import dev.strichkov.filmorate.domain.page.Pagination;
import dev.strichkov.filmorate.domain.page.Sheet;
import dev.struchkov.filmorate.context.Message;
import dev.struchkov.filmorate.context.repository.PersonRepository;
import dev.struchkov.filmorate.context.service.PersonService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static dev.struchkov.filmorate.context.exception.NotFoundException.notFoundException;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    @Override
    @Transactional
    public Person create(@NonNull Person person) {
        return repository.save(person);
    }

    @Override
    @Transactional
    public Person update(@NonNull Person newPerson) {
        final Person oldPerson = repository.findById(newPerson.getId())
                .orElseThrow(notFoundException(Message.NotFound.PERSON, newPerson.getId()));
        oldPerson.setName(newPerson.getName());
        oldPerson.setEmail(newPerson.getEmail());
        oldPerson.setBirthday(newPerson.getBirthday());
        return oldPerson;
    }

    @Override
    @Transactional
    public void deleteById(@NonNull Long personId) {
        repository.deleteById(personId);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Person> getById(@NonNull Long personId) {
        return repository.findById(personId);
    }

    @Override
    @Transactional(readOnly = true)
    public Person getByIdOrThrow(@NonNull Long personId) {
        return repository.findById(personId)
                .orElseThrow(notFoundException(Message.NotFound.PERSON, personId));
    }

    @Override
    @Transactional(readOnly = true)
    public Sheet<Person> getAll(@NonNull Pagination pagination) {
        return repository.findByAll(pagination);
    }
}
