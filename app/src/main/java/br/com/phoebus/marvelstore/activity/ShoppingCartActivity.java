package br.com.phoebus.marvelstore.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import br.com.phoebus.marvelstore.R;
import br.com.phoebus.marvelstore.adapter.ShoppingCartAdapter;
import br.com.phoebus.marvelstore.dao.ComicDAO;

public class ShoppingCartActivity extends AppCompatActivity {

    ComicDAO dao = new ComicDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Shopping Cart");
        setContentView(R.layout.activity_shopping_cart);

        Button checkoutButton = findViewById(R.id.activity_shopping_cart_checkout_button);
        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dao.isCartEmpty()) {
                    Toast.makeText(ShoppingCartActivity.this, "You must add at least one comic for your purchase.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(ShoppingCartActivity.this, "Checkout Successful.", Toast.LENGTH_SHORT).show();
                    dao.clearCarList();
                    finish();
                }
            }
        });

        TextView totalPrice = findViewById(R.id.activity_shopping_cart_total_price_text_view);
        totalPrice.setText(dao.getTotalPrice());

        ShoppingCartAdapter mAdapter = new ShoppingCartAdapter(this, dao);
        ListView shoppingCartListView = findViewById(R.id.activity_shopping_cart_list_view);
        shoppingCartListView.setAdapter(mAdapter);
    }
}
