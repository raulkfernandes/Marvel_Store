package br.com.phoebus.marvelstore.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
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
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View mView = view;
        final int index = position;
        final ShoppingCartAdapter mAdapter = this;

        if(mView == null) {
            mView = inflater.inflate(R.layout.shopping_cart_list_item, viewGroup, false);
        }
        Comic currComic = shoppingCartList.get(position);

        TextView title = mView.findViewById(R.id.shopping_cart_list_item_title);
        TextView price = mView.findViewById(R.id.shopping_cart_list_item_price);
        ImageView image = mView.findViewById(R.id.shopping_cart_list_item_image);

        title.setText(currComic.getTitle());
        price.setText(currComic.getPrice());
        SelectCoverImageLocally(image);

        Button removeButton = mView.findViewById(R.id.shopping_cart_list_item_remove_button);
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

    private void SelectCoverImageLocally(ImageView image) {
        switch (dao.getStoreItemPosition()) {
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
