package com.example.pinguinhouse;

import android.view.View;

import java.net.HttpURLConnection;

class GetTextOnClickListener implements View.OnClickListener{
    private SearchActivity searchActivity;

    public GetTextOnClickListener(SearchActivity searchActivity) {
        this.searchActivity = searchActivity;
    }


    @Override
    public void onClick(View v) {

        //searching Dan Brown
        String url = "https://reststop.randomhouse.com/resources/authors/3446/";

        AsyncPinguinRandomJSONData task = new AsyncPinguinRandomJSONData(searchActivity);
        task.execute(url);
    }
}
