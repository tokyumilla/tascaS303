package exercici1n1.entities;

public class Tree extends Product {

    private double height;

    public Tree(String name, double height, double price) {
        super(name, price);
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
