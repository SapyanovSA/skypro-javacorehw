package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> products ;

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
        int sum = 0;

        for (List<Product> pr : products.values()) {
            for (Product current : pr) {
                sum += current.getPrice();
            }
        }
        return sum;
    }

    //Метод печатающий содержимое корзины
    public void printProductsAndAllCost() {
        int productIsSpecial = 0;

        if (products.isEmpty()) {
            System.out.println("Карзина пустая");
            return;
        }

        for (List<Product> current : products.values()) {
            for (Product pr : current) {
                System.out.println(pr);

                if (pr.isSpecial()) {
                    productIsSpecial++;
                }
            }
        }

        System.out.println("Итого: " + refundProductsCost());
        System.out.println("Специальный товар: " + productIsSpecial);
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
