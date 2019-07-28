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

    private int quantity = 1;
    private ComicDAO dao = new ComicDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Comic Details");
        setContentView(R.layout.activity_comic_details);

        Button incrementButton = findViewById(R.id.activity_comic_details_increment_button);
        Button decrementButton = findViewById(R.id.activity_comic_details_decrement_button);

        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increment();
            }
        });

        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrement();
            }
        });

        Intent comicIntent = getIntent();
        final Comic comic = (Comic) comicIntent.getSerializableExtra("selectedComic");

        populateComicDetailsUI(comic);

        Button addToCartButton = findViewById(R.id.activity_comic_store_add_to_cart_button);
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ComicDetailsActivity.this, quantity + " Itens added to cart.", Toast.LENGTH_LONG).show();
                for(int i = 1; i <= quantity; i++) {
                    dao.addToCart(comic);
                }
                finish();
            }
        });
    }

    private void populateComicDetailsUI(Comic comic) {
        TextView title = findViewById(R.id.activity_comic_details_title);
        TextView publishedDate = findViewById(R.id.activity_comic_details_published);
        TextView price = findViewById(R.id.activity_comic_details_price);
        TextView writers = findViewById(R.id.activity_comic_details_writers);
        TextView pencilers = findViewById(R.id.activity_comic_details_pencilers);
        TextView coverArtists = findViewById(R.id.activity_comic_details_cover_artists);
        TextView description = findViewById(R.id.activity_comic_details_description);

        title.setText(comic.getTitle());
        publishedDate.setText(comic.getPublishedDate());
        price.setText(comic.getPrice());
        writers.setText(comic.getWriters());
        pencilers.setText(comic.getPencilers());
        coverArtists.setText(comic.getCoverArtists());
        description.setText(comic.getDescription());
    }

    /**
     * This method increments the quantity on the screen.
     */
    private void increment() {
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
    private void decrement() {
        if (quantity == 1) {
            Toast.makeText(this, "You must add at least one comic to your cart.", Toast.LENGTH_SHORT).show();
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
