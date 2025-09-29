package com.gkfcsolution.springjparelations.repository;

import com.gkfcsolution.springjparelations.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on 2025 at 10:49
 * File: null.java
 * Project: spring-jpa-relations
 *
 * @author Frank GUEKENG
 * @date 29/09/2025
 * @time 10:49
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
