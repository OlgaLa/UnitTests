package shop;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private static final double TAX = 0.2;
    private final String CART_NAME;
    private List<RealItem> realItems;
    private List<VirtualItem> virtualItems;
    private double total;

    public Cart(String cartName) {
        CART_NAME = cartName;
        realItems = new ArrayList<>();
        virtualItems = new ArrayList<>();
    }

    public String getCartName() {
        return CART_NAME;
    }

    public static  double getTax() { return TAX; }

    public void addRealItem(RealItem item) {
        realItems.add(item);
        total += item.getPrice() + item.getPrice()*TAX;
    }

    public void deleteRealItem(RealItem item) {
        realItems.remove(item);
    }

    public void addVirtualItem(VirtualItem item) {
        virtualItems.add(item);
        total += item.getPrice() + item.getPrice()*TAX;
    }

    public void deleteVirtualItem(VirtualItem item) {
        virtualItems.remove(item);
    }

    public void showItems() {
        for (RealItem item : realItems) {
            System.out.println(item);
        }
        for (VirtualItem item : virtualItems) {
            System.out.println(item);
        }
    }

    public double getTotalPrice() {
        return total;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getCartName().equals(((Cart)obj).getCartName()) && this.realItems.size() == ((Cart)obj).realItems.size() &&
                this.virtualItems.size() == ((Cart)obj).virtualItems.size() && this.realItems.containsAll(((Cart)obj).realItems)
                && this.virtualItems.containsAll(((Cart)obj).virtualItems) && this.getTotalPrice() == ((Cart)obj).getTotalPrice();
    }
}
