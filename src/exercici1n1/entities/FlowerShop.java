package exercici1n1.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class FlowerShop implements Serializable {
    private String name;
    ArrayList<Product> stock = new ArrayList<>();
    private double stockValue;

    public void setStockValue(double stockValue) {
        this.stockValue = stockValue;
    }

    public void calculateStockValue (ArrayList<Product> stock) {
        double total = 0;
        for (Product product : stock) {
            total += product.getPrice();
        }
        setStockValue(total);
    }

    public FlowerShop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Product> getStock() {
        return stock;
    }

    public double getStockValue() {
        calculateStockValue(stock);
        return stockValue;
    }
    public boolean equals (Object o) {
        if(this==o) return true;
        if(o==null || getClass() !=o.getClass()) return false;
        FlowerShop flowerShop = (FlowerShop) o;
        return name.equals(flowerShop.name);
    }
    public int hashCode(){
        return Objects.hash(name);
    }
}
