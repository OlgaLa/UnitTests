package shop;

public class RealItem extends Item {

    private double weight;

    public RealItem(String name, double price, double weight) {
        super(name, price);
        this.weight = weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return super.toString() + "Weight: " + weight;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && this.getWeight() == ((RealItem)obj).getWeight();
    }
}
