package dev.struchkov.filmorate.data.repository;

import dev.strichkov.filmorate.domain.Person;
import dev.strichkov.filmorate.domain.page.Pagination;
import dev.strichkov.filmorate.domain.page.Sheet;
import dev.struchkov.filmorate.context.repository.PersonRepository;
import dev.struchkov.filmorate.data.jpa.PersonJpaRepository;
import dev.struchkov.filmorate.data.mapper.PersonEntityMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PersonRepositoryImpl implements PersonRepository {

    private final PersonJpaRepository jpaRepository;
    private final PersonEntityMapper personMapper;

    @Override
    public Person save(@NonNull Person person) {
        return personMapper.toDomain(
                jpaRepository.save(
                        personMapper.toEntity(person)
                )
        );
    }

    @Override
    public Optional<Person> findById(@NonNull Long personId) {
        return jpaRepository.findById(personId)
                .map(personMapper::toDomain);
    }

    @Override
    public void deleteById(@NonNull Long personId) {
        jpaRepository.deleteById(personId);
    }

    @Override
    public Sheet<Person> findByAll(@NonNull Pagination pagination) {
        final PageRequest pageable = PageRequest.of(pagination.getPageNumber(), pagination.getPageSize());
        final Page<Person> page = jpaRepository.findAll(pageable)
                .map(personMapper::toDomain);
        return Sheet.<Person>builder()
                .totalPage(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .pageSize(page.getSize())
                .pageNumber(page.getNumber())
                .content(page.getContent())
                .build();
    }

}
