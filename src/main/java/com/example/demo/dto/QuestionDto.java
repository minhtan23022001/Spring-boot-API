package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {
    private Long id;
    private String nameQuestion;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String answerQuestion;
}
