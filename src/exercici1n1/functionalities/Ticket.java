package exercici1n1.functionalities;

import exercici1n1.entities.Product;

import java.util.ArrayList;

public class Ticket {
    ArrayList<Product> purchase = new ArrayList<>();
    private double totalCost = calculateTotal(purchase) ;

    public ArrayList<Product> getPurchase() {
        return purchase;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public double calculateTotal (ArrayList<Product> purchase) {
        int total = 0;
        for (Product product : purchase) {
            total += product.getPrice();
        }
        return total;
    }

    public void printTicket (){
        System.out.println("Esta es su compra:");
        for (Product product : purchase) {

            System.out.println(product.getName() + "precio:" + product.getPrice() + "€");
        }
        System.out.println("El total de su compra es: " + totalCost + "€");
    }
}
