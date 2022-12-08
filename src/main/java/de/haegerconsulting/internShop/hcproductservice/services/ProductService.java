package de.haegerconsulting.internShop.hcproductservice.services;

import de.haegerconsulting.internShop.hcproductservice.entities.Product;

import java.util.List;

public interface ProductService {

    Product findByProductId(Long productId);
    List<Product> findAll();
    Product createProduct(Product product);

    Product findByProductName(String name);

    Product updateProduct(Product existedProduct);

    void deleteProduct(Long productId);
}
