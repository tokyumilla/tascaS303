package exercici1n1;

import exercici1n1.connection.Connection;
import exercici1n1.entities.*;
import exercici1n1.functionalities.Ticket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        int option;
        Scanner sc = new Scanner(System.in);
        ArrayList<FlowerShop> flowerShops;
        flowerShops = readFile();


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
            option = sc.nextInt();


            switch (option) {
                case 1:
                    createFlowerShop(flowerShops);
                    writeFile(flowerShops);
                    break;
                case 2:
                    showFlowerShops(flowerShops);
                    break;
                case 3:
                    System.out.println("¿A qué floristería quiere añadir el producto?");
                    FlowerShop flowerShop1 = findFlowerShop(flowerShops);
                    if (flowerShop1 != null) {
                        addProduct(flowerShop1);
                    }
                    writeFile(flowerShops);
                    break;
                case 4:
                    System.out.println("¿De qué floristería quiere consultar el stock?");
                    FlowerShop flowerShop2 = findFlowerShop(flowerShops);
                    if (flowerShop2 != null) {
                        showStock(flowerShop2);
                    }
                    break;
                case 5:
                    System.out.println("¿De qué floristería quiere retirar el producto?");
                    FlowerShop flowerShop3 = findFlowerShop(flowerShops);
                    if (flowerShop3 != null) {
                        deleteProduct(flowerShop3);
                        writeFile(flowerShops);
                    }
                    break;
                case 6:
                    System.out.println("¿De qué floristería quiere consultar el valor total?");
                    FlowerShop flowerShop4 = findFlowerShop(flowerShops);
                    if (flowerShop4 != null) {
                        System.out.println("El valor total del stock de la floristería es " +
                                flowerShop4.getStockValue());
                    }
                    break;
                case 7:
                    System.out.println("¿En qué floristería quiere comprar?");
                    FlowerShop flowerShop5 = findFlowerShop(flowerShops);
                    if (flowerShop5 != null) {
                        Ticket ticket = new Ticket();
                        buyVoid(flowerShop5,ticket);
                        ticket.printTicket();
                    }
                    break;
                case 0:
                    System.out.println("Cerrando el programa");
                    break;

            }
        } while (option != 0);
    }

    public static ArrayList<FlowerShop> readFile() {
        Connection connection = Connection.getInstance();
        ArrayList<FlowerShop> flowerShops;
        try {
            flowerShops = connection.readFile();
        } catch (IOException e) {
            System.out.println("No había datos previos");
            flowerShops = new ArrayList<>();
        }
        return flowerShops;
    }

    public static void createFlowerShop(ArrayList<FlowerShop> flowerShops) {
        System.out.println("Introduzca el nombre de la floristería");
        Scanner sc1 = new Scanner(System.in);
        String name = sc1.nextLine();
        FlowerShop flowerShop = new FlowerShop(name);
        boolean found = flowerShops.contains(flowerShop);

        if (found) {
            System.out.println("La floristería" + name + "ya existe");
        } else {
            flowerShops.add(flowerShop);
            System.out.println("La floristería " + name + " ha sido creada.");
        }
    }

    public static void writeFile(ArrayList<FlowerShop> flowershops) {
        Connection connection = Connection.getInstance();
        connection.writeFile(flowershops);
    }

    public static void showFlowerShops(ArrayList<FlowerShop> flowerShops) {
        for (FlowerShop fs : flowerShops) {
            System.out.println(fs.getName());
        }
    }

    public static FlowerShop findFlowerShop(ArrayList<FlowerShop> flowerShops) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        FlowerShop flowerShop = new FlowerShop(name);
        int index = flowerShops.indexOf(flowerShop);
        if (index != -1) {
            return flowerShops.get(index);
        } else {
            System.out.println("La floristería " + name + " no existe.");
            return null;
        }

    }

    public static void addProduct(FlowerShop flowerShop) {
        int option;
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Qué producto quiere añadir?(1-3)");
        System.out.println("1. Flor \n 2. Árbol \n 3. Decoración");
        option = sc.nextInt();
        switch (option) {
            case 1:
                flowerShop.getStock().add(addFlower());
                System.out.println("Flor registrada");
                break;
            case 2:
                flowerShop.getStock().add(addTree());
                System.out.println("Árbol registrado");
                break;
            case 3:
                flowerShop.getStock().add(addDeco());
                System.out.println("Decoración registrada");
                break;
        }
    }

    public static Flower addFlower() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el nombre de la flor");
        String name = sc.nextLine().toLowerCase();
        System.out.println("Introduzca el color de la flor");
        String colour = sc.nextLine().toLowerCase();
        System.out.println("Introduzca el precio de la flor");
        double price = sc.nextDouble();
        return new Flower(name, colour, price);
    }

    public static Tree addTree() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el nombre del árbol");
        String name = sc.nextLine().toLowerCase();
        System.out.println("Introduzca la altura del árbol");
        double height = sc.nextDouble();
        System.out.println("Introduzca el precio del árbol");
        double price = sc.nextDouble();
        return new Tree(name, height, price);
    }

    public static Decoration addDeco() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el nombre de la decoración");
        String name = sc.nextLine().toLowerCase();
        String option;
        String type = null;
        do {
            System.out.println("Introduzca el tipo de material: (M/P)");
            System.out.println("P. Plástico \n M. Madera");
            option = sc.nextLine().toUpperCase();
            if (option.equals("P")) {
                type = "Plástico";
            } else if (option.equals("M")) {
                type = "Madera";
            } else {
                System.out.println("Introduzca M o P");
            }
        } while (!option.equals("M") && !option.equals("P"));
        System.out.println("Introduzca el precio de la decoración");
        double price = sc.nextDouble();
        return new Decoration(name, type, price);
    }

    public static void showStock(FlowerShop flowerShop) {
        ArrayList<Product> stock = flowerShop.getStock();
        int index = 0;
        for (Product product : stock) {
            System.out.println(index + ". " + product.toString());
            index++;
        }
    }

    public static void deleteProduct(FlowerShop flowerShop) {
        ArrayList<Product> stock = flowerShop.getStock();
        if (stock.size() == 0) {
            System.out.println("No hay productos en esta floristería");
        } else {
            System.out.println("Estos son los productos disponibles:");
            showStock(flowerShop);
            flowerShop.getStock().remove(findProduct(flowerShop));
            System.out.println("Producto eliminado");
        }
    }

    public static Product findProduct(FlowerShop flowerShop) {
        Scanner sc = new Scanner(System.in);
        int index = -1;
        while (index < 0 || index > flowerShop.getStock().size()) {
            System.out.println("Escriba el número del producto deseado");
            index = sc.nextInt();
            if (index < 0 || index > flowerShop.getStock().size()) {
                System.out.println("El número no es correcto");
            }
        }
        return flowerShop.getStock().get(index);
    }

    public static void buyVoid(FlowerShop flowerShop, Ticket ticket) {
        Scanner sc = new Scanner(System.in);
        String yesNo = null;
        do {
            buyProduct(flowerShop, ticket);
            System.out.println("¿Quiere seguir comprando? (S/N)");
            yesNo = sc.nextLine().toUpperCase();
            while (!yesNo.equals("S") || !yesNo.equals("N")) {
                System.out.println("Comando incorrecto, introduzca S o N");
                yesNo = sc.nextLine().toUpperCase();
            }
        } while (yesNo.equals("S"));
    }

    public static void buyProduct(FlowerShop flowerShop, Ticket ticket) {
        ArrayList<Product> stock = flowerShop.getStock();
        if (stock.size() == 0) {
            System.out.println("No hay productos en esta floristería");
        } else {
            showStock(flowerShop);
            Product product = findProduct(flowerShop);
            ticket.getPurchase().add(product);
            flowerShop.getStock().remove(product);
            System.out.println("Producto comprado");
        }
    }



}