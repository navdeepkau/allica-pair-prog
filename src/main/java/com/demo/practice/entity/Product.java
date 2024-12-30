package com.demo.practice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    private String productId;

    @Column(name = "product_name", nullable = false, length = 255)
    private String productName;

    @Column(name = "metadata", columnDefinition = "TEXT")
    private String metadata;

    @Column(name = "is_active")
    private Boolean isActive;

    @PrePersist
    public void generateId() {
        if (this.productId == null) {
            this.productId = UUID.randomUUID().toString(); // Assign a UUID if not set
        }
    }
}
