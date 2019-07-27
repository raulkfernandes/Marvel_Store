package br.com.phoebus.marvelstore.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import br.com.phoebus.marvelstore.R;
import br.com.phoebus.marvelstore.adapter.ComicStoreAdapter;
import br.com.phoebus.marvelstore.model.Comic;

public class ComicStoreActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Comics Store");
        setContentView(R.layout.activity_comic_store);

        FloatingActionButton shoppingCartButton = findViewById(R.id.activity_comic_store_fab_shopping_cart);
        shoppingCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ComicStoreActivity.this, ShoppingCartActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        List<Comic> comicStoreList = new ArrayList<>();

        Comic firstComic = new Comic("X-Men", "9.99");
        Comic secComic = new Comic("X-Men 2", "19.99");
        Comic thirdComic = new Comic("X-Men 3", "29.99");

        comicStoreList.add(firstComic);
        comicStoreList.add(secComic);
        comicStoreList.add(thirdComic);

        ComicStoreAdapter mAdapter = new ComicStoreAdapter(this, comicStoreList);

        ListView comicsList = findViewById(R.id.activity_comic_store_list_view);
        comicsList.setAdapter(mAdapter);
    }
}
