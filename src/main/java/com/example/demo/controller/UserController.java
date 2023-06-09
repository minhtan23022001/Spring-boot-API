package com.example.demo.controller;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.result.Result;
import com.example.demo.entity.user.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.response.LoginResponse;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public String saveUser(@RequestBody User user) {
        String id = userService.addUser(user);
        return id;
    }

    @PutMapping ("/saveResult/{id}")
    public User saveResult(@RequestBody List<Result> result, @PathVariable Long id) {
        userService.userAddResult(result, id);
        return userService.getUser(id);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto) {
        LoginResponse loginResponse = userService.loginUser(loginDto);
        return ResponseEntity.ok(loginResponse);
    }

    @GetMapping("/getUsers")
    public List<User> findAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getUser/{id}")
    public User findUserById(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @DeleteMapping ("/delete/{id}")
    public String deleteUserById(@PathVariable Long id) {
        return userService.deleteUserById(id);
    }
}
