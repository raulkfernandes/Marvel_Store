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

        //Simulating Marvel's API request
        ComicDAO dao = new ComicDAO();
        dao.addFirstItens();
        final List<Comic> comicStoreList = dao.getCartList();

        ComicStoreAdapter mAdapter = new ComicStoreAdapter(this, comicStoreList);

        final ListView comicList = findViewById(R.id.activity_comic_store_list_view);
        comicList.setAdapter(mAdapter);

        comicList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {

                Toast.makeText(ComicStoreActivity.this, "" + comicStoreList.get(posicao), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
