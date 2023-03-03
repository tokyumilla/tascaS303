package exercici1n1.entities;

import java.io.Serializable;

public abstract class Product implements Serializable {
    private Double price;

    public Product(double price) {
    }

    public Double getPrice() {
        return price;
    }
}
