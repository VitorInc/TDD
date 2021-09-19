package br.com.Prototype.FullStack.Service;

import br.com.Prototype.FullStack.Entity.Order;
import br.com.Prototype.FullStack.Entity.Sale;

import java.util.List;

public interface iSaleService {
    double productList(double price, int amount, double off);
    Sale addOnDaBill(List<Order> bOrderList);

}
