package com.example.pinguinhouse;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Vector;

public class MyAdapter extends BaseAdapter {

    Vector<String> vector = new Vector<String>();

    public void add(String url) {
        vector.add(url);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_list, viewGroup, false);
        TextView tv = (TextView) v.findViewById(R.id.tv);
        tv.setText(vector.get(i));
        Log.i("JFL", "TODO");
        return v;
    }
}