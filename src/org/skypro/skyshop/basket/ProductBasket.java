package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.sql.SQLOutput;
import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> products;

    public ProductBasket() {
        this.products = new HashMap<>();
    }

    //Метод добавления продукта в корзину
    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);

        System.out.println(product.getName() + " добавлен в корзину.");
    }

    //Метод получения общей стоимости продукции
    public int refundProductsCost() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    //Метод печатающий содержимое корзины
    public void printProductsAndAllCost() {
        products.values().stream()
                .flatMap(Collection::stream)
                .forEach(product -> System.out.println(product.getStringRepresentation()));


        System.out.println("Итого: " + refundProductsCost());
        System.out.println("Специальный товар: " + getSpecialCount());
    }

    private int getSpecialCount() {
        return (int) products.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    //Метод проверяющий продукт в корзине по имени
    public boolean findProduct(String name) {

        return products.containsKey(name);
    }

    public List<Product> removeProduct(String name) {
        List<Product> removed = products.remove(name);

        if (removed != null) {
            return removed;
        } else {
            return new ArrayList<>();
        }
    }

    //Метод очистки корзины
    public void clearBasket() {

        products.clear();
        System.out.println("Корзина очищена.");

    }
}
