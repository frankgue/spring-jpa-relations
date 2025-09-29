package com.gkfcsolution.springjparelations.service;

import com.gkfcsolution.springjparelations.entity.Role;
import com.gkfcsolution.springjparelations.entity.User;
import com.gkfcsolution.springjparelations.repository.RoleRepository;
import com.gkfcsolution.springjparelations.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created on 2025 at 13:16
 * File: null.java
 * Project: spring-jpa-relations
 *
 * @author Frank GUEKENG
 * @date 29/09/2025
 * @time 13:16
 */
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public List<User> showUserList(){
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User editUser(int id, User user) {
        User savedUser = userRepository.findById(id).get();
        User newUser = User.builder()
                .password(user.getPassword())
                .email(user.getEmail())
                .build();
        for (Role role : user.getRoles()) {
            newUser.addRole(role);
        }
        return  userRepository.save(newUser);
    }

    public String deleteUser(int id) {
        userRepository.deleteById(id);
        return "Deleting done successfully...";
    }
}
