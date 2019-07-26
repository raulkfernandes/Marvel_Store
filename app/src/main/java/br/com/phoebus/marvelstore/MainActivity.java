package br.com.phoebus.marvelstore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.phoebus.marvelstore.adapter.ComicsAdapter;
import br.com.phoebus.marvelstore.model.Comic;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Comics Store");
        setContentView(R.layout.activity_main);

        FloatingActionButton shoppingCartButton = (FloatingActionButton) findViewById(R.id.activity_main_fab_shopping_cart);
        shoppingCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ShoppingCartActivity.class);
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

        ComicsAdapter mAdapter = new ComicsAdapter(this, comicList);

        ListView comicsList = findViewById(R.id.activity_main_comics_list);

        comicsList.setAdapter(mAdapter);
    }
}
