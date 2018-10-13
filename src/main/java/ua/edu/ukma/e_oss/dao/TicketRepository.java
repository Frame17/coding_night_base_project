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
    void deleteAll();

    List<Ticket> findAllBySolver(SCMember solver);

    List<Ticket> findAllByCreator(User creator);

    List<Ticket> findAllByTitleContains(String title);

    List<Ticket> findAllByStatus(byte status);

    @Modifying
    @Query("update Ticket t set t.sc_id =?1 where t.id=?2")
    SCMember updateSCidFor(SCMember scMember, int ticketID);
    //TODO check

    @Modifying
    @Query("update Ticket t set t.status =?1 where t.id=?2")
    byte updateStatus(byte status, int ticketID);
    //TODO check

}
