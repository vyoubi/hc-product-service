package de.haegerconsulting.internShop.hcproductservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "product_hc")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    private String productImageUrl;
    @Column(unique=true)
    private String name;
    @Column(length=5000)
    private String description;
    private BigDecimal price;
}
