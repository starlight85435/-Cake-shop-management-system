package project;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;
public class CakeShopManagementSystem {
    private static String password = "123456";
    private static boolean checkPassword(String inputPassword) {
        return password.equals(inputPassword);
    }
    private static void changePassword(String newPassword) {
        password = newPassword;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CakeShop cakeshop = new CakeShop();
        OrderSystem orderSystem = new OrderSystem();
        boolean exit = false;
        while (!exit) {
            System.out.println("\n欢迎来到珂朵莉蛋糕店!");
            System.out.println("1. 进入消费者界面");
            System.out.println("2. 进入商家界面");
            System.out.println("3. 退出系统");
            try {
                System.out.print("请选择操作: ");
                if (scanner.hasNextInt()) {
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                            handleCustomerOperations(cakeshop, scanner, orderSystem);
                            break;
                        case 2:
                            System.out.print("请输入密码: ");
                            String inputPassword = scanner.nextLine();
                            if (checkPassword(inputPassword)) {
                                System.out.println("密码正确,进入商家界面");
                                handleMerchantOperations(cakeshop, scanner, orderSystem);
                            } else {
                                System.out.println("密码错误,返回主菜单...");
                                break;
                            }
                            break;
                        case 3:
                            exit = true;
                            System.out.println("正在退出系统...");
                            break;
                        default:
                            System.out.println("无效的选项!");
                            break;
                    }
                } else {
                    System.out.print("请输入选项前的整数!");
                    System.exit(0);
                }
            } catch (InputMismatchException e) {
                    System.out.print("请输入选项前的整数!");
            }
        }
        scanner.close();
    }
    private static void handleCustomerOperations(CakeShop cakeshop, Scanner scanner, OrderSystem orderSystem) {
        Customer customer = new Customer();
        boolean customerExit = false;
        while (!customerExit) {
            System.out.println("\n   消费者界面");
            System.out.println("1. 查看所有商品");
            System.out.println("2. 添加商品到购物车");
            System.out.println("3. 查看购物车");
            System.out.println("4. 查看购物车消费");
            System.out.println("5. 订购蛋糕");
            System.out.println("6. 返回主菜单");
            System.out.println("7. 退出系统");
            System.out.print("请选择操作: ");
            int customerChoice = scanner.nextInt();
            scanner.nextLine();
            switch (customerChoice) {
                case 1:
                    displayProducts(cakeshop.getAllProducts());
                    break;
                case 2:
                    displayProducts(cakeshop.getAllProducts());
                    System.out.print("请输入要添加到购物车的商品ID: ");
                    int productId2 = scanner.nextInt();
                    Product selectedProduct = cakeshop.getProductById(productId2);
                    if (selectedProduct != null) {
                        customer.addToCart(selectedProduct);
                        System.out.println(selectedProduct.getName() + " 已添加到购物车!");
                    } else {
                        System.out.println("无效的商品ID!");
                    }
                    break;
                case 3:
                    displayProducts(customer.getCart());
                    break;
                case 4:
                    System.out.println("总消费: " + customer.getTotalCost() + "元");
                    break;
                case 5:
                    displayProducts(cakeshop.getAllProducts());
                    System.out.print("请输入要订购的商品名: ");
                    String productName = scanner.nextLine();
                    System.out.print("请输入订购数量: ");
                    int number = scanner.nextInt();
                    System.out.print("请输入备注: ");
                    scanner.nextLine();
                    String remark = scanner.nextLine();
                    orderSystem.placeOrder(productName, number, remark);
                    break;
                case 6:
                    customerExit = true;
                    break;
                case 7:
                    System.out.println("正在退出系统...");
                    System.out.println("谢谢光临,再见!");
                    System.exit(0);
                    scanner.close();
                    break;
                default:
                    System.out.println("无效的选项!");
                    break;
            }
        }
    }
    private static void handleMerchantOperations (CakeShop cakeshop, Scanner scanner, OrderSystem orderSystem){
        boolean merchantExit = false;
        while (!merchantExit) {
            System.out.println("\n   商家界面");
            System.out.println("1. 查看所有商品");
            System.out.println("2. 添加商品");
            System.out.println("3. 删除商品");
            System.out.println("4. 修改商品价格");
            System.out.println("5. 修改商品库存");
            System.out.println("6. 销售商品");
            System.out.println("7. 查看顾客订单");
            System.out.println("8. 修改密码");
            System.out.println("9. 返回主菜单");
            System.out.println("0. 退出系统");
            System.out.print("请选择操作: ");
            int merchantChoice = scanner.nextInt();
            scanner.nextLine();
            switch (merchantChoice) {
                case 1:
                    displayProducts(cakeshop.getAllProducts());
                    break;
                case 2:
                    displayProducts(cakeshop.getAllProducts());
                    System.out.print("请输入商品ID: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("请输入商品名称: ");
                    String productName = scanner.nextLine();
                    System.out.print("请输入商品价格: ");
                    double productPrice = scanner.nextDouble();
                    System.out.print("请输入商品库存: ");
                    int productStock = scanner.nextInt();
                    cakeshop.addProduct(productId, productName, productPrice, productStock);
                    break;
                case 3:
                    displayProducts(cakeshop.getAllProducts());
                    System.out.print("请输入要删除的商品ID: ");
                    int deleteId = scanner.nextInt();
                    cakeshop.removeProduct(deleteId);
                    break;
                case 4:
                    displayProducts(cakeshop.getAllProducts());
                    System.out.print("请输入要修改价格的商品ID: ");
                    int updateId3 = scanner.nextInt();
                    System.out.print("请输入新的价格: ");
                    double newPrice = scanner.nextDouble();
                    cakeshop.updateProductPrice(updateId3, newPrice);
                    break;
                case 5:
                    displayProducts(cakeshop.getAllProducts());
                    System.out.print("请输入要修改库存的商品ID: ");
                    int updateId4 = scanner.nextInt();
                    System.out.print("请输入新的库存: ");
                    Integer newStock = scanner.nextInt();
                    cakeshop.updateProductStock(updateId4, newStock);
                    break;
                case 6:
                    displayProducts(cakeshop.getAllProducts());
                    System.out.print("请输入要售出的商品ID:");
                    int updateId6 = scanner.nextInt();
                    System.out.print("请输入售出数量:");
                    int nNumSale = scanner.nextInt();
                    cakeshop.sellProduct(updateId6, nNumSale);
                    break;
                case 7:
                    orderSystem.viewOrders();
                    break;
                case 8:
                    System.out.print("请输入旧密码: ");
                    String oldPassword = scanner.nextLine();
                    if (checkPassword(oldPassword)) {
                        System.out.print("请输入新密码: ");
                        String newPassword = scanner.nextLine();
                        changePassword(newPassword);
                        System.out.println("密码修改成功!");
                    } else {
                        System.out.println("旧密码错误,无法修改密码");
                    }
                    break;
                case 9:
                    merchantExit = true;
                    break;
                case 0:
                    System.out.println("正在退出系统...");
                    System.exit(0);
                    scanner.close();
                    break;
                default:
                    System.out.println("无效的选项！");
                    break;
            }
        }
    }
    private static void displayProducts (List < Product > products) {
        if (products == null || products.isEmpty()) {
            System.out.println("没有产品可显示。");
            return;
        }
        System.out.println("商品列表:");
        System.out.println("ID\t名称\t\t\t价格\t\t\t库存");
        for (Product product : products) {
            String name = product.getName();
            if (name.length() > 10) {
                name = name.substring(0, 10) + "...";
            }
            System.out.printf("%d\t%-10s%.2f元\t\t%d个%n",
                    product.getId(), name, product.getPrice(), product.getStock());
        }
    }
}