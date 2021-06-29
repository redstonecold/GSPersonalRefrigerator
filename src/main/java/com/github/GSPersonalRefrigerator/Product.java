package com.github.GSPersonalRefrigerator;

public class Product {
    private int num;
    private String productName;
    private int productPrice;
    private String purchaseDate;
    private String enableDate;
    private int extendNum;

    public Product() {

    }

    public Product(int num, String consumerName, String productName, int productPrice, String purchaseDate, String enableDate, int extendNum) {
        this.num = num;
        this.productName = productName;
        this.productPrice = productPrice;
        this.purchaseDate = purchaseDate;
        this.enableDate = enableDate;
        this.extendNum = extendNum;
    }

    public String tolist(){
        return this.num + " " + this.productName + " " + this.productPrice + " " + this.purchaseDate + " " + this.enableDate + " " + this.extendNum;
    }

    public int getNum() { return num; }

    public void setNum(int num) { this.num = num; }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getEnableDate() {
        return enableDate;
    }

    public void setEnableDate(String enableDate) {
        this.enableDate = enableDate;
    }

    public int getExtendNum() {
        return extendNum;
    }

    public void setExtendNum(int extendNum) {
        this.extendNum = extendNum;
    }



}
