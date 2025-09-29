package com.gkfcsolution.springjparelations.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on 2025 at 13:42
 * File: null.java
 * Project: spring-jpa-relations
 *
 * @author Frank GUEKENG
 * @date 29/09/2025
 * @time 13:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "product_details")
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;
    private String manufacturer;
    private Double weight;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
