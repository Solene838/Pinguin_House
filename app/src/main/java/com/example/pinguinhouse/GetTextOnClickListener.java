package com.example.pinguinhouse;

import android.view.View;

class GetTextOnClickListener implements View.OnClickListener{
    private SearchActivity searchActivity;

    public GetTextOnClickListener(SearchActivity searchActivity) {
        this.searchActivity = searchActivity;
    }


    @Override
    public void onClick(View v) {

        //searching Tolkien
        String url = new String("https://reststop.randomhouse.com/resources/authors/3446/");

        AsyncPinguinRandomJSONData task = new AsyncPinguinRandomJSONData(searchActivity);
        task.execute(url);
    }
}
