import parser.JsonParser;
import shop.*;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Cart andrewCart = new Cart("andrew-cart");

        RealItem car = new RealItem("Audi", 32026.9, 1560);

        VirtualItem disk = new VirtualItem("Windows", 11, 2000);

        andrewCart.addRealItem(car);
        andrewCart.addVirtualItem(disk);
        //andrewCart.showItems();

        JsonParser parser = new JsonParser();
        parser.writeToFile(andrewCart);

        Cart eugenCart = parser.readFromFile(new File("src/main/resources/eugen-cart.json"));
        //eugenCart.showItems();
        System.out.println(eugenCart);
    }
}
