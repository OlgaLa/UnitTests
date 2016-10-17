import helpers.JsonDataProvider;
import helpers.OutputGenerator;
import org.testng.Assert;
import org.testng.annotations.*;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

/**
 * Created by olapanovich on 16.10.16.
 */
public class CartTest {

    @Test(dataProviderClass = JsonDataProvider.class, dataProvider = "userCart", groups = {"smoke", "cart"})
    public void addRealItemToCartTest(String userName, String realName, double realPrice, double realWeight, String virtName, double virtPrice, double sizeOnDisk) {
        Cart userCart= new Cart(userName);
        OutputGenerator totalPrice = new OutputGenerator();

        RealItem realItem = new RealItem(realName, realPrice, realWeight);
        VirtualItem virtualItem = new VirtualItem(virtName, virtPrice, sizeOnDisk);
        userCart.addRealItem(realItem);
        userCart.addVirtualItem(virtualItem);

        Assert.assertEquals(userCart.getTotalPrice(), totalPrice.calculateTotalPrice(realPrice, virtPrice));
    }

}


