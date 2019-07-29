package br.com.phoebus.marvelstore.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
    private int storeItemPosition = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Comic Details");
        setContentView(R.layout.activity_comic_details);

        Intent comicIntent = getIntent();

        incrementButtonBehaviour();
        decrementButtonBehaviour();

        final Comic comic = (Comic) comicIntent.getSerializableExtra("selectedComic");
        populateComicDetailsUI(comic);
        addToCartButtonBehaviour(comic);

        continueButtonBehaviour();

        SelectCoverImageLocally(comicIntent.getIntExtra("position", storeItemPosition));
    }

    private void continueButtonBehaviour() {
        Button continueShopping = findViewById(R.id.activity_comic_details_continue_shopping_button);
        continueShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void addToCartButtonBehaviour(final Comic comic) {
        Button addToCartButton = findViewById(R.id.activity_comic_store_add_to_cart_button);
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ComicDetailsActivity.this, quantity + " Itens added to cart.", Toast.LENGTH_LONG).show();
                for(int i = 1; i <= quantity; i++) {
                    dao.addToCart(comic);
                    dao.setStoreItemPosition(storeItemPosition);
                }
                finish();
            }
        });
    }

    private void decrementButtonBehaviour() {
        Button decrementButton = findViewById(R.id.activity_comic_details_decrement_button);
        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrement();
            }
        });
    }

    private void incrementButtonBehaviour() {
        Button incrementButton = findViewById(R.id.activity_comic_details_increment_button);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increment();
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

        if(comic.isRare()) {
            price.setText("$" + comic.getPrice() + " [Rare Comic]");
        }
        else {
            price.setText("$" + comic.getPrice());
        }

        writers.setText(comic.getWriters());
        pencilers.setText(comic.getPencilers());
        coverArtists.setText(comic.getCoverArtists());
        description.setText(comic.getDescription());
    }

    private void increment() {
        if (quantity == 20) {
            Toast.makeText(this, "You cannot add more than 20 comics in a single purchase.", Toast.LENGTH_SHORT).show();
            return;
        } else {
            quantity += 1;
            displayQuantity(quantity);
        }
    }

    private void decrement() {
        if (quantity == 1) {
            Toast.makeText(this, "You must add at least one comic to your cart.", Toast.LENGTH_SHORT).show();
            return;
        } else {
            quantity -= 1;
            displayQuantity(quantity);
        }
    }

    private void displayQuantity(int quantity) {
        TextView quantityTextView = findViewById(R.id.activity_comic_details_quantity_text_view);
        quantityTextView.setText("" + quantity);
    }

    private void SelectCoverImageLocally(int index) {

        ImageView image = findViewById(R.id.activity_comic_details_image);

        switch (index) {
            case 0:
                image.setImageResource(R.drawable.cover0);
                break;
            case 1:
                image.setImageResource(R.drawable.cover1);
                break;
            case 2:
                image.setImageResource(R.drawable.cover2);
                break;
            case 3:
                image.setImageResource(R.drawable.cover3);
                break;
            case 4:
                image.setImageResource(R.drawable.cover4);
                break;
            case 5:
                image.setImageResource(R.drawable.cover5);
                break;
            case 6:
                image.setImageResource(R.drawable.cover6);
                break;
            case 7:
                image.setImageResource(R.drawable.cover7);
                break;
            case 8:
                image.setImageResource(R.drawable.cover8);
                break;
            case 9:
                image.setImageResource(R.drawable.cover9);
                break;
            case 10:
                image.setImageResource(R.drawable.cover10);
                break;
            case 11:
                image.setImageResource(R.drawable.cover11);
                break;
            case 12:
                image.setImageResource(R.drawable.cover12);
                break;
            case 13:
                image.setImageResource(R.drawable.cover13);
                break;
            case 14:
                image.setImageResource(R.drawable.cover14);
                break;
            case 15:
                image.setImageResource(R.drawable.cover15);
                break;
            case 16:
                image.setImageResource(R.drawable.cover16);
                break;
            case 17:
                image.setImageResource(R.drawable.cover17);
                break;
            case 18:
                image.setImageResource(R.drawable.cover18);
                break;
            case 19:
                image.setImageResource(R.drawable.cover19);
                break;
        }
    }
}
