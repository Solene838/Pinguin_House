package com.example.pinguinhouse;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Vector;

public class MyAdapter extends BaseAdapter {

    Vector<String> vector = new Vector<>();

    public void add(String url) {
        Log.i("JFL", "in adapter add");
        vector.add(url);
        Log.i("JFL", "vector: " + vector);
    }

    @Override
    public int getCount() {
        return vector.size();
    }

    @Override
    public Object getItem(int position) {
        return vector.toArray()[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Log.i("JFL", "in adapter view");
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_list, viewGroup, false);
        TextView tv = (TextView) v.findViewById(R.id.tv);
        tv.setText(vector.get(i).toString());
        Log.i("JFL", "TODO");
        return v;
    }
}