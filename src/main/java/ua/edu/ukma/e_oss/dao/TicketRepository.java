package ua.edu.ukma.e_oss.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ua.edu.ukma.e_oss.model.SCMember;
import ua.edu.ukma.e_oss.model.Ticket;
import ua.edu.ukma.e_oss.model.User;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {
    @Override
    <S extends Ticket> S save(S s);

    @Override
    <S extends Ticket> Iterable<S> saveAll(Iterable<S> iterable);

    @Override
    Optional<Ticket> findById(Integer integer);

    @Override
    Iterable<Ticket> findAll();

    @Override
    boolean existsById(Integer integer);

    @Override
    Iterable<Ticket> findAllById(Iterable<Integer> iterable);

    @Override
    long count();

    @Override
    void deleteById(Integer integer);

    @Override
    void delete(Ticket ticket);

    @Override
    void deleteAll(Iterable<? extends Ticket> iterable);

    @Override
    default void deleteAll() {
        throw new UnsupportedOperationException();
    }

    Iterable<Ticket> findAllBySolver(SCMember solver);

    Iterable<Ticket> findAllByCreator(User creator);

    Iterable<Ticket> findAllByTitleContains(String title);

    Iterable<Ticket> findAllByStatus(byte status);
}
