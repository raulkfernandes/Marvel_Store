package br.com.phoebus.marvelstore.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import br.com.phoebus.marvelstore.R;
import br.com.phoebus.marvelstore.adapter.ShoppingCartAdapter;
import br.com.phoebus.marvelstore.model.Comic;

public class ShoppingCartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Shopping Cart");
        setContentView(R.layout.activity_shopping_cart);

        Button checkoutButton = findViewById(R.id.activity_shopping_cart_checkout_button);
        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ShoppingCartActivity.this, "checkout", Toast.LENGTH_SHORT).show();
                //Limpa a lista estatica (pois a compra ja foi concluída)
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        List<Comic> shoppingCartList = new ArrayList<>();

        Comic firstComic = new Comic("Avengers", "49.99");
        Comic secComic = new Comic("Avengers 2", "59.99");
        Comic thirdComic = new Comic("Avengers 3", "69.99");
        Comic fourthComic = new Comic("Hulk", "39.99");
        Comic fifthComic = new Comic("Spiderman", "29.99");

        shoppingCartList.add(firstComic);
        shoppingCartList.add(secComic);
        shoppingCartList.add(thirdComic);
        shoppingCartList.add(fourthComic);
        shoppingCartList.add(fifthComic);

        //Preencher a lista do carrinho com os itens da lista estática do ComicDAO
        //List<Comic> shoppingCartList = dao.getCartItemList();

        ShoppingCartAdapter mAdapter = new ShoppingCartAdapter(this, shoppingCartList);

        ListView shoppingCartListView = findViewById(R.id.activity_shopping_cart_list_view);

        shoppingCartListView.setAdapter(mAdapter);
    }
}
