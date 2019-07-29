package br.com.phoebus.marvelstore.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

import br.com.phoebus.marvelstore.R;
import br.com.phoebus.marvelstore.adapter.ShoppingCartAdapter;
import br.com.phoebus.marvelstore.dao.ComicDAO;

public class ShoppingCartActivity extends AppCompatActivity {

    private ComicDAO dao = new ComicDAO();
    private final DecimalFormat df = new DecimalFormat("#0.00");
    private static final String DISCOUNT_COUPON_COMMON = "IRONMAN";
    private static final String DISCOUNT_COUPON_RARE = "BLACKWIDOW";
    private static String DISCOUNT_COUPON_APPLIED = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Shopping Cart");
        setContentView(R.layout.activity_shopping_cart);

        final TextView totalPrice = totalPriceBehaviour();

        applyDiscountBehaviour(totalPrice);

        checkoutButtonBehaviour();

        continueShoppingButtonBehaviour();
    }

    private TextView totalPriceBehaviour() {
        final TextView totalPrice = findViewById(R.id.activity_shopping_cart_total_price_text_view);
        final double doublePrice = Double.valueOf(dao.getTotalPrice());
        totalPrice.setText(df.format(doublePrice));

        ShoppingCartAdapter mAdapter = new ShoppingCartAdapter(this, dao);
        ListView shoppingCartListView = findViewById(R.id.activity_shopping_cart_list_view);
        shoppingCartListView.setAdapter(mAdapter);
        return totalPrice;
    }

    private void applyDiscountBehaviour(final TextView totalPrice) {
        final EditText discountCouponEditText = findViewById(R.id.activity_shopping_cart_discount_coupon_edit_text);

        if(dao.hasDiscountCouponApplied()) {
            discountCouponEditText.setText(DISCOUNT_COUPON_APPLIED);
            discountCouponEditText.setEnabled(false);
        }

        Button applyDiscountCouponButton = findViewById(R.id.activity_shopping_cart_apply_discount_coupon_button);
        applyDiscountCouponButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String discountCoupon = discountCouponEditText.getText().toString();

                if(discountCoupon.equals(DISCOUNT_COUPON_COMMON)) {
                    Toast.makeText(ShoppingCartActivity.this, "Common Coupon Applied.", Toast.LENGTH_SHORT).show();
                    dao.setDiscountCoupon("common");
                    DISCOUNT_COUPON_APPLIED = DISCOUNT_COUPON_COMMON;
                    discountCouponEditText.setEnabled(false);
                    double commonDiscountPrice = Double.valueOf(dao.getTotalPrice());
                    totalPrice.setText(df.format(commonDiscountPrice));
                }

                else if(discountCoupon.equals(DISCOUNT_COUPON_RARE)) {
                    Toast.makeText(ShoppingCartActivity.this, "Rare Discount Coupon Applied.", Toast.LENGTH_SHORT).show();
                    dao.setDiscountCoupon("rare");
                    DISCOUNT_COUPON_APPLIED = DISCOUNT_COUPON_RARE;
                    discountCouponEditText.setEnabled(false);
                    double rareDiscountPrice = Double.valueOf(dao.getTotalPrice());
                    totalPrice.setText(df.format(rareDiscountPrice));

                } else {
                    Toast.makeText(ShoppingCartActivity.this, "Invalid Discount Coupon.", Toast.LENGTH_SHORT).show();
                    DISCOUNT_COUPON_APPLIED = "";
                }
            }
        });
    }

    private void continueShoppingButtonBehaviour() {
        Button continueShoppingButton = findViewById(R.id.activity_shopping_cart_continue_shopping_button);
        continueShoppingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void checkoutButtonBehaviour() {
        Button checkoutButton = findViewById(R.id.activity_shopping_cart_checkout_button);
        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dao.isCartEmpty()) {
                    Toast.makeText(ShoppingCartActivity.this, "You must add at least one comic for your purchase.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(ShoppingCartActivity.this, "Checkout Successful.", Toast.LENGTH_SHORT).show();
                    DISCOUNT_COUPON_APPLIED = "";
                    dao.resetDiscountCoupon();
                    dao.clearCarList();
                    finish();
                }
            }
        });
    }
}
