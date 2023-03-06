package exercici1n1.entities;

import java.io.Serializable;

public abstract class Product implements Serializable {
    private double price;
    private String name;


    public String getName() {
        return name;
    }

    public Product(String name, double price) {
        this.name=name;
        this.price=price;
    }

    public double getPrice() {
        return price;
    }
}
