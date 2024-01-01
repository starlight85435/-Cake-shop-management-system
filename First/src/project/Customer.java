package project;
import java.util.ArrayList;
import java.util.List;
class Customer {
    public List<Product> cart;
    private double totalCost;
    public Customer() {
        this.cart = new ArrayList<>();
        this.totalCost = 0.0;
    }
    public void addToCart(Product product) {
        cart.add(product);
        totalCost += product.getPrice();
    }
    public List<Product> getCart() {
        return cart;
    }
    public double getTotalCost() {
        return totalCost;
    }
}