package exercici1n1.entities;

import exercici1n1.functionalities.Ticket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class FlowerShop implements Serializable {
    private String name;
    private ArrayList<Product> stock = new ArrayList<>();
    private double stockValue;

    private ArrayList<Ticket> tickets = new ArrayList<>();

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setStockValue(double stockValue) {
        this.stockValue = stockValue;
    }

    public void calculateStockValue(ArrayList<Product> stock) {
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

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlowerShop flowerShop = (FlowerShop) o;
        return name.equals(flowerShop.name);
    }

    public int hashCode() {
        return Objects.hash(name);
    }

    public void addTickets (Ticket ticket){
        tickets.add(ticket);
    }

    public void showSales (){
        int i = 1;
        for (Ticket ticket: tickets) {
            System.out.println("Venta nº:" + i);
            System.out.println(ticket.listTicket());
            i++;
        }
    }

    public void showTotal () {
        double total = 0;
        for (Ticket ticket: tickets) {
            total += ticket.calculateTotal();
        }
        System.out.println("El total de ventas es: " + total + "€");
    }
}
