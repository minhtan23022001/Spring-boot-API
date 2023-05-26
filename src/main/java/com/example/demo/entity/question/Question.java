package com.example.demo.entity.question;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "question", nullable = false, length = 500)
    private String nameQuestion;
    @Column(name = "answerA", nullable = false, length = 100)
    private String answerA;
    @Column(name = "answerB", nullable = false, length = 100)
    private String answerB;
    @Column(name = "answerC", nullable = false, length = 100)
    private String answerC;
    @Column(name = "answerD", nullable = false, length = 100)
    private String answerD;
    @Column(name = "answerQuestion", nullable = false, length = 100)
    private String answerQuestion;


//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "question_id")
//    private List<Option> options = new ArrayList<>();
}
