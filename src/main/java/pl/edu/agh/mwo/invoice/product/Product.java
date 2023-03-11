package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product {
    private final String name;

    private final BigDecimal price;

    private final BigDecimal taxPercent;

    protected Product(String name, BigDecimal price, BigDecimal tax) {
        this.name = name;
        this.price = price;
        this.taxPercent = tax;
        if (name == null || name.isEmpty() ) {
            throw new IllegalArgumentException("Wrong name!");
        }
        if (price == null || price.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException("Wrong price!");
        }
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public BigDecimal getTaxPercent() {
        return this.taxPercent;
    }

    public BigDecimal getPriceWithTax() {
        BigDecimal priceWithTax = this.price.multiply(this.taxPercent).add(this.price);
        return priceWithTax;
    }
}
