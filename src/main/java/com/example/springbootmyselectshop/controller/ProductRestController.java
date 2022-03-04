package com.example.springbootmyselectshop.controller;


import com.example.springbootmyselectshop.models.Product;
import com.example.springbootmyselectshop.models.ProductMypriceRequestDto;
import com.example.springbootmyselectshop.models.ProductRepository;
import com.example.springbootmyselectshop.models.ProductRequestDto;
import com.example.springbootmyselectshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor// final로 선언된 멤버 변수를 자동으로 생성
@RestController // JSON
public class ProductRestController {

    private final ProductRepository productRepository;
    private final ProductService productService;

    // 등록된 전체 상품 목록 조회
    @GetMapping("/api/products")
    public List<Product> getProducts () {
        return productRepository.findAll();
    }

    // 신규 상품 등록
    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductRequestDto requestDto) {
        Product product = new Product(requestDto);
        return productRepository.save(product);
    }

    // 설정 가격 변경
    @PutMapping("/api/products/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto){
        return productService.update(id, requestDto);
    }
}
