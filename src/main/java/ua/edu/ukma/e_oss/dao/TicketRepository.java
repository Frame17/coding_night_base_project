package ua.edu.ukma.e_oss.dao;

import org.springframework.data.repository.CrudRepository;
import ua.edu.ukma.e_oss.model.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {

}
