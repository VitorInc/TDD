package com.example.test.TDD.Controller;

import com.example.test.TDD.Entity.Order;
import com.example.test.TDD.Entity.Product;
import com.example.test.TDD.Entity.Sale;
import com.example.test.TDD.Service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Sale")
public class SaleController {

    public SaleController(List<Product> productList) {
        this.productList = new ArrayList<>();
    }

    @PostMapping
    public ResponseEntity<Sale> addInDaBill(@RequestBody List<Order> orderList) {
        Sale sale = saleService.addOnDaBill(orderList);
        return ResponseEntity.ok().body(sale);
    }

    @Autowired
    private SaleService saleService;

    private final List<Product> productList;
}
