package de.haegerconsulting.internShop.hcproductservice.serviceImpl;

import de.haegerconsulting.internShop.hcproductservice.entities.File;
import de.haegerconsulting.internShop.hcproductservice.entities.Product;
import de.haegerconsulting.internShop.hcproductservice.repositories.FileRepository;
import de.haegerconsulting.internShop.hcproductservice.repositories.ProductRepository;
import de.haegerconsulting.internShop.hcproductservice.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final FileRepository fileRepository;

    public ProductServiceImpl(ProductRepository productRepository, FileRepository fileRepository) {
        this.productRepository = productRepository;
        this.fileRepository = fileRepository;
    }

    @Override
    public Product findByProductId(Long productId) {
        return productRepository.findByProductId(productId);
    }

    @Override
    public List<Product> findAll() {
        log.info("findAll products in productService");
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        log.info("createProduct in productService");
        List<File> files = fileRepository.findAllByProductName(product.getName());
        if (files.size() != 0) {
            product.setProductImageUrl("http://ada0270b0ff7f4a5d9c8155d3508a0ba-665421351.eu-west-2.elb.amazonaws.com/api/products/images/file/download/" + files.get(0).getImageId());
            Product product1 = productRepository.findByName(product.getName());
            if (product1 == null) {
                return productRepository.save(product);
            } else {
                throw new IllegalStateException("Product with this name already exists");
            }

        } else {
            throw new IllegalStateException("Please choose a product image first");
        }

    }

    @Override
    public Product findByProductName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Product updateProduct(Product existedProduct) {
        return productRepository.save(existedProduct);
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
