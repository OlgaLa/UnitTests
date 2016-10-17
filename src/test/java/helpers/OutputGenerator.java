package helpers;

import shop.Cart;

/**
 * Created by olapanovich on 16.10.16.
 */
public class OutputGenerator {

    public String generateOutputReal(Object obj, String name, double price, double weight) {
        return String.format("Class: %s; Name: %s; Price: %s; Weight: %s", obj, name, price, weight);
    }

    public String generateOutputVirtial(Object obj, String name, double price, double sizeOnDisk) {
        return String.format("Class: %s; Name: %s; Price: %s; Size on disk: %s", obj, name, price, sizeOnDisk);
    }

    public double calculateTotalPrice(double realPrice, double virtPrice){

        return realPrice + virtPrice + (realPrice + virtPrice)* Cart.getTax();
    }


}
