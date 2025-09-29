package com.gkfcsolution.springjparelations.repository;

import com.gkfcsolution.springjparelations.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on 2025 at 13:17
 * File: null.java
 * Project: spring-jpa-relations
 *
 * @author Frank GUEKENG
 * @date 29/09/2025
 * @time 13:17
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
