package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] products;
    private int size;

    public ProductBasket() {
        this.products = new Product[5];
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    //Метод добавления продукта в корзину
    public void addProduct(Product product) {
        if (size >= products.length) {
            System.out.println("Невозможно добавить продукт: " + product.getName() + ". Корзина полная.");
            return;
        }
        products[size] = product;
        size++;
        System.out.println(product.getName() + " добавлен в корзину.");
    }

    //Метод получения общей стоимости продукции
    public int refundProductsCost() {
        int sum = 0;
        for (int index = 0; index < size; index++) {
            if (products[index] != null) {
                sum += products[index].getPrice();
            }
        }
        return sum;
    }

    //Метод печатающий содержимое корзины
    public void printProductsAndAllCost() {
        int productIsSpecial = 0;
        if (size == 0) {
            System.out.println("В корзине пусто.");
            return;
        }
        for (int index = 0; index < size; index++) {

            if (products[index] != null) {
                System.out.println(products[index]);
            }

            if (products[index].isSpecial() == true) {
                productIsSpecial++;
            }
        }
        System.out.println("Итого: " + refundProductsCost());
        System.out.println("Специальный товар: " + productIsSpecial);
    }

    //Метод проверяющий продукт в корзине по имени
    public boolean findProduct(String name) {
        for (int index = 0; index < size; index++) {
            if (products[index] != null && products[index].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    //Метод очистки корзины
    public void clearBasket() {
        for (int index = 0; index < products.length; index++) {
            if (products[index] != null) {
                products[index] = null;
            }
        }
        size = 0;
        System.out.println("Корзина очищена.");
    }
}
