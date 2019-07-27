package br.com.phoebus.marvelstore.model;

import java.util.ArrayList;
import java.util.List;

/**
 *  Singleton Pattern to manage one Shopping Cart single instance
 */
public class ShoppingCartSingleton {

    private static ShoppingCartSingleton instance;
    private static List<Comic> shoppingCartList;

    private ShoppingCartSingleton() {}

    public static ShoppingCartSingleton getInstante() {
        if(instance == null) {
            instance = new ShoppingCartSingleton();
        }

        return instance;
    }

    public boolean isEmpty() {
        return shoppingCartList.isEmpty();
    }

    public void addComic(Comic comic) {
        if(shoppingCartList == null) {
            shoppingCartList = new ArrayList();
        }
        shoppingCartList.add(comic);
    }

    public List<Comic> getComicList() {
        if(shoppingCartList == null) {
            shoppingCartList = new ArrayList();
        }
        return shoppingCartList;
    }

    public void removeComic(int index) {
        if(shoppingCartList != null) {
            shoppingCartList.remove(index);
        }
    }
}
