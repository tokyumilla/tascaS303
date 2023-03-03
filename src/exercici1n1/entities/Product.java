package exercici1n1.entities;

import java.io.Serializable;

public abstract class Product implements Serializable {
    private double price;

    public Product(double price) {
        this.price=price;
    }

    public double getPrice() {
        return price;
    }
}
