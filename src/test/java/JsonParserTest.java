import helpers.JsonDataProvider;
import helpers.OutputGenerator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import parser.*;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import java.io.*;

/**
 * Created by olapanovich on 16.10.16.
 */

public class JsonParserTest {

    JsonParser parser = new JsonParser();

    @Test(dataProviderClass = JsonDataProvider.class, dataProvider = "userCart", groups = {"smoke", "parser"})
    public void writeJsonTest(String userName, String realName, double realPrice, double realWeight,
                              String virtName, double virtPrice, double sizeOnDisk) {

        Cart cartJson = new Cart(userName);

        RealItem car = new RealItem(realName, realPrice, realWeight);
        VirtualItem disk = new VirtualItem(virtName, virtPrice, sizeOnDisk);

        cartJson.addRealItem(car);
        cartJson.addVirtualItem(disk);

        parser.writeToFile(cartJson);

        File file = new File("src/main/resources/" + cartJson.getCartName() + ".json");
        Assert.assertTrue(file.exists());

    }


    @Test(dataProviderClass = JsonDataProvider.class, dataProvider = "userCart", groups = {"smoke", "parser"})
    public void readFromJsonTest(String userName, String realName, double realPrice, double realWeight,
                                 String virtName, double virtPrice, double sizeOnDisk) {

        Cart cartJson = new Cart(userName);
        OutputGenerator genOut = new OutputGenerator();

        RealItem car = new RealItem(realName, realPrice, realWeight);
        VirtualItem disk = new VirtualItem(virtName, virtPrice, sizeOnDisk);
        cartJson.addRealItem(car);
        cartJson.addVirtualItem(disk);
        parser.writeToFile(cartJson);

        Cart userCart = parser.readFromFile(new File("src/main/resources/" + cartJson.getCartName() + ".json"));

        Assert.assertTrue(cartJson.equals(userCart));

    }

    @Test(expectedExceptions = parser.FileNotFoundException.class, expectedExceptionsMessageRegExp = "File 123.json not found!",  groups = {"smoke", "parser"})
    public void fileNotFoundExceptionTest() {

        parser.readFromFile(new File("123"));
    }

    @AfterMethod
    public void deleteFiles() {
        File resourceDir = new File("src/main/resources/");
        for(File file: resourceDir.listFiles())
            if (!file.isDirectory())
                file.delete();
    }

}
