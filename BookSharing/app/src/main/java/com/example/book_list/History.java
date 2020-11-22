package com.example.book_list;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class History extends AppCompatActivity {
    CardView donatedbooks,receivedbooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        donatedbooks = (CardView) findViewById(R.id.donatedbooks);
        receivedbooks = (CardView) findViewById(R.id.receivedbooks);
        
        donatedbooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(History.this, History_Donated_books.class);
                startActivity(intent);
            }
        });
        receivedbooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(History.this, History_Received_books.class);
                startActivity(intent);
            }
        });

    }
}
