package br.com.Prototype.FullStack.Service;

import br.com.Prototype.FullStack.Entity.Product;

import java.util.List;

public interface iProductService {
    List<Product> sProductList(Product product);
    Long addAmount(Product product);
    public Product byId(Long id);
    public void update(Product product);
    public void delete(Long id);
}
