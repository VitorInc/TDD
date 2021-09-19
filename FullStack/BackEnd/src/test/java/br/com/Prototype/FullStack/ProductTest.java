package br.com.Prototype.FullStack;

import br.com.Prototype.FullStack.Entity.Product;
import br.com.Prototype.FullStack.Repository.ProductRepository;
import br.com.Prototype.FullStack.Service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductTest {
    @MockBean
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @MockBean
    Product product;




    @Test
        public void doesDisplayProducts() {
            List<Product> dsplList = productService.sProductList(null);
                Assertions.assertTrue(listDisplay(dsplList), String.valueOf(true));
                verify(productRepository, times(1)).displayProducts();
    }

    @Test
    public void addItemOnDaList() {
        Product product = new Product(null,"teste","asdopka",250,19.0,0.5);
            when(productRepository.count()).thenReturn(10);
            doNothing().when(productRepository).addProduct(null);
        long pdct = productService.addAmount(product);
            assertEquals(11, pdct);
            verify(productRepository, times(1)).addProduct(product);
            verify(productRepository, times(1)).count();
    }

    @Test
    public void addItemOnDaListWId() {
        Product product = new Product(5l,"teste","asdopka",250,19.0,0.5);
            when(productRepository.count()).thenReturn(10);
            doNothing().when(productRepository).addProduct(null);
        long pdct = productService.addAmount(product);
            assertEquals(pdct,5l);
            verify(productRepository, times(1)).addProduct(product);
            verify(productRepository, times(0)).count();
    }

    @Test
    public void testFindById(){
        when(productRepository.byId(1l)).thenReturn(product);
            Product troughId = productService.byId(1l);
            Assertions.assertEquals(product.getId(), troughId.getId());
            verify(productRepository, times(1)).byId(1l);

    }

    @Test
    public void Update(){
        Product pdct = new Product(1l, "Teste", "Teste", 5, 50.0,0.3);
            doNothing().when(productRepository).updateProductData(product);
            productService.update(pdct);
            verify(productRepository, times(1)).updateProductData(pdct);
    }

    @Test
    public void Del(){
        doNothing().when(productRepository).delete(2l);
        productService.delete(2l);
        verify(productRepository,times(1)).delete(2l);
    }

    private Boolean listDisplay(List<Product> list){
        if(list != null){
            return true;
        }
        return false;
    }
}
