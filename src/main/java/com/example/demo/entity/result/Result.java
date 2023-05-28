package com.example.demo.entity.result;

import com.example.demo.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "results")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "total_correct_question", nullable = false)
    private Integer totalCorrectQuestion;
    @Column(name = "total_money", nullable = false)
    private Integer totalMoney;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "u_id")
    private User user;

}
