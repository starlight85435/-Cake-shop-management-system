package project;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class CakeShop {
    public Map<Integer, Product> products;
    public List<Product> availableCakes;
    public List<Order> orders;
    public CakeShop() {
        this.products = new HashMap<>();
        this.availableCakes = new ArrayList<>();
        this.orders = new ArrayList<>();
        products.put(1, new Product(1, "黄油蛋糕", 26.0, 20));
        products.put(2, new Product(2, "草莓蛋糕", 18.0, 20));
        products.put(3, new Product(3, "提拉米苏", 14.0, 20));
        products.put(4, new Product(4, "布丁蛋糕", 20.0, 20));
        products.put(5, new Product(5, "慕斯蛋糕", 22.0, 20));
        products.put(6, new Product(6, "芝士蛋糕", 24.0, 20));
    }
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }
    public Product getProductById(int id) {
        return products.get(id);
    }
    public void addProduct(int id, String name, double price, int stock) {
        Product Product = new Product(id, name, price, stock);
        products.put(id, Product);
        System.out.println("商品添加成功!");
    }
    public void removeProduct(int id) {
        if (products.containsKey(id)) {
            products.remove(id);
            System.out.println("商品删除成功!");
        } else {
            System.out.println("找不到该商品!");
        }
    }
    public void updateProductPrice(int id, double newPrice) {
        if (products.containsKey(id)) {
            Product product = products.get(id);
            product.setPrice(newPrice);
            System.out.println("商品信息更新成功!");
        } else {
            System.out.println("找不到该商品!");
        }
    }
    public void updateProductStock(int id, Integer newStock) {
        if (products.containsKey(id)) {
            Product product = products.get(id);
            product.setStock(newStock);
            System.out.println("商品信息更新成功!");
        } else {
            System.out.println("找不到该商品!");
        }
    }
    public void sellProduct(int id, int quantity) {
        Product product = products.get(id);
        if (product != null && product.getStock() >= quantity) {
            product.setStock(product.getStock() - quantity);
            System.out.println("交易成功," + quantity + "个" + product.getName() + "已售出。");
        } else {
            System.out.println("交易失败: 商品不存在或库存不足");
        }
    }
}