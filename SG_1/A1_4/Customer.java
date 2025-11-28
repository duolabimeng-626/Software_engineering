package A1_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer {

    private String name;
    private String contact;
    private String deliveryAddress;
    private boolean active;

    private List<Order> orders = new ArrayList<>();

    public Customer(String name, String contact, String deliveryAddress, boolean active) {
        this.name = name;
        this.contact = contact;
        this.deliveryAddress = deliveryAddress;
        this.active = active;
    }

    public void addOrder(Order order) {
        if (order != null) {
            orders.add(order);
        }
    }

    public List<Order> getOrders() {
        return Collections.unmodifiableList(orders);
    }
}
