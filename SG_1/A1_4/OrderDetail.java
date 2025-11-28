package A1_4;

public class OrderDetail {

    private int quantity;
    private Product product;

    public OrderDetail(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double calculateSubTotal() {
        return product.getPriceForQuantity(quantity);
    }

    public double calculateWeight() {
        return product.getWeight() * quantity;
    }
}
