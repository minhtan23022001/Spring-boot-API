package com.example.demo.service;

import com.example.demo.entity.question.Question;
import com.example.demo.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

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

    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    public String deleteQuestion(Long id) {
        questionRepository.deleteById(id);
        return "Question deleted " + id + "!";
    }

    public Question update(Question question) {
        Question existingQuestion = questionRepository.findById(question.getId()).orElse(question);
        existingQuestion.setNameQuestion(question.getNameQuestion());
        existingQuestion.setAnswerA(question.getAnswerA());
        existingQuestion.setAnswerB(question.getAnswerB());
        existingQuestion.setAnswerC(question.getAnswerC());
        existingQuestion.setAnswerD(question.getAnswerD());
        existingQuestion.setAnswerQuestion(question.getAnswerQuestion());
        return questionRepository.save(existingQuestion);
    }

}
