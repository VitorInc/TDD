package br.com.Prototype.FullStack.Repository;


import br.com.Prototype.FullStack.Entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private final List<Product> products;

    public ProductRepository(List<Product> products) {
        this.products = products;
    }

    public static List<Product> productList(){
        List<Product> pdct = new ArrayList<Product>();
        pdct.add(new Product
                        (1l, "Curso Java", "Curso sintaxe java", 10,100.0,0.5)
                );
        pdct.add(new Product
                        (2l, "Curso JavaScript", "Curso sintaxe JS",10 ,100.0,0.5)
                );
        return pdct;
    }

    public List<Product> displayProducts() {
        return products;
    }

    public List<Product> displayProducts(String product){
        return products.stream().filter(x -> x.getName().contains(product))
                .filter(x -> x.getPrice()>0).collect(Collectors.toList());
    }

    public int count(){
        return products.size();
    }

    public void addProduct(Product product){
        products.add(product);
    }



    public Product byId(Long id){
        return products.stream().filter(x -> x.getId().equals(id))
                .findFirst().orElse(null);
    }

    public void updateProductData(Product product){
        products.stream().filter(x -> x.getId().equals(product.getId()))
            .forEach(x -> x.setName(product.getName()));
        products.stream().filter(x -> x.getId().equals(product.getId()))
                .forEach(x -> x.setAmountAvailable(product.getAmountAvailable()));
        products.stream().filter(x -> x.getId().equals(product.getId()))
                .forEach(x -> x.setDescription(product.getDescription()));
        products.stream().filter(x -> x.getId().equals(product.getId()))
                .forEach(x -> x.setPrice(product.getPrice()));
    }

    public void delete (Long id){
        products.removeIf(x -> x.getId().equals(id));
    }


}
