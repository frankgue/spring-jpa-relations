package com.gkfcsolution.springjparelations;

import com.gkfcsolution.springjparelations.entity.Role;
import com.gkfcsolution.springjparelations.entity.User;
import com.gkfcsolution.springjparelations.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

/**
 * Created on 2025 at 10:50
 * File: null.java
 * Project: spring-jpa-relations
 *
 * @author Frank GUEKENG
 * @date 29/09/2025
 * @time 10:50
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateeRoles() {
        Role roleAdmin = Role.builder()
                .name("Administrator")
                .build();
        Role roleEditor = Role.builder()
                .name("Editor")
                .build();
        Role roleVisitor = Role.builder()
                .name("Visitor")
                .build();

        entityManager.persist(roleAdmin);
        entityManager.persist(roleEditor);
        entityManager.persist(roleVisitor);
    }

    @Test
    public void testCreateNewUserWithRole(){
        Role role = entityManager.find(Role.class, 1);
        User user = User.builder()
                .email("frank@gmail.com")
                .password("123456")
                .build();
        user.addRole(role);

        userRepository.save(user);
    }
    @Test
    public void testCreateNewUserWithTwoRole(){
        Role roleEditor = entityManager.find(Role.class, 2);
        Role roleVisitor = entityManager.find(Role.class, 3);
        User user = User.builder()
                .email("frankguekeng@gmail.com")
                .password("123456")
                .build();
        user.addRole(roleEditor);
        user.addRole(roleVisitor);

        userRepository.save(user);
    }

    @Test
    public void testAssignRoleToExistingUser(){
        User user = userRepository.findById(1).get();
        Role roleEditor = entityManager.find(Role.class, 2);
        user.addRole(roleEditor);
    }
    @Test
    public void testRemoveRoleToExistingUser(){
        User user = userRepository.findById(2).get();
        Role roleEditor = entityManager.find(Role.class, 2);
        user.removeRole(roleEditor);
    }
    @Test
    public void testCreateNewUserWithNewRole(){
        Role roleSalesPerson = Role.builder()
                .name("Saleperson")
                .build();
        User user = User.builder()
                .email("guekeng@gmail.com")
                .password("guekeng123")
                .build();
        user.addRole(roleSalesPerson);

        userRepository.save(user);
    }

    @Test
    public void testGetUser(){
        User user = userRepository.findById(1).get();
        entityManager.detach(user);
        System.out.println(user.getEmail());
        System.out.println(user.getRoles());
        System.out.println(user);
    }

    @Test
    public void testRemoveUser(){
        userRepository.deleteById(4);
    }
}
