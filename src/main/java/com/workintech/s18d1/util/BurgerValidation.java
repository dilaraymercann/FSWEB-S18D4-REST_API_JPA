package com.workintech.s18d1.util;

import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.exceptions.BurgerErrorException;
import org.springframework.http.HttpStatus;

public class BurgerValidation {

    public static void validateId(long id) {
        if (id <= 0) {
            throw new BurgerErrorException("Id 0'dan büyük olmalıdır: " + id, HttpStatus.BAD_REQUEST);
        }
    }

    public static void validateBurger(Burger burger) {
        if (burger == null) {
            throw new BurgerErrorException("Burger boş olamaz!", HttpStatus.BAD_REQUEST);
        }
        if (burger.getName() == null || burger.getName().isBlank()) {
            throw new BurgerErrorException("Burger adı boş olamaz!", HttpStatus.BAD_REQUEST);
        }
    }

    public static void validatePrice(double price) {
        if (price < 0) {
            throw new BurgerErrorException("Fiyat 0'dan küçük olamaz!", HttpStatus.BAD_REQUEST);
        }
    }

    public static void validateContent(String content) {
        if (content == null || content.isBlank()) {
            throw new BurgerErrorException("İçerik boş olamaz!", HttpStatus.BAD_REQUEST);
        }
    }

    public static void validateBreadType(Object breadType) {
        if (breadType == null) {
            throw new BurgerErrorException("BreadType boş olamaz!", HttpStatus.BAD_REQUEST);
        }
    }
}
