package br.com.Prototype.FullStack.Repository;

import br.com.Prototype.FullStack.entity.Product;
import lombok.*;

import java.lang.reflect.Array;

import java.util.Arrays;
import java.util.List;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRepository {

    private List<Product> productList;



    public ProductRepository(Object productList){
        this.productList = Arrays.asList(
        new Product(1L, "Curso Java", "Curso Básico de Java", 100, 500.0,10.0),
        new Product(2L, "Curso JavaScript", "Curso Básico de JavaScript", 100, 500.0,10.0),
        new Product(3L, "Curso Java", "Curso Básico de Java/Spring", 100, 575.0,15.0),
        new Product(4L, "Curso JavaScript/React", "Curso Básico de JavaScript/React", 100, 575.0,15.0)
    );



    }

    public void displayProducts() {
        for (Product list: productList){
            System.out.println(list);
        }
    }

}
