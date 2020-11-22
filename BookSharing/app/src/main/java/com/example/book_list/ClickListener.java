package com.example.book_list;

import android.view.View;

public interface ClickListener {
    public void onClick(View view, int position);
    public void onLongClick(View view, int position);
}