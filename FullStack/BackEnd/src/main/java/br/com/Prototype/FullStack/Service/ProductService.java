package br.com.Prototype.FullStack.Service;

import br.com.Prototype.FullStack.Repository.ProductRepository;
import br.com.Prototype.FullStack.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements iProductService{

    @Autowired
    ProductRepository productRepository;

    public List<Product> sProductList(Product product){
        if(product != null){
            return productRepository.displayProducts(product.getName());
        }
        return productRepository.displayProducts();
    }

    public Long addAmount(Product product) {
        if (product.getId() == null) {
            product.setId(productRepository.count()+1l);
        }
        productRepository.addProduct(product);
        return product.getId();
    }

    public Product byId(Long id){
        return productRepository.byId(id);
    }

    public void update(Product product){
        productRepository.updateProductData(product);
    }
    public void delete(Long id){
        productRepository.delete(id);
    }
}
