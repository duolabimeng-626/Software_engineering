package A1_4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {

    private LocalDate createDate;
    private OrderStatus status;
    private Customer customer;
    private List<OrderDetail> details = new ArrayList<>();
    private Payment payment; // 0..1

    public Order(Customer customer) {
        this.customer = customer;
        this.createDate = LocalDate.now();
        this.status = OrderStatus.CREATE;
        customer.addOrder(this);
    }

    public void addOrderDetail(OrderDetail detail) {
        if (detail != null) {
            details.add(detail);
        }
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<OrderDetail> getDetails() {
        return Collections.unmodifiableList(details);
    }
}
