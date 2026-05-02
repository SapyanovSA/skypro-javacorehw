package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {

    public static void main(String[] args) {
        System.out.println("Урок 1. ООП. Инкапсуляция");
        //Объявление объектов
        ProductBasket productBasket = new ProductBasket();
        Product product1 = new Product("Bread", 120);
        Product product2 = new Product("Cheese", 200);
        Product product3 = new Product("Kvass", 150);
        Product product4 = new Product("Meet", 400);
        Product product5 = new Product("Chocolate", 200);
        Product product6 = new Product("Oil", 180);
        //Задание 1 Добавить продукты
        System.out.println("Задание 1");
        productBasket.addProduct(product1);
        productBasket.addProduct(product2);
        productBasket.addProduct(product3);
        productBasket.addProduct(product4);
        productBasket.addProduct(product5);
        System.out.println();
        //Задание 2 Добавить продукты в заполненую корзину
        System.out.println("Задание 2");
        productBasket.addProduct(product6);
        System.out.println();
        //Задание 3 и 4 распечатать корзину и ее стоимость со всеми товарами
        System.out.println("Задание 3 и 4");
        productBasket.printProductsAndAllCost();
        System.out.println();
        //Задание 5 и 6 Поиск товаров которые есть в корзине и которого нет
        System.out.println("Задание 5 и 6");
        System.out.println(productBasket.findProduct("Bread"));
        System.out.println(productBasket.findProduct("Ice-cream"));
        System.out.println();
        //Задание 7 Очистка корзины
        System.out.println("Задание 7");
        productBasket.clearBasket();
        System.out.println();
        //Задание 8 и 9 и 10  Печать содержимого и получение стоимости, поиск товара
        System.out.println("Задание 8 и 9 и 10");
        productBasket.printProductsAndAllCost();
        System.out.println(productBasket.refundProductsCost());
        System.out.println(productBasket.findProduct("Bread"));
        System.out.println();

    }

}
