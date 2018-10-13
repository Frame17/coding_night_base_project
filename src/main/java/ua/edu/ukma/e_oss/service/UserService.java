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

    public User save(User user) {
        return userRepository.save(user);
    }


    public Iterable<User> saveAll(Iterable<User> users) {
        return userRepository.saveAll(users);
    }

    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    public boolean existsById(Integer id) {
        return userRepository.existsById(id);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public Iterable<User> findAllById(Iterable<Integer> users) {
        return userRepository.findAllById(users);
    }

    public long count() {
        return userRepository.count();
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    public void delete(User scMember) {
        userRepository.delete(scMember);
    }

    public void deleteAll(Iterable<? extends User> users) {
        userRepository.deleteAll(users);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }
}
