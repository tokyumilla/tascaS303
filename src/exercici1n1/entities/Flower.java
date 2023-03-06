package exercici1n1.entities;

public class Flower extends Product {
    private String name;
    private String colour;
    private double price;

    public Flower(String name, String colour, double price) {
        super(name, price);
        this.colour = colour;
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public String toString() {
        return "Flor{nombre: " + super.getName() + ", color: " + colour + ", precio: "+ super.getPrice() + "}";
    }
}
