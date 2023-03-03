package exercici1n1.entities;

import java.io.Serializable;

public class Tree extends Product {
    private String name;
    private double height;

    public Tree(String name, double height, double price) {
        super(price);
        this.name = name;
        this.height= height;

    }

}
