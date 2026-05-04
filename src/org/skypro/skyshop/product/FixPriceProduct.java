package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIX_PRISE_PRODUCT = 100;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getPrice() {
        return FIX_PRISE_PRODUCT;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " фиксированная цена равна " + FIX_PRISE_PRODUCT;
    }
}
