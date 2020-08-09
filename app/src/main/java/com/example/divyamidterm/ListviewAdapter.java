package com.example.divyamidterm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class ListviewAdapter extends BaseAdapter {

    Context context;
    ArrayList<Repositories> repoArrayList;
    LayoutInflater inflater;

    public ListviewAdapter(Context context, ArrayList<Repositories> pokemonArrayList) {
        this.context = context;
        this.repoArrayList = pokemonArrayList;
    }

    @Override
    public int getCount() {
        return repoArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return repoArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
        {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.customview,parent,false);
        }


        TextView textView = convertView.findViewById(R.id.p_txtV);
        TextView textView1 = convertView.findViewById(R.id.p_txtV1);

        textView.setText(repoArrayList.get(position).getName());
        textView1.setText(repoArrayList.get(position).getLogin());

        return convertView;
    }
}

