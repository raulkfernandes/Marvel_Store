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
import br.com.phoebus.marvelstore.adapter.ComicAdapter;
import br.com.phoebus.marvelstore.model.Comic;

public class ComicListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Comics Store");
        setContentView(R.layout.activity_comic_list);

        FloatingActionButton shoppingCartButton = (FloatingActionButton) findViewById(R.id.activity_comics_list_fab_shopping_cart);
        shoppingCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ComicListActivity.this, ShoppingCartActivity.class);
                startActivity(intent);
            }
        });

        List<Comic> comicList = new ArrayList<>();

        Comic firstComic = new Comic("X-Men", "9.99");
        Comic secComic = new Comic("X-Men 2", "19.99");
        Comic thirdComic = new Comic("X-Men 3", "29.99");

        comicList.add(firstComic);
        comicList.add(secComic);
        comicList.add(thirdComic);

        ComicAdapter mAdapter = new ComicAdapter(this, comicList);

        ListView comicsList = findViewById(R.id.activity_comics_list_list_view);

        comicsList.setAdapter(mAdapter);
    }
}
