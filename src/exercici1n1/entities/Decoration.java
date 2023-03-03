package exercici1n1.entities;

import java.io.Serializable;

public class Decoration extends Product {
    private String name;
    private String type;

    public Decoration(String name, String type, double price) {
        super(price);
        this.name = name;
        this.type = type;
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public String toString() {
        return "Decoración{nombre: " + name + ", tipo: " + type + ", precio: "+ super.getPrice() + "}";
    }
}
