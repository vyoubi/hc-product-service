package de.haegerconsulting.internShop.hcproductservice.controllers;

import de.haegerconsulting.internShop.hcproductservice.entities.Product;
import de.haegerconsulting.internShop.hcproductservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/product/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product findByProductId(@PathVariable("id") Long productId) {
        log.info("findByProductId in ProductController");
        return productService.findByProductId(productId);
    }

    @GetMapping("/product/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Product findByProductName(@PathVariable("name") String name) {
        log.info("findByProductName in ProductController");
        return productService.findByProductName(name);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findAll() {
        log.info("findAll Products in ProductController");
        return productService.findAll();
    }

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product) {
        log.info("createProduct in ProductController");
        return productService.createProduct(product);
    }

    @PutMapping("/update/{id}")
    public Product editProduct(@PathVariable("id") Long productId, @RequestBody Product product) {
        log.info("editProduct in ProductController");
        Product existedProduct = productService.findByProductId(productId);

        if (existedProduct != null) {
            existedProduct.setName(product.getName());
            existedProduct.setDescription(product.getDescription());
            existedProduct.setPrice(product.getPrice());
            return productService.updateProduct(existedProduct);
        } else {
            return null;
        }
    }

    @DeleteMapping("/remove/{id}")
    public void deleteProduct(@PathVariable("id") Long productId) {
        log.info("Delete Product in ProductController");
        productService.deleteProduct(productId);
    }
}
