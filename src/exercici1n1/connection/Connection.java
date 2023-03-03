package exercici1n1.connection;

import exercici1n1.entities.FlowerShop;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;

public class Connection {
    private static Connection instance;
    private Connection (){}
    public static Connection getInstance(){
        if (instance==null) {
            instance =new Connection();
        }
        return instance;
    }
    FileOutputStream fileOut = null;
    ObjectOutputStream outStream = null;
    FileInputStream fileIn = null;
    ObjectInputStream inStream = null;

    public void writeFile (ArrayList<FlowerShop> data) {
        try {
            fileOut = new FileOutputStream("floristerias");

            outStream = new ObjectOutputStream(fileOut);

            outStream.writeObject(data);

            outStream.close();
            fileOut.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<FlowerShop> readFile () throws IOException{
        ArrayList<FlowerShop> data = null;
        try {
            fileIn= new FileInputStream("floristerias");
            inStream = new ObjectInputStream(fileIn);

            data= (ArrayList<FlowerShop>) inStream.readObject();
            inStream.close();
            fileIn.close();
        }  catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        return data;
    }
}
