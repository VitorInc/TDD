package br.com.Prototype.FullStack.Service;

import br.com.Prototype.FullStack.Entity.Order;
import br.com.Prototype.FullStack.Entity.Product;
import br.com.Prototype.FullStack.Entity.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
@Service
public class SaleService implements iSaleService {
    @Autowired
    private ProductService productService;



    public double productList(double price, int amount, double off){
        if(off > 0 ){
            return (price * amount) - off;
        }
        return price * amount;
    }

    public Sale addOnDaBill(List<Order> bOrderList){
        List<Order> orders = new ArrayList<>();
        double finalBill = 0;

        for(Order i: bOrderList){
            Product pdct = productService.byId(i.getIdOrder());
                double productPrice = productList(pdct.getPrice(),
                                                i.getAmountRequested(),
                                                i.getOff());
                finalBill += productPrice;
                i.setProduct(pdct.getName());
                orders.add(i);
        }
        return new Sale(finalBill, orders);
    }
}
