package br.com.phoebus.marvelstore.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import br.com.phoebus.marvelstore.R;
import br.com.phoebus.marvelstore.adapter.ComicStoreAdapter;
import br.com.phoebus.marvelstore.dao.ComicDAO;
import br.com.phoebus.marvelstore.model.Comic;

public class ComicStoreActivity extends AppCompatActivity {

    ComicDAO dao = new ComicDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Comics Store");
        setContentView(R.layout.activity_comic_store);

        FloatingActionButton shoppingCartButton = findViewById(R.id.activity_comic_store_fab_shopping_cart);
        shoppingCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dao.getCartList() == null || dao.isCartEmpty()) {
                    Toast.makeText(ComicStoreActivity.this, "You must add at least one comic to your cart.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(ComicStoreActivity.this, ShoppingCartActivity.class);
                    startActivity(intent);
                }
            }
        });

        final List<Comic> comicStoreList = populateComicsLocally();
        ComicStoreAdapter mAdapter = new ComicStoreAdapter(this, comicStoreList);
        final ListView comicListView = findViewById(R.id.activity_comic_store_list_view);
        comicListView.setAdapter(mAdapter);

        comicListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
            Comic selectedComic = comicStoreList.get(posicao);

            Intent comicIntent = new Intent(ComicStoreActivity.this, ComicDetailsActivity.class);
            comicIntent.putExtra("selectedComic", selectedComic);
            startActivity(comicIntent);
            }
        });
    }

    private List<Comic> populateComicsLocally() {
        List<Comic> comicList = new ArrayList<>();

        Comic firstComic = new Comic("X-Men", "9.99");
        Comic secComic = new Comic("Spiderman", "19.99");
        Comic thirdComic = new Comic("Hulk", "29.99");

        comicList.add(firstComic);
        comicList.add(secComic);
        comicList.add(thirdComic);

        return comicList;
    }

    private List<Comic> populateComicsWebService() {
        List<Comic> comicList = new ArrayList<>();

        return comicList;
    }
}
