package ua.edu.ukma.e_oss.dao;

import org.springframework.data.repository.CrudRepository;
import ua.edu.ukma.e_oss.model.Answer;
import ua.edu.ukma.e_oss.model.SCMember;
import ua.edu.ukma.e_oss.model.Ticket;
import ua.edu.ukma.e_oss.model.User;

import java.util.Optional;

public interface AnswerRepository extends CrudRepository<Answer, Integer> {
    @Override
    <S extends Answer> S save(S s);

    @Override
    <S extends Answer> Iterable<S> saveAll(Iterable<S> iterable);

    @Override
    Optional<Answer> findById(Integer integer);

    @Override
    boolean existsById(Integer integer);

    @Override
    Iterable<Answer> findAll();

    @Override
    Iterable<Answer> findAllById(Iterable<Integer> iterable);

    @Override
    long count();

    @Override
    void deleteById(Integer integer);

    @Override
    void delete(Answer answer);

    @Override
    void deleteAll(Iterable<? extends Answer> iterable);

    @Override
    default void deleteAll() {
        throw new UnsupportedOperationException();
    }

    Iterable<Answer> findAllByUser (User user);

    Iterable<Answer> findAllByTicket (Ticket ticket);

    Iterable<Answer> findAllByScId (SCMember scMember);
}
