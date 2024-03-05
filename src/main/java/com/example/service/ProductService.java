package com.example.service;

import com.example.entity.Product;
import com.example.mapper.ProductMapper;
import com.example.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.example.event.api.IProductEventsProducer;
import org.example.event.model.ProductCreatedPayload;
import org.springframework.stereotype.Service;
import org.example.rest.model.ProductDto;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;

    private final ProductRepository productRepository;
    private final IProductEventsProducer eventsProducer;

    public ProductDto createProduct(ProductDto productDto) {
        Product product = productMapper.toProduct(productDto);
        Product createdProduct = productRepository.save(product);

        ProductCreatedPayload payload = new ProductCreatedPayload();
        payload.setProductId(Math.toIntExact(createdProduct.getId()));
        payload.setProductType(createdProduct.getName());

        eventsProducer.sendProductCreated(payload);

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
