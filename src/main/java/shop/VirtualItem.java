package shop;

public class VirtualItem extends Item {

    private double sizeOnDisk;

    public VirtualItem(String name, double price, double sizeOnDisk) {
        super(name, price);
        this.sizeOnDisk = sizeOnDisk;
    }

    public void setSizeOnDisk(double sizeOnDisk) {
        this.sizeOnDisk = sizeOnDisk;
    }

    public double getSizeOnDisk() {
        return this.sizeOnDisk;
    }

    @Override
    public String toString() {
        return super.toString() + "Size on disk: " + sizeOnDisk;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && this.sizeOnDisk == ((VirtualItem)obj).getSizeOnDisk();
    }
}
