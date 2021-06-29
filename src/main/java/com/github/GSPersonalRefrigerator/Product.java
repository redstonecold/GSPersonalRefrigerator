package com.github.GSPersonalRefrigerator;

import java.util.UUID;

public class Product {
    private String productName;
    private int productPrice;
    private String purchaseDate;
    private String enableDate;
    private int extendNum;
    private String productRegNum;

    public Product() {

    }

    public Product(String consumerName, String productName, int productPrice, String purchaseDate, String enableDate, int extendNum) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.purchaseDate = purchaseDate;
        this.enableDate = enableDate;
        this.extendNum = extendNum;
        this.productRegNum = productRegNum;
    }

    public String tolist(){
        return this.productName + " " + this.productPrice + " " + this.purchaseDate + " " + this.enableDate + " " + this.extendNum + " " + productRegNum;
    }

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

    public String getProductRegNum() {
        return productRegNum;
    }

    public void setProductRegNum(String uuid) {
        productRegNum = uuid;
    }
}
