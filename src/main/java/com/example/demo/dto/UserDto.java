package com.example.demo.dto;

import com.example.demo.entity.result.Result;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long userId;
    private String userName;
    private String email;
    private String password;
    private String role;
    private List<Result> results;

}
