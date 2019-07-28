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

//    public void removeFromCart(int index) {
//        ShoppingCartSingleton.getInstante().removeComic(index);
//    }

    public List<Comic> getCartList() {
        return ShoppingCartSingleton.getInstante().getComicList();
    }

    public void clearCarList() {
        ShoppingCartSingleton.getInstante().clearComicList();
    }

    public String getTotalPrice() {
        double totalPrice = 0;
        List<Comic> comicList = getCartList();

        for(int i = 0; i < comicList.size(); i++) {
            totalPrice += comicList.get(i).getPriceDouble();
        }
        return String.valueOf(totalPrice);
    }
}
