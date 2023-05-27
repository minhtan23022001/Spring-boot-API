package com.example.demo.service;

import com.example.demo.entity.question.Question;
import com.example.demo.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.reflect.Array;
import java.util.*;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    public List<Question> saveQuestions(List<Question> question) {
        return questionRepository.saveAll(question);
    }

    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }

    Long randomId;
    public List<Question> setOfQuestion() {
        Random random = new Random();
        ArrayList<Question> soq1 = new ArrayList<Question>();
        ArrayList<Question> soq2 = new ArrayList<Question>();
        Long temp = 1L;
        long size = questionRepository.count();
        int count = (int) size;
        for(int i = 0; i < count; i++) {
            Long l = Long.valueOf(i)+1;
            soq1.add(getQuestionById(l));
        }
        Collections.shuffle(soq1);

        for(int i = 0; i < 15; i++) {
            soq2.add(soq1.get(i));
        }
        for(int i = 0; i < 15; i++) {
            Long l = Long.valueOf(i)+1;
            soq2.get(i).setId(l);
        }
        return soq2;
    }


    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    public String deleteQuestion(Long id) {
        questionRepository.deleteById(id);
        return "Question deleted " + id + "!";
    }

    public Question update(Question question, Long id) {
        Question existingQuestion = questionRepository.findById(id).orElse(question);
        existingQuestion.setNameQuestion(question.getNameQuestion());
        existingQuestion.setAnswerA(question.getAnswerA());
        existingQuestion.setAnswerB(question.getAnswerB());
        existingQuestion.setAnswerC(question.getAnswerC());
        existingQuestion.setAnswerD(question.getAnswerD());
        existingQuestion.setAnswerQuestion(question.getAnswerQuestion());
        return questionRepository.save(existingQuestion);
    }

}
