package com.gkfcsolution.springjparelations.service;

import com.gkfcsolution.springjparelations.entity.Role;
import com.gkfcsolution.springjparelations.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2025 at 13:23
 * File: RoleService.java.java
 * Project: spring-jpa-relations
 *
 * @author Frank GUEKENG
 * @date 29/09/2025
 * @time 13:23
 */
@RequiredArgsConstructor
@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }
}
