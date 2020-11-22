package com.example.book_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class History_Received_books extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history__received_books);

        Intent intent = new Intent(History_Received_books.this, K_recycle_historybook.class);
        startActivity(intent);
    }
}
