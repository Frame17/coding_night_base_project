package ua.edu.ukma.e_oss.dao;

import org.springframework.data.repository.CrudRepository;
import ua.edu.ukma.e_oss.model.User;


public interface UserRepository extends CrudRepository<User, Integer> {

}
