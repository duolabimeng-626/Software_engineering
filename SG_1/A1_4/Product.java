package A1_4;

public class Product {

    private String title;
    private double weight;
    private String description;
    private double unitPrice;

    public Product(String title, double weight, String description, double unitPrice) {
        this.title = title;
        this.weight = weight;
        this.description = description;
        this.unitPrice = unitPrice;
    }

    public double getPriceForQuantity(int qty) {
        return unitPrice * qty;
    }

    public double getWeight() {
        return weight;
    }
}
