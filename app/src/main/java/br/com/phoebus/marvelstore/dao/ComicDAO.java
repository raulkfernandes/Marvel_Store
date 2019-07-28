package br.com.phoebus.marvelstore.dao;

import java.util.List;

import br.com.phoebus.marvelstore.model.Comic;
import br.com.phoebus.marvelstore.model.ShoppingCartSingleton;

public class ComicDAO {

    public boolean isCartEmpty() {
        return ShoppingCartSingleton.getInstante().isComicListEmpty();
    }

    public void addToCart(Comic comic) {
        ShoppingCartSingleton.getInstante().addComic(comic);
    }

    public void removeFromCart(int index) {
        ShoppingCartSingleton.getInstante().removeComic(index);
    }

    public List<Comic> getCartList() {
        return ShoppingCartSingleton.getInstante().getComicList();
    }

    public void clearCarList() {
        ShoppingCartSingleton.getInstante().clearComicList();
    }
}
