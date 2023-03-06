package exercici1n1.entities;

import java.io.Serializable;

public class Decoration extends Product {

    private String type;

    public Decoration(String name, String type, double price) {
        super(price);
        super(name);
        this.type = type;
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public String toString() {
        return "Decoración{nombre: " + super.getName() + ", tipo: " + type + ", precio: "+ super.getPrice() + "}";
    }
}
