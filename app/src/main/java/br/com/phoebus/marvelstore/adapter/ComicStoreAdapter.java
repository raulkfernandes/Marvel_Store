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

        Comic currComic = comicStoreList.get(i);

        TextView title = mView.findViewById(R.id.comic_store_list_item_title);
        TextView price = mView.findViewById(R.id.comic_store_list_item_price);

        title.setText(currComic.getTitle());
        price.setText(currComic.getPrice());

        return mView;
    }
}
