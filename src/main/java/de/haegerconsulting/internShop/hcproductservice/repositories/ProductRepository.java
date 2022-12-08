package de.haegerconsulting.internShop.hcproductservice.repositories;

import de.haegerconsulting.internShop.hcproductservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByProductId(Long productId);

    Product findByName(String name);
}
