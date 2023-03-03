package exercici1n1.functionalities;

import exercici1n1.entities.Product;

import java.util.ArrayList;

public class Ticket {
    ArrayList<Product> purchase;
    private double totalCost = calculateTotal(purchase) ;

    public double calculateTotal (ArrayList<Product> purchase) {
        int total = 0;
        for (Product product : purchase) {
            total += product.getPrice();
        }
        return total;
    }
}
