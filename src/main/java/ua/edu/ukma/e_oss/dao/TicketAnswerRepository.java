package ua.edu.ukma.e_oss.dao;

import org.springframework.data.repository.CrudRepository;
import ua.edu.ukma.e_oss.model.Answer;

public interface TicketAnswerRepository extends CrudRepository<Answer, Integer> {
}
