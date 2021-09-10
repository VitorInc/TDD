package br.com.Prototype.FullStack;

import br.com.Prototype.FullStack.entity.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {
    @Test
    public void maxOfDiscountPossible(){
        Product product = new Product(1L, "Curso Java", "Curso Básico de Java", 100, 500.0,50.0);
        Double result = product.getPriceOff(50.0);
        assertEquals(250.0, result);
    }


}
