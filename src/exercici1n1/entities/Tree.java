package exercici1n1.entities;

import java.io.Serializable;

public class Tree extends Product {

    private double height;

    public Tree(String name, double height, double price) {
        super(price);
        super(name);
        this.height= height;

    }


    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public String toString() {
        return "Árbol{nombre: " + super.getName() + ", altura: " + height + ", precio: "+ super.getPrice() + "}";
    }
}
