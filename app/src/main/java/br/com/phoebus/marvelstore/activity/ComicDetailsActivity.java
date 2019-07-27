package br.com.phoebus.marvelstore.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import br.com.phoebus.marvelstore.R;
import br.com.phoebus.marvelstore.dao.ComicDAO;
import br.com.phoebus.marvelstore.model.Comic;

public class ComicDetailsActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Title: '+ getComicTitle()'");
        setContentView(R.layout.activity_comic_details);

        final Comic comic = new Comic("Spiderman", "9,99");

        Button addToCartButton = findViewById(R.id.activity_comic_store_add_to_cart_button);
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quantity == 0) {
                    Toast.makeText(ComicDetailsActivity.this, "You must add at least one item to the cart", Toast.LENGTH_SHORT).show();
                }
                else {
                    //Toast.makeText(ComicDetailsActivity.this, quantity + " Itens added to cart", Toast.LENGTH_LONG).show();
                    ComicDAO dao = new ComicDAO();

                    for(int i = 1; i <= quantity; i++) {
                        dao.addToCart(comic);
                    }

                    Toast.makeText(ComicDetailsActivity.this, dao.getCartList().toString(), Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
    }

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        finish();
//    }

    /**
     * This method increments the quantity on the screen.
     */
    public void increment(View view) {
        if (quantity == 20) {
            Toast.makeText(this, "You cannot add more than 20 comics in a single purchase", Toast.LENGTH_SHORT).show();
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
        if (quantity == 0) {
            Toast.makeText(this, "You must add at least one item to the cart", Toast.LENGTH_SHORT).show();
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
