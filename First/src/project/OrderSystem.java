package project;
import java.util.ArrayList;
import java.util.List;
class OrderSystem {
    public List<Order> orders = new ArrayList<>();

    public void placeOrder(String productName, int number, String remark) {
        Order order = new Order(productName, number, remark);
        orders.add(order);
        System.out.println("订单已下达:" + order);
    }
    public void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("当前无订单");
        } else {
            System.out.println("所有订单:");
            for (Order order : orders) {
                System.out.println(order);
            }
        }
    }
}