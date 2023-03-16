package exercici1n1.functionalities;

import exercici1n1.connection.Connection;
import exercici1n1.entities.FlowerShop;

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




}
