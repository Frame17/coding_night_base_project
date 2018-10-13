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

    public User save (User user){
        User savedUser = userRepository.save(user);
        return savedUser;
    }


    Iterable<User> saveAll(Iterable<User> users){
        Iterable savedIterable = userRepository.saveAll(users);
        return savedIterable;
    }

    Optional<User> findByYd(Integer id){
        Optional<User> foundMember = userRepository.findById(id);
        //TODO validation
        return foundMember;
    }

    boolean existsById(Integer id){
        boolean exists=userRepository.existsById(id);
        return exists;
    }

    Iterable<User> findAll(){
        Iterable<User> all = userRepository.findAll();
        return all;
    }

    Iterable<User> findAllById(Iterable<Integer> users){
        Iterable<User> allById = userRepository.findAllById(users);
        return allById;
    }

    long count(){
        long count = userRepository.count();
        return count;
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
