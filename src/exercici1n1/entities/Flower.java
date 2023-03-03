package exercici1n1.entities;

import java.io.Serializable;

public class Flower extends Product {
    private String name;
    private String colour;

    public Flower(String name, String colour, double price) {
        super(price);
        this.name = name;
        this.colour = colour;
    }
}
