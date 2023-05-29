package com.example.demo.entity.user;

import com.example.demo.dto.ResultDto;
import com.example.demo.entity.result.Result;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "username", nullable = false, length = 100)
    private String userName;
    @Column(name = "mail", nullable = false, length = 100)
    private String email;
    @Column(name = "password", nullable = false, length = 100)
    private String password;
    @Column(name = "role", length = 100)
    private String role;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_user_id", referencedColumnName = "user_id")
    private List<Result> result = new ArrayList<>();

}
