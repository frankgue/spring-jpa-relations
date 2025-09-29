package com.gkfcsolution.springjparelations.controller;

import com.gkfcsolution.springjparelations.entity.User;
import com.gkfcsolution.springjparelations.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on 2025 at 13:19
 * File: null.java
 * Project: spring-jpa-relations
 *
 * @author Frank GUEKENG
 * @date 29/09/2025
 * @time 13:19
 */
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> showUserList(){
        return userService.showUserList();
    }
    @PostMapping(value = "/save")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping(value = "/edit/{id}")
    public User editUser(@PathVariable int id, @RequestBody User user){
        return userService.editUser(id, user);
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id){
        return userService.deleteUser(id);
    }
}
