package com.example.productservicedemo.controller;

import com.example.productservicedemo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.example.rest.controller.ProductsApi;
import org.example.rest.model.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController implements ProductsApi {

    private final ProductService productService;

    @Override
    public ResponseEntity<ProductDto> getProduct(Long id) {
        return ResponseEntity.of(productService.findProduct(id));
    }

    @Override
    public ResponseEntity<ProductDto> createProduct(ProductDto productDto) {
        return ResponseEntity.ok(productService.createProduct(productDto));
    }


    @Override
    public ResponseEntity<List<ProductDto>> getProducts() throws InterruptedException {
//        Thread.sleep(20000);
        return ResponseEntity.ok(productService.getProducts());
    }

    @Override
    public ResponseEntity<ProductDto> modifyProduct(Long id, ProductDto productDto) {
        return ResponseEntity.ok(productService.updateProduct(id, productDto));
    }

    @Override
    public ResponseEntity<ProductDto> modifyProductPartially(Long id, ProductDto productDto) {
        return ResponseEntity.ok(productService.patchProduct(id,productDto));
    }
}
