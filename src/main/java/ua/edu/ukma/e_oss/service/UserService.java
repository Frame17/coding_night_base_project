package ua.edu.ukma.e_oss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.ukma.e_oss.dao.UserRepository;
import ua.edu.ukma.e_oss.model.User;

import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    User save(User user){
        return userRepository.save(user);
    }


    Iterable<User> saveAll(Iterable<User> users){
        return userRepository.saveAll(users);
    }

    Optional<User> findById(Integer id){
        return userRepository.findById(id);
    }

    boolean existsById(Integer id){
        return userRepository.existsById(id);
    }

    Iterable<User> findAll(){
        return userRepository.findAll();
    }

    Iterable<User> findAllById(Iterable<Integer> users){
        return userRepository.findAllById(users);
    }

    long count(){
        return userRepository.count();
    }

    void deleteById(Integer id){
        userRepository.deleteById(id);
    }

    void delete(User scMember){
        userRepository.delete(scMember);
    }

    void deleteAll(Iterable<? extends User> users){
        userRepository.deleteAll(users);
    }

    void deleteAll(){
        userRepository.deleteAll();
    }
}
