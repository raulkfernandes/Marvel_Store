package br.com.phoebus.marvelstore.dao;

import java.util.List;

import br.com.phoebus.marvelstore.model.Comic;
import br.com.phoebus.marvelstore.model.ShoppingCartSingleton;

public class ComicDAO {

    public static boolean hasCommonDiscountCoupon = false;
    public static boolean hasRareDiscountCoupon = false;
    public static float commonDiscount = 0.1f;
    public static float rareDiscount = 0.25f;
    private int storeItemPosition = 0;

    public int getStoreItemPosition() {
        return storeItemPosition;
    }

    public void setStoreItemPosition(int storeItemPosition) {
        this.storeItemPosition = storeItemPosition;
    }

    public boolean isCartEmpty() {
        return ShoppingCartSingleton.getInstance().isComicListEmpty();
    }

    public void addToCart(Comic comic) {
        ShoppingCartSingleton.getInstance().addComic(comic);
    }

    public void removeFromCart(int index) {
        ShoppingCartSingleton.getInstance().removeComic(index);
    }

    public List<Comic> getCartList() {
        return ShoppingCartSingleton.getInstance().getComicList();
    }

    public void clearCarList() {
        ShoppingCartSingleton.getInstance().clearComicList();
    }

    // Checking discount Coupon
    public String getTotalPrice() {
        double totalPrice = 0;
        List<Comic> comicList = getCartList();

        for (int i = 0; i < comicList.size(); i++) {
            totalPrice += comicList.get(i).getPriceDouble();
        }

        double discountUpdate = totalPrice;

        if(hasCommonDiscountCoupon) {
            discountUpdate -= discountUpdate * commonDiscount;
            return String.valueOf(discountUpdate);
        }
        else if(hasRareDiscountCoupon) {
            discountUpdate -= discountUpdate * rareDiscount;
            return String.valueOf(discountUpdate);
        }
        else {
            return String.valueOf(totalPrice);
        }
    }

    public void setDiscountCoupon(String discountCouponCheck) {
        if(discountCouponCheck == "common") {
            hasCommonDiscountCoupon = true;
            hasRareDiscountCoupon = false;
        } else if (discountCouponCheck == "rare") {
            hasCommonDiscountCoupon = false;
            hasRareDiscountCoupon = true;
        }
    }

    public void resetDiscountCoupon() {
        hasCommonDiscountCoupon = false;
        hasRareDiscountCoupon = false;
    }

    public boolean hasDiscountCouponApplied() {
        return hasCommonDiscountCoupon || hasRareDiscountCoupon;
    }
}
