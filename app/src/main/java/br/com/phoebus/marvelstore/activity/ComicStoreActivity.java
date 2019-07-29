package br.com.phoebus.marvelstore.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.phoebus.marvelstore.R;
import br.com.phoebus.marvelstore.adapter.ComicStoreAdapter;
import br.com.phoebus.marvelstore.dao.ComicDAO;
import br.com.phoebus.marvelstore.model.Comic;
import br.com.phoebus.marvelstore.retrofit.AuthorRoleEnum;
import br.com.phoebus.marvelstore.retrofit.ComicJSON;
import br.com.phoebus.marvelstore.retrofit.DataJSON;
import br.com.phoebus.marvelstore.retrofit.Date;
import br.com.phoebus.marvelstore.retrofit.Item;
import br.com.phoebus.marvelstore.retrofit.MarvelAPI;
import br.com.phoebus.marvelstore.retrofit.Price;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ComicStoreActivity extends AppCompatActivity {

    private static final String TAG = "ComicStoreActivity";
    private static final String BASE_URL = "http://gateway.marvel.com/v1/public/";

    ComicDAO dao = new ComicDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Comics Store");
        setContentView(R.layout.activity_comic_store);

        populateComicStoreList();

        shoppingCartFabBehaviour();
    }

    private void populateComicStoreList() {

        // Retrofit Instance
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MarvelAPI marvelAPI = retrofit.create(MarvelAPI.class);
        Call<DataJSON> call = marvelAPI.getData();

        // Retrofit Request Call
        call.enqueue(new Callback<DataJSON>() {

            @Override
            public void onResponse(Call<DataJSON> call, Response<DataJSON> response) {
                Log.d(TAG, "onResponse: Received Information: " + response.body().toString());

                final List<ComicJSON> comicListJSON = response.body().getData().getComicsJSON();

                List<ComicJSON> comicList = new ArrayList<>();
                for (int i = 0; i < comicListJSON.size(); i++) {
                    ComicJSON currentComic = comicListJSON.get(i);

                    Price price = currentComic.getPrices().get(0);
                    if(price != null) {
                        currentComic.setPrice(price.getPrice());
                    }
                    else {
                        currentComic.setPrice(0);
                    }

                    Date date = currentComic.getDates().get(0);
                    if(date != null){
                        String[] formatDate = date.getDate().substring(0, 10).split("-");
                        currentComic.setPublishedDate(formatDate[1] + "/" + formatDate[2] + "/" + formatDate[0]);
                    }
                    else {
                        currentComic.setPublishedDate("00/00/0000");
                    }

                    List<Item> authorsAvailable = currentComic.getCreators().getItems();
                    for (Item author : authorsAvailable) {
                        if (author.getRole().equals(AuthorRoleEnum.WRITER.getAuthorRole())) {
                            currentComic.addWriter(author.getName());
                        } else if (author.getRole().equals(AuthorRoleEnum.PENCILER.getAuthorRole())) {
                            currentComic.addPenciler(author.getName());
                        } else if (author.getRole().equals(AuthorRoleEnum.COVER_ARTIST.getAuthorRole())) {
                            currentComic.addCoverArtist(author.getName());
                        }
                    }

                    comicList.add(currentComic);
                }

                final List<Comic> convertedComicList = convertJSONtoComic(comicList);

                final ComicStoreAdapter mAdapter = new ComicStoreAdapter(ComicStoreActivity.this, convertedComicList);
                final ListView comicListView = findViewById(R.id.activity_comic_store_list_view);
                comicListView.setAdapter(mAdapter);

                comicListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                        Comic selectedComic = convertedComicList.get(posicao);

                        Intent comicIntent = new Intent(ComicStoreActivity.this, ComicDetailsActivity.class);
                        comicIntent.putExtra("selectedComic", selectedComic);
                        startActivity(comicIntent);
                    }
                });
            }

            // If something went wrong in request, initialize a local List
            @Override
            public void onFailure(Call<DataJSON> call, Throwable t) {
                Toast.makeText(ComicStoreActivity.this, "Comic Store List initialized locally.", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onFailure: Something went wrong: " + t.getMessage());

                List<Comic> comicStoreList = populateComicsLocally();

                final List<Comic> finalComicStoreList = comicStoreList;

                final ComicStoreAdapter mAdapter = new ComicStoreAdapter(ComicStoreActivity.this, comicStoreList);
                final ListView comicListView = findViewById(R.id.activity_comic_store_list_view);
                comicListView.setAdapter(mAdapter);


                comicListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                        Comic selectedComic = finalComicStoreList.get(posicao);

                        Intent comicIntent = new Intent(ComicStoreActivity.this, ComicDetailsActivity.class);
                        comicIntent.putExtra("selectedComic", selectedComic);
                        startActivity(comicIntent);
                    }
                });
            }
        });
    }

    private List<Comic> populateComicsLocally() { //TODO Criar lista completa
        List<Comic> comicList = new ArrayList<>();

        Comic firstComic = new Comic();
        firstComic.setTitle("Hulk");
        firstComic.setPrice(10);
        Comic secComic = new Comic();
        secComic.setTitle("Spiderman");
        secComic.setPrice(20);
        Comic thirdComic = new Comic();
        thirdComic.setTitle("X-Men");
        thirdComic.setPrice(30);

        comicList.add(firstComic);
        comicList.add(secComic);
        comicList.add(thirdComic);

        return comicList;
    }

    private List<Comic> convertJSONtoComic(List<ComicJSON> comicJSONList) {
        List<Comic> convertedComicList = new ArrayList<>();

        for (int i = 0; i < comicJSONList.size(); i++) {
            ComicJSON comicJSON = comicJSONList.get(i);

            Comic comic = new Comic();
            comic.setTitle(comicJSON.getTitle());
            comic.setPrice(comicJSON.getPrice());
            comic.setWriters(comicJSON.getWriters());
            comic.setPencilers(comicJSON.getPencilers());
            comic.setCoverArtists(comicJSON.getCoverArtits());
            comic.setDescription(comicJSON.getDescription());
            comic.setPublishedDate(comicJSON.getPublishedDate());
            comic.setRare(false);

            convertedComicList.add(comic);
        }

        setRareComics(convertedComicList);

        return convertedComicList;
    }

    private void shoppingCartFabBehaviour() {
        FloatingActionButton shoppingCartButton = findViewById(R.id.activity_comic_store_fab_shopping_cart);
        shoppingCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dao.getCartList() == null || dao.isCartEmpty()) {
                    Toast.makeText(ComicStoreActivity.this, "Your cart is empty.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(ComicStoreActivity.this, ShoppingCartActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void setRareComics(List<Comic> convertedComicList) {
        int total = convertedComicList.size();
        int rareQuantity = (int) (total * 0.12);

        ArrayList<Integer> rareIndexList = new ArrayList<>();

        while(rareIndexList.size() < rareQuantity) {
            int rareIndex = new Random().nextInt(total);
            if(!rareIndexList.contains(rareIndex)) {
                rareIndexList.add(rareIndex);
            }
        }

        for(int i = 0; i < rareIndexList.size(); i++) {
            convertedComicList.get(rareIndexList.get(i)).setRare(true);
        }
    }
}
