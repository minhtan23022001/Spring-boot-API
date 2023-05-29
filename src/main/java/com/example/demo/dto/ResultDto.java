package com.example.demo.dto;

import com.example.demo.entity.user.User;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultDto {
    private Long id;
    private Integer totalCorrectQuestion;
    private Integer totalMoney;
    private String userName;
}
