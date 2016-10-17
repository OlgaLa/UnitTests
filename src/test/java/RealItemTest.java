import helpers.JsonDataProvider;
import helpers.OutputGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;
import shop.RealItem;

/**
 * Created by olapanovich on 16.10.16.
 */
public class RealItemTest {

    OutputGenerator genOut = new OutputGenerator();

    @Test(dataProviderClass = JsonDataProvider.class, dataProvider = "realItem", groups = {"smoke", "item"})
    public void addRealItemTest(String name, double price, double weight) {
        RealItem realItem = new RealItem(name, price, weight);
        Assert.assertEquals(realItem.toString(), genOut.generateOutputReal(realItem.getClass(), name, price, weight));
    }
}


