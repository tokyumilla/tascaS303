package exercici1n1.functionalities;

import exercici1n1.connection.Connection;
import exercici1n1.entities.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tool {
    private static Tool instance;

    private Tool (){}

    public static Tool getInstance(){
        if (instance==null) {
            instance = new Tool();
        }
        return instance;
    }
    private Connection connection = Connection.getInstance();

    public ArrayList<FlowerShop> readFile() {
        ArrayList<FlowerShop> flowerShops;
        try {
            flowerShops = connection.readFile();
        } catch (IOException e) {
            System.out.println("No había datos previos");
            flowerShops = new ArrayList<>();
        }
        return flowerShops;
    }

    public void createFlowerShop(ArrayList<FlowerShop> flowerShops) {
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
    public void writeFile(ArrayList<FlowerShop> flowershops) {
        connection.writeFile(flowershops);
    }
    public void showFlowerShops(ArrayList<FlowerShop> flowerShops) {
        for (FlowerShop fs : flowerShops) {
            System.out.println(fs.getName());
        }
    }

    public FlowerShop findFlowerShop(ArrayList<FlowerShop> flowerShops) {
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

    public void addProduct(FlowerShop flowerShop) {
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

    public Flower addFlower() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el nombre de la flor");
        String name = sc.nextLine().toLowerCase();
        System.out.println("Introduzca el color de la flor");
        String colour = sc.nextLine().toLowerCase();
        System.out.println("Introduzca el precio de la flor");
        double price = sc.nextDouble();
        return new Flower(name, colour, price);
    }

    public Tree addTree() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el nombre del árbol");
        String name = sc.nextLine().toLowerCase();
        System.out.println("Introduzca la altura del árbol");
        double height = sc.nextDouble();
        System.out.println("Introduzca el precio del árbol");
        double price = sc.nextDouble();
        return new Tree(name, height, price);
    }

    public Decoration addDeco() {
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

    public void showStock(FlowerShop flowerShop) {
        ArrayList<Product> stock = flowerShop.getStock();
        int index = 0;
        for (Product product : stock) {
            System.out.println(index + ". " + product.toString());
            index++;
        }
    }

    public void deleteProduct(FlowerShop flowerShop) {
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

    public Product findProduct(FlowerShop flowerShop) {
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

    public void buyVoid(FlowerShop flowerShop, Ticket ticket) {
        Scanner sc = new Scanner(System.in);
        String yesNo = null;
        do {
            buyProduct(flowerShop, ticket);
            System.out.println("¿Quiere seguir comprando? (S/N)");
            yesNo = sc.nextLine().toUpperCase();
            while (!yesNo.equals("S") && !yesNo.equals("N")) {
                System.out.println("Comando incorrecto, introduzca S o N");
                yesNo = sc.nextLine().toUpperCase();
            }
        } while (yesNo.equals("S"));
    }

    public void buyProduct(FlowerShop flowerShop, Ticket ticket) {
        ArrayList<Product> stock = flowerShop.getStock();
        if (stock.size() == 0) {
            System.out.println("No hay productos en esta floristería");
        } else {
            System.out.println("Estos son los productos disponibles");
            showStock(flowerShop);
            Product product = findProduct(flowerShop);
            ticket.getPurchase().add(product);
            flowerShop.getStock().remove(product);
            System.out.println("Producto comprado");
        }
    }





}
