package ua.edu.ukma.e_oss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.ukma.e_oss.dao.AnswerRepository;
import ua.edu.ukma.e_oss.model.Answer;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    Answer save(Answer answer){
        Answer savedAnswer = answerRepository.save(answer);
        return savedAnswer;
    }
}
