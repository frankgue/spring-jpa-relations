package com.gkfcsolution.springjparelations.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Created on 2025 at 13:44
 * File: null.java
 * Project: spring-jpa-relations
 *
 * @author Frank GUEKENG
 * @date 29/09/2025
 * @time 13:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
