package br.com.phoebus.marvelstore;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import br.com.phoebus.marvelstore.model.ShoppingCart;

public class ShoppingCartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Shopping Cart");
        setContentView(R.layout.activity_shopping_cart);

        Button checkoutButton = (Button) findViewById(R.id.checkout_button);
        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ShoppingCartActivity.this, "checkout", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
