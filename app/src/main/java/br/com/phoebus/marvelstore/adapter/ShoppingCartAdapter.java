package br.com.phoebus.marvelstore.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.List;

import br.com.phoebus.marvelstore.R;
import br.com.phoebus.marvelstore.dao.ComicDAO;
import br.com.phoebus.marvelstore.model.Comic;

public class ShoppingCartAdapter extends BaseAdapter {

    private final List<Comic> shoppingCartList;
    private final Context mContext;
    private final ComicDAO dao;

    public ShoppingCartAdapter(Context mContext, ComicDAO dao) {
        this.mContext = mContext;
        this.shoppingCartList = dao.getCartList();
        this.dao = dao;
    }
    @Override
    public int getCount() {
        return shoppingCartList.size();
    }

    @Override
    public Object getItem(int i) {
        return shoppingCartList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View mView = view;
        final int index = i;
        final ShoppingCartAdapter mAdapter = this;

        if(mView == null) {
            mView = inflater.inflate(R.layout.shopping_cart_list_item, viewGroup, false);
        }
        Comic currComic = shoppingCartList.get(i);

        TextView title = mView.findViewById(R.id.shopping_cart_list_item_title);
        TextView price = mView.findViewById(R.id.shopping_cart_list_item_price);
        Button removeButton = mView.findViewById(R.id.shopping_cart_list_item_remove_button);

        title.setText(currComic.getTitle());
        price.setText(currComic.getPrice());
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dao.removeFromCart(index);

                if (dao.isCartEmpty()) {
                    Toast.makeText(mContext, "Your cart is empty.", Toast.LENGTH_SHORT).show();
                    ((Activity) mContext).finish();
                }
                else {
                    Toast.makeText(mContext, "Comic removed.", Toast.LENGTH_SHORT).show();
                }

                TextView totalPrice = ((Activity) mContext).findViewById(R.id.activity_shopping_cart_total_price_text_view);

                final DecimalFormat df = new DecimalFormat("#0.00");
                final double doublePrice = Double.valueOf(dao.getTotalPrice());
                totalPrice.setText(df.format(doublePrice));

                mAdapter.notifyDataSetChanged();
            }
        });

        return mView;
    }
}
