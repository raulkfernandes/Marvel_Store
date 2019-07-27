package br.com.phoebus.marvelstore.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import br.com.phoebus.marvelstore.R;

public class ComicDetailsActivity extends AppCompatActivity {

    int quantity = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Title: '+ getComicTitle()'");
        setContentView(R.layout.activity_comic_details);

        FloatingActionButton shoppingCartButton = findViewById(R.id.activity_comic_details_fab_shopping_cart);
        shoppingCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ComicDetailsActivity.this, ShoppingCartActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * This method increments the quantity on the screen.
     */
    public void increment(View view) {
        if (quantity == 20) {
            Toast.makeText(this, "You cannot add more than 20 comics in a single purchase.", Toast.LENGTH_SHORT).show();
            return;
        } else {
            quantity += 1;
            displayQuantity(quantity);
        }
    }

    /**
     * This method decrements the quantity on the screen.
     */
    public void decrement(View view) {
        if (quantity == 1) {
            Toast.makeText(this, "You must add at least one comic.", Toast.LENGTH_SHORT).show();
            return;
        } else {
            quantity -= 1;
            displayQuantity(quantity);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int quantity) {
        TextView quantityTextView = findViewById(R.id.activity_comic_details_quantity_text_view);
        quantityTextView.setText("" + quantity);
    }
}
