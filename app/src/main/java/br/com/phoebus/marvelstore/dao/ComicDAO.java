package br.com.phoebus.marvelstore.dao;

import java.util.List;

import br.com.phoebus.marvelstore.model.Comic;
import br.com.phoebus.marvelstore.model.ShoppingCartSingleton;

public class ComicDAO {

    public boolean isCartEmpty() {
        return ShoppingCartSingleton.getInstante().isEmpty();
    }

    public void addToCart(Comic comic) {
        ShoppingCartSingleton.getInstante().addComic(comic);
    }

    public void addFirstItens() {
        Comic firstComic = new Comic("X-Men", "9.99");
        Comic secComic = new Comic("X-Men 2", "19.99");
        Comic thirdComic = new Comic("X-Men 3", "29.99");

        addToCart(firstComic);
        addToCart(secComic);
        addToCart(thirdComic);
    }

    public void removeFromCart(int index) {
        ShoppingCartSingleton.getInstante().removeComic(index);
    }

    public List<Comic> getCartList() {
        return ShoppingCartSingleton.getInstante().getComicList();
    }
}
