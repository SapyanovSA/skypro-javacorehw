package org.skypro.skyshop.product;

public class Product {

    private String nameProduct;
    private int amountProduct;

    public Product(String nameProduct, int amountProduct) {
        this.nameProduct = nameProduct;
        this.amountProduct = amountProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public int getAmountProduct() {
        return amountProduct;
    }
}
