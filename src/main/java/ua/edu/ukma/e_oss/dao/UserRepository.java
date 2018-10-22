package ua.edu.ukma.e_oss.dao;

import org.springframework.data.repository.CrudRepository;
import ua.edu.ukma.e_oss.model.User;

import java.util.Optional;


public interface UserRepository extends CrudRepository<User, Integer> {
    @Override
    <S extends User> S save(S s);

    @Override
    <S extends User> Iterable<S> saveAll(Iterable<S> iterable);

    @Override
    Optional<User> findById(Integer integer);

    @Override
    Iterable<User> findAll();

    @Override
    boolean existsById(Integer integer);

    @Override
    Iterable<User> findAllById(Iterable<Integer> iterable);

    Optional<User> findByName(String name);

    @Override
    long count();

    @Override
    void deleteById(Integer integer);

    @Override
    void delete(User user);

    @Override
    void deleteAll(Iterable<? extends User> iterable);

    @Override
    default void deleteAll() {
        throw new UnsupportedOperationException();
    }
}
