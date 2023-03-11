package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    //private Collection<Product> products;
    private Map<Product, Integer> products = new HashMap<Product, Integer>();

    public void addProduct(Product product) {
        addProduct(product, 1);
    }

    public void addProduct(Product product, Integer quantity) {
        if (product == null || quantity <=0){
            throw new IllegalArgumentException();
        }
        this.products.put(product, quantity);
    }

    public BigDecimal getNetPrice() {
        BigDecimal priceNet = BigDecimal.ZERO;
        for(Product product: products.keySet()){
            BigDecimal quantity = new BigDecimal(products.get(product));
            priceNet = priceNet.add(product.getPrice().multiply(quantity));
        }
        return priceNet;
    }

    public BigDecimal getTax() {
        return getTotal().subtract(getNetPrice());
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (Product product: products.keySet()){
            BigDecimal quantity = new BigDecimal(products.get(product));
            total = total.add(product.getPriceWithTax().multiply(quantity));
        }
        return total;
        }
}
