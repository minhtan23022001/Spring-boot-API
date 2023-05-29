package com.example.demo.service;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.result.Result;
import com.example.demo.entity.user.User;
import com.example.demo.repository.ResultRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ResultRepository resultRepository;

    public String addUser(User userr) {
        User userFind = userRepository.findByUserName(userr.getUserName());
        if(userFind != null){
            return "Tên tài khoản đã tồn tại";
        }
        User user = new User(
                userr.getUserId(),
                userr.getUserName(),
                userr.getEmail(),
                this.passwordEncoder.encode(userr.getPassword()),
                userr.getRole(),
                userr.getResult()
        );

        userRepository.save(user);

        return "Đã tạo user " + user.getUserName();
    }
    UserDto userDto;

    public LoginResponse loginUser(LoginDto loginDto) {
        String msg = "";
        User user1 = userRepository.findByEmail(loginDto.getEmail());
        if (user1 != null) {
            String password = loginDto.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepository.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {

                return new LoginResponse("password Not Match", false);
            }
        }else {
            return new LoginResponse("Email not exits", false);
        }
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public String deleteUserById(Long id) {
        userRepository.deleteById(id);
        return "User deleted" + id + "!";
    }
    public User userAddResult(List<Result> result, Long id) {
        getUser(id).setResult(result);
        result = new ArrayList<Result>();
        for(int i = 0; i < result.size(); i++) {
            result.get(i).setUserName(getUser(id).getUserName());
        }
        resultRepository.saveAll(result);
        userRepository.save(getUser(id));
        return getUser(id);
    }
}
