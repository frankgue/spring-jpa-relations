package com.gkfcsolution.springjparelations.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Created on 2025 at 10:25
 * File: null.java
 * Project: spring-jpa-relations
 *
 * @author Frank GUEKENG
 * @date 29/09/2025
 * @time 10:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 25, nullable = false, unique = true)
    private String name;
}
