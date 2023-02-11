package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
//    private Collection<Product> products;

    private Map<Product, Integer> products = new HashMap<>();

    public void addProduct(Product product) {
        // TODO: implement
    }

    public void addProduct(Product product, Integer quantity) {
//        for (int i = 0; i <quantity; i++){
//            products.add(product);
//        }
        this.products.put(product, quantity);
    }

    public BigDecimal getSubtotal() {
           return BigDecimal.ZERO;
    }

    public BigDecimal getNetPrice() {
        return BigDecimal.ZERO;
    }

    public BigDecimal getTax() {

        return null;
    }

    public BigDecimal getTotal() {

        return null;
    }
}
