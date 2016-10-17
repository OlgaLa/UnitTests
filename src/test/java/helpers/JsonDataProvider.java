package helpers;
import org.testng.annotations.DataProvider;

public class JsonDataProvider {

    @DataProvider(name = "userCart")
    private static Object[][] userCart() {
        return new Object[][] {
                new Object[] {"andrew-cart", "Audi", 32026.9, 1560, "Windows", 11, 20000},
                new Object[] {"olga-cart", "0000000", 123456.6, 1870, "Linix", 85, 15646},
                new Object[] {"kate-cart", "@#$%^&", 5, 5, "@#$%^&*", 5, 5},
                new Object[] {"!@#$-cart", " ", 0, 0, " ", 0, 0},
                new Object[] {"cart-cart", "", 65465.5, 4562, "MasOS", 56, 50000}
        };
    }

    @DataProvider(name = "realItem")
    private static Object[][] realItem() {
        return new Object[][] {
            new Object[] {"Audi", 32026.9, 1560}
        };
    }

    @DataProvider(name = "virtualItem")
    private static Object[][] virtualItem() {
        return new Object[][] {
                new Object[] {"Windows", 11, 20000}
        };
    }
}






