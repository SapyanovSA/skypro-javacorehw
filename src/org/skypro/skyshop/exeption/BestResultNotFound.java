package org.skypro.skyshop.exeption;

public class BestResultNotFound extends Exception {

    public BestResultNotFound(String message) {
        super("Для поискового запроса '" + message + "' не нашлось подходящего результата");
    }

}
