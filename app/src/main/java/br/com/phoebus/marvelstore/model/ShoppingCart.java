package br.com.phoebus.marvelstore.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private static List<Comic> staticShoppingCartList = new ArrayList<>();

    public static void setComicIntoCart(Comic comic) {
        staticShoppingCartList.add(comic);
    }

    public static Comic getComicFromCart(int i) {
        return staticShoppingCartList.get(i);
    }
}
