package project;
class Order {
    public String productName;
    public int number;
    public String remark;
    public Order(String productName, int number, String remark) {
        this.productName = productName;
        this.number = number;
        this.remark = remark;
    }
    @Override
    public String toString() {
        if(remark != null && !remark.isEmpty()){
            return "订单详情: 商品名: " + productName + ", 数量: " + number + ", 备注: " + " ( " + remark + " ) " ;
        } else{
            return "订单详情: 商品名: " + productName + ", 数量: " + number + ", 备注: 无!" ;
        }
    }
}