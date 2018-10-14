package ua.edu.ukma.e_oss.dao;

import org.springframework.data.repository.CrudRepository;
import ua.edu.ukma.e_oss.model.SCMember;
import ua.edu.ukma.e_oss.model.User;

import java.util.Optional;

public interface SCMemberRepository extends CrudRepository<SCMember, Integer> {
    @Override
    <S extends SCMember> S save(S s);

    @Override
    <S extends SCMember> Iterable<S> saveAll(Iterable<S> iterable);

    @Override
    Optional<SCMember> findById(Integer integer);

    @Override
    boolean existsById(Integer integer);

    @Override
    Iterable<SCMember> findAll();

    @Override
    Iterable<SCMember> findAllById(Iterable<Integer> iterable);

    @Override
    long count();

    @Override
    void deleteById(Integer integer);

    @Override
    void delete(SCMember scMember);

    @Override
    void deleteAll(Iterable<? extends SCMember> iterable);

    @Override
    default void deleteAll() {
        throw new UnsupportedOperationException();
    }

    Optional<SCMember> findByUser(User user);
}
