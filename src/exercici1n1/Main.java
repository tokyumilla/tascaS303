package exercici1n1;

import exercici1n1.connection.Connection;
import exercici1n1.entities.Flower;
import exercici1n1.entities.FlowerShop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        int option;
        Scanner sc = new Scanner(System.in);
        ArrayList<FlowerShop> flowerShops;
        flowerShops= readFile();


        do {
            System.out.println("Introduzca una opción (0-5): ");
            System.out.println("0. Cerrar el programa");
            System.out.println("1. Crear una floristería nueva");
            System.out.println("2. Mostrar floristerías");
            System.out.println("3. Añadir producto");
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
        boolean found = false;
        for (FlowerShop fs : flowerShops) {
            if (fs.getName().equals(name)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("La floristería" + name + "ya existe");
        } else {
            FlowerShop flowerShop = new FlowerShop(name);
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

    public static void addProduct () {
        int option;
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Qué producto quiere añadir?(1-3)");
        System.out.println("1. Flor \n 2. Árbol \n 3. Decoración");
        option = sc.nextInt();
        switch (option) {
            case 1:

        }
    }
    public static Flower addFlower () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el nombre de la flor");
        String name = sc.nextLine().toLowerCase();
        System.out.println("Introduzca el color de la flor");
        String colour = sc.nextLine().toLowerCase();
        System.out.println("Introduzca el precio de la flor");
        Double price = sc.nextDouble();
        Flower flower = new Flower (name, colour,price);
        return flower;
    }

}