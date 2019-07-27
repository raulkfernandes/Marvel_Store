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

public class ComicsAdapter extends BaseAdapter {

    private final List<Comic> comicList;
    private final Context mContext;

    public ComicsAdapter(Context mContext, List<Comic> comicList) {
        this.mContext = mContext;
        this.comicList = comicList;
    }

    @Override
    public int getCount() {
        return comicList.size();
    }

    @Override
    public Object getItem(int i) {
        return comicList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return comicList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View mView = view;

        if(mView == null) {
            mView = inflater.inflate(R.layout.comic_list_item, viewGroup, false);
        }

        Comic currComic = comicList.get(i);

        TextView title = (TextView) mView.findViewById(R.id.title_content);
        TextView price = (TextView) mView.findViewById(R.id.price_content);

        title.setText(currComic.getTitle());
        price.setText(currComic.getPrice());

        return mView;
    }
}
