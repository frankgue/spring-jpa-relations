package com.gkfcsolution.springjparelations.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2025 at 10:27
 * File: null.java
 * Project: spring-jpa-relations
 *
 * @author Frank GUEKENG
 * @date 29/09/2025
 * @time 10:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private List<Product> products = new ArrayList<>();
}
