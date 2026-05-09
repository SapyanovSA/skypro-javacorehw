package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private List<Product> products;

    public ProductBasket() {
        this.products = new LinkedList<>();
    }

    //Метод добавления продукта в корзину
    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.getName() + " добавлен в корзину.");
    }

    //Метод получения общей стоимости продукции
    public int refundProductsCost() {
        int sum = 0;
        for (Product pr : products) {
            if (pr == null) {
                continue;
            }
            sum += pr.getPrice();
        }
        return sum;
    }

    //Метод печатающий содержимое корзины
    public void printProductsAndAllCost() {
        int productIsSpecial = 0;

        if (products.size() == 0) {
            System.out.println("Карзина пустая");
            return;
        }

        for (Product pr : products) {
            System.out.println(pr);

            if (pr.isSpecial()) {
                productIsSpecial++;
            }
        }

        System.out.println("Итого: " + refundProductsCost());
        System.out.println("Специальный товар: " + productIsSpecial);
    }

    //Метод проверяющий продукт в корзине по имени
    public boolean findProduct(String name) {

        for (Product pr : products) {
            if (pr.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    public List<Product> removeProduct(String name) {
        List<Product> deletedProduct = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {

            Product currentProduct = iterator.next();

            if (currentProduct.getName().equals(name)) {
                deletedProduct.add(currentProduct);
                iterator.remove();
            }
        }

        return deletedProduct;
    }

    //Метод очистки корзины
    public void clearBasket() {

        products.clear();
        System.out.println("Корзина очищена.");

    }
}
