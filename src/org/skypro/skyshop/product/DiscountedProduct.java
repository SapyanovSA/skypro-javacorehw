package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int price;
    private int discount;

    public DiscountedProduct(String name, int price, int discount) {
        super(name);
        this.price = price;
        if (discount > 0 && discount < 100) {
            this.discount = discount;
        } else {
            throw new IllegalArgumentException("Введите корректную скидку от 1 до 100");
        }
    }

    @Override
    public int getPrice() {
        return  price - (price * discount / 100);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + discount + "%)";
    }
}
