package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {

    public static void main(String[] args) {
        System.out.println("Урок 1. ООП. Инкапсуляция");
        //Объявление объектов
        ProductBasket productBasket = new ProductBasket();
        SimpleProduct product1 = new SimpleProduct("Bread", 120);
        SimpleProduct product2 = new SimpleProduct("Cheese", 200);
        SimpleProduct product3 = new SimpleProduct("Kvass", 150);
        SimpleProduct product4 = new SimpleProduct("Meet", 400);
        SimpleProduct product5 = new SimpleProduct("Chocolate", 200);
        SimpleProduct product6 = new SimpleProduct("Oil", 180);
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

        System.out.println("Урок 2. ООП. Наследование");
        System.out.println("Задание 1");
        //Объявление объектов
        ProductBasket productBasket2 = new ProductBasket();
        SimpleProduct simpleProduct1 = new SimpleProduct("Bread", 100);
        DiscountedProduct discountedProduct1 = new DiscountedProduct("Ice-cream", 200, 20);
        FixPriceProduct fixPriceProduct1 = new FixPriceProduct("Milk");
        DiscountedProduct discountedProduct2 = new DiscountedProduct("Eggs", 100, 10);
        SimpleProduct simpleProduct2 = new SimpleProduct("Kvass", 150);
        //Добавление в массив
        productBasket2.addProduct(simpleProduct1);
        productBasket2.addProduct(discountedProduct1);
        productBasket2.addProduct(fixPriceProduct1);
        productBasket2.addProduct(discountedProduct2);
        productBasket2.addProduct(simpleProduct2);
        System.out.println("Задание 2");
        //Проверка работы всех методов
        System.out.println("Метод 1");
        System.out.println(productBasket2.refundProductsCost());
        System.out.println();
        System.out.println("Метод 2");
        productBasket2.printProductsAndAllCost();
        System.out.println();
        System.out.println("Метод 3");
        System.out.println("productBasket2.findProduct(\"Eggs\") = " + productBasket2.findProduct("Eggs"));
        System.out.println();
        System.out.println("Метод 4");
        productBasket2.clearBasket();
        System.out.println();
    }

}
