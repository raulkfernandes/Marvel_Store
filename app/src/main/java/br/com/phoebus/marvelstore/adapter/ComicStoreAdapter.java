package br.com.phoebus.marvelstore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.phoebus.marvelstore.R;
import br.com.phoebus.marvelstore.model.Comic;

public class ComicStoreAdapter extends BaseAdapter {

    private final List<Comic> comicStoreList;
    private final Context mContext;

    public ComicStoreAdapter(Context mContext, List<Comic> comicStoreList) {
        this.mContext = mContext;
        this.comicStoreList = comicStoreList;
    }

    @Override
    public int getCount() {
        return comicStoreList.size();
    }

    @Override
    public Object getItem(int i) {
        return comicStoreList.get(i);
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
            mView = inflater.inflate(R.layout.comic_store_list_item, viewGroup, false);
        }

        // Getting Related Comic
        Comic currComic = comicStoreList.get(i);

        // Getting Comic Elements Reference
        ImageView cover = mView.findViewById(R.id.comic_store_list_item_image);
        TextView title = mView.findViewById(R.id.comic_store_list_item_title);
        TextView price = mView.findViewById(R.id.comic_store_list_item_price);

        // Set Rarity
        if(currComic.isRare()) {
            price.setText("$" + currComic.getPrice() + " [Rare Comic]");
        }
        else {
            price.setText("$" + currComic.getPrice());
        }

        // Set Title
        title.setText(currComic.getTitle());

        // Set Cover Image Hardcoded
        switch (i) {
            case 0:
                cover.setImageResource(R.drawable.cover0);
                break;
            case 1:
                cover.setImageResource(R.drawable.cover1);
                break;
            case 2:
                cover.setImageResource(R.drawable.cover2);
                break;
            case 3:
                cover.setImageResource(R.drawable.cover3);
                break;
            case 4:
                cover.setImageResource(R.drawable.cover4);
                break;
            case 5:
                cover.setImageResource(R.drawable.cover5);
                break;
            case 6:
                cover.setImageResource(R.drawable.cover6);
                break;
            case 7:
                cover.setImageResource(R.drawable.cover7);
                break;
            case 8:
                cover.setImageResource(R.drawable.cover8);
                break;
            case 9:
                cover.setImageResource(R.drawable.cover9);
                break;
            case 10:
                cover.setImageResource(R.drawable.cover10);
                break;
            case 11:
                cover.setImageResource(R.drawable.cover11);
                break;
            case 12:
                cover.setImageResource(R.drawable.cover12);
                break;
            case 13:
                cover.setImageResource(R.drawable.cover13);
                break;
            case 14:
                cover.setImageResource(R.drawable.cover14);
                break;
            case 15:
                cover.setImageResource(R.drawable.cover15);
                break;
            case 16:
                cover.setImageResource(R.drawable.cover16);
                break;
            case 17:
                cover.setImageResource(R.drawable.cover17);
                break;
            case 18:
                cover.setImageResource(R.drawable.cover18);
                break;
            case 19:
                cover.setImageResource(R.drawable.cover19);
                break;
        }

        return mView;
    }
}
