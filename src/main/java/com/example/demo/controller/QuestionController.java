package com.example.demo.controller;

import com.example.demo.entity.question.Question;
import com.example.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("question/")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping("/addQuestion")
    public Question addQuestion(@RequestBody Question question) {
        return questionService.saveQuestion(question);
    }

    @PostMapping("/addQuestions")
    public List<Question> addQuestions(@RequestBody List<Question> questions) {
        return questionService.saveQuestions(questions);
    }

    @GetMapping("/questions")
    public List<Question> findAllQuestions() {
        return questionService.getAllQuestion();
    }

    @GetMapping("/setOfQuestions")
    public List<Question> setOfQuestions() {
        return questionService.setOfQuestion();
    }

    @GetMapping("/question/{id}")
    public Question findQuestionById(@PathVariable Long id) {
        return questionService.getQuestionById(id);
    }

    @PutMapping("/update/{id}")
    public Question updateQuestion(@RequestBody Question question, @PathVariable Long id) {
        return questionService.update(question,id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable Long id) {
        return questionService.deleteQuestion(id);
    }
}
