package com.example.test.TDD.Service;

import com.example.test.TDD.Entity.Order;
import com.example.test.TDD.Entity.Sale;

import java.util.List;

public interface iSaleService {
    double productList(double price, int amount, double off);
    Sale addOnDaBill(List<Order> bOrderList);
}
