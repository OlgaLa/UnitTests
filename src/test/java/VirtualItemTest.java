import helpers.JsonDataProvider;
import helpers.OutputGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;
import shop.VirtualItem;

/**
 * Created by olapanovich on 16.10.16.
 */
public class VirtualItemTest {

    OutputGenerator genOut = new OutputGenerator();

    @Test(dataProviderClass = JsonDataProvider.class, dataProvider = "virtualItem", groups = {"smoke", "item"})
    public void addVirtualItemTest(String name, double price, double sizeOnDisk) {
        VirtualItem virtualItem = new VirtualItem(name, price, sizeOnDisk);
        Assert.assertEquals(virtualItem.toString(), genOut.generateOutputVirtial(virtualItem.getClass(), name, price, sizeOnDisk));
    }

}
