package shop;

public class Item {

    private String name;
    private double price;

    public Item(String name, double price){
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return String.format("Class: %s; Name: %s; Price: %s; ", getClass(), name, price);
    }

    @Override
    public boolean equals(Object obj) {
        return (this.getName().equals(((Item)obj).getName()) && this.getPrice() == ((Item)obj).getPrice());
    }
}
