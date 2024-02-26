package com.example.productservicedemo.service;

import com.example.productservicedemo.entity.Product;
import com.example.productservicedemo.mapper.ProductMapper;
import com.example.productservicedemo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.example.rest.model.ProductDto;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;

    private final ProductRepository productRepository;

    public ProductDto createProduct(ProductDto productDto) {
        Product product = productMapper.toProduct(productDto);
        Product createdProduct = productRepository.save(product);
        return productMapper.toDto(createdProduct);
    }

    public Optional<ProductDto> findProduct(Long id) {
        return productRepository.findById(id).map(productMapper::toDto);
    }

    public List<ProductDto> getProducts() {
        return productRepository
                .findAll()
                .stream()
                .map(productMapper::toDto)
                .toList();
    }

    public ProductDto updateProduct(Long targetProductId, ProductDto source) {
        Product targetProduct = productRepository
                .findById(targetProductId)
                .orElseThrow();

        productMapper.updateProduct(targetProduct, source);

        Product modifiedProduct = productRepository.save(targetProduct);

        return productMapper.toDto(modifiedProduct);
    }

    public ProductDto patchProduct(Long targetProductId, ProductDto source) {
        Product targetProduct = productRepository
                .findById(targetProductId)
                .orElseThrow();

        productMapper.patchProduct(targetProduct, source);

        Product modifiedProduct = productRepository.save(targetProduct);

        return productMapper.toDto(modifiedProduct);
    }
}
