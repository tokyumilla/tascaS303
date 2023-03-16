package exercici1n1;

import exercici1n1.connection.Connection;
import exercici1n1.entities.*;
import exercici1n1.functionalities.Ticket;
import exercici1n1.functionalities.Tool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Tool tool = Tool.getInstance();
        int option;
        Scanner sc = new Scanner(System.in);
        ArrayList<FlowerShop> flowerShops;
        flowerShops = tool.readFile();


        do {
            System.out.println("Introduzca una opción (0-8): ");
            System.out.println("0. Cerrar el programa");
            System.out.println("1. Crear una floristería nueva");
            System.out.println("2. Mostrar floristerías");
            System.out.println("3. Añadir producto");
            System.out.println("4. Listar stock");
            System.out.println("5. Retirar un producto");
            System.out.println("6. Consultar el valor total de una floristería");
            System.out.println("7. Hacer una compra");
            System.out.println("8. Mostrar listado de compras");
            System.out.println("9. Mostrar total de ventas");
            option = sc.nextInt();


            switch (option) {
                case 1:
                    tool.createFlowerShop(flowerShops);
                    tool.writeFile(flowerShops);
                    break;
                case 2:
                    tool.showFlowerShops(flowerShops);
                    break;
                case 3:
                    System.out.println("¿A qué floristería quiere añadir el producto?");
                    FlowerShop flowerShop1 = tool.findFlowerShop(flowerShops);
                    if (flowerShop1 != null) {
                        tool.addProduct(flowerShop1);
                    }
                    tool.writeFile(flowerShops);
                    break;
                case 4:
                    System.out.println("¿De qué floristería quiere consultar el stock?");
                    FlowerShop flowerShop2 = tool.findFlowerShop(flowerShops);
                    if (flowerShop2 != null) {
                        tool.showStock(flowerShop2);
                    }
                    break;
                case 5:
                    System.out.println("¿De qué floristería quiere retirar el producto?");
                    FlowerShop flowerShop3 = tool.findFlowerShop(flowerShops);
                    if (flowerShop3 != null) {
                        tool.deleteProduct(flowerShop3);
                        tool.writeFile(flowerShops);
                    }
                    break;
                case 6:
                    System.out.println("¿De qué floristería quiere consultar el valor total?");
                    FlowerShop flowerShop4 = tool.findFlowerShop(flowerShops);
                    if (flowerShop4 != null) {
                        System.out.println("El valor total del stock de la floristería es " +
                                flowerShop4.getStockValue());
                    }
                    break;
                case 7:
                    System.out.println("¿En qué floristería quiere comprar?");
                    FlowerShop flowerShop5 = tool.findFlowerShop(flowerShops);
                    if (flowerShop5 != null) {
                        Ticket ticket = new Ticket();
                        tool.buyVoid(flowerShop5, ticket);
                        ticket.printTicket();
                        flowerShop5.addTickets(ticket);
                        tool.writeFile(flowerShops);
                    }
                    break;
                case 8:
                    System.out.println("¿De qué floristería quiere ver el histórico de compras?");
                    FlowerShop flowerShop6 = tool.findFlowerShop(flowerShops);
                    if (flowerShop6 != null) {
                        flowerShop6.showSales();
                    }
                    break;
                case 9:
                    System.out.println("¿De qué floristería quieres saber el total de ventas?");
                    FlowerShop flowerShop7 = tool.findFlowerShop(flowerShops);
                    if (flowerShop7 != null) {
                        flowerShop7.showTotal();
                    }
                    break;

                case 0:
                    System.out.println("Cerrando el programa");
                    break;

            }
        } while (option != 0);
    }
}