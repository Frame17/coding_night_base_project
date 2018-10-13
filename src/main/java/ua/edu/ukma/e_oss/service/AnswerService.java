package ua.edu.ukma.e_oss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.ukma.e_oss.dao.AnswerRepository;
import ua.edu.ukma.e_oss.model.*;
import ua.edu.ukma.e_oss.model.Answer;

import java.util.Optional;


@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    Answer save(Answer answer){
        Answer savedAnswer = answerRepository.save(answer);
        return savedAnswer;
    }

    public Iterable<Answer> saveAll(Iterable<Answer> answers){
        return answerRepository.saveAll(answers);
    }

    public Optional<Answer> findById(Integer id){
        return answerRepository.findById(id);
    }

    public boolean existsById(Integer id){
        return answerRepository.existsById(id);
    }

    public Iterable<Answer> findAll(){
        return answerRepository.findAll();
    }

    public Iterable<Answer> findAllById(Iterable<Integer> answers){
        return answerRepository.findAllById(answers);
    }

    public long count(){
        return answerRepository.count();
    }

    public void deleteById(Integer id){
        answerRepository.deleteById(id);
    }

    public void delete(Answer scAnswer){
        answerRepository.delete(scAnswer);
    }

    public void deleteAll(Iterable<? extends Answer> answers){
        answerRepository.deleteAll(answers);
    }

    public void deleteAll(){
        answerRepository.deleteAll();
    }

    Iterable<Answer> findAllByUser (User user){
        return answerRepository.findAllByUser(user);
    }

    Iterable<Answer> findAllByTicket (Ticket ticket){
        return answerRepository.findAllByTicket(ticket);
    }

    Iterable<Answer> findAllByScId (SCMember scMember){
        return answerRepository.findAllByScId(scMember);
    }
}
