package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    private Map<Product, Integer> products = new HashMap<Product, Integer>();

    public Invoice(String Name, Date date) {
    }

    public Invoice() {

    }

    public void addProduct(Product product) {
        addProduct(product, 1);
    }

    public void addProduct(Product product, Integer quantity) {
        if (product == null || quantity <= 0) {
            throw new IllegalArgumentException();
        }
        products.put(product, quantity);
    }

    public BigDecimal getNetTotal() {
        BigDecimal totalNet = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            BigDecimal quantity = new BigDecimal(products.get(product));
            totalNet = totalNet.add(product.getPrice().multiply(quantity));
        }
        return totalNet;
    }

    public BigDecimal getTaxTotal() {
        return getGrossTotal().subtract(getNetTotal());
    }

    public BigDecimal getGrossTotal() {
        BigDecimal totalGross = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            BigDecimal quantity = new BigDecimal(products.get(product));
            totalGross = totalGross.add(product.getPriceWithTax().multiply(quantity));
        }
        return totalGross;
    }


    public void addInvoice(Object o) {
        Invoice invoice = new Invoice("FV/2023/001", new Date());
    }

    private static void addItem(InvoiceItem invoiceItem) {
        Invoice.addItem(new InvoiceItem("Item 1", 5, 10.0));
        Invoice.addItem(new InvoiceItem("Item 2", 3, 20.0));
        Invoice.addItem(new InvoiceItem("Item 3", 2, 30.0));

        System.out.println(Invoice.ProductList());

    }

    private static boolean ProductList() {
        return false;
    }
}

