package br.com.phoebus.marvelstore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.phoebus.marvelstore.R;
import br.com.phoebus.marvelstore.model.Comic;

public class ShoppingCartAdapter extends BaseAdapter {

    private final List<Comic> shoppingCartList;
    private final Context mContext;

    public ShoppingCartAdapter(Context mContext, List<Comic> shoppingCartList) {
        this.mContext = mContext;
        this.shoppingCartList = shoppingCartList;
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

        if(mView == null) {
            mView = inflater.inflate(R.layout.shopping_cart_list_item, viewGroup, false);
        }

        Comic currComic = shoppingCartList.get(i);

        TextView title = mView.findViewById(R.id.shopping_cart_list_item_title);
        TextView price = mView.findViewById(R.id.shopping_cart_list_item_price);

        title.setText(currComic.getTitle());
        price.setText(currComic.getPrice());

        return mView;
    }
}
