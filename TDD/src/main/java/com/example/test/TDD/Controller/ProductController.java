package com.example.test.TDD.Controller;

import com.example.test.TDD.Entity.Product;
import com.example.test.TDD.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Product")
public class ProductController {


    public ProductController(List<Product> productList) {
        this.productList = new ArrayList<>();
    }

    @GetMapping
    public List<Product> displayAll(@RequestParam(required = false) Product product){
        return productService.sProductList(product);
    }

    @GetMapping("/{id}")
    public Product throwId(@PathVariable("id") Long id){
        return productService.byId(id);
    }



    @PostMapping
    public ResponseEntity<Long> add(@RequestBody Product product){
        productService.addAmount(product);
        return new ResponseEntity(HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity update(@RequestBody Product product){
        productService.update(product);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity delete(@PathVariable("id") Long id){
        productService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    private final List<Product> productList;

    @Autowired
    private ProductService productService;
}
