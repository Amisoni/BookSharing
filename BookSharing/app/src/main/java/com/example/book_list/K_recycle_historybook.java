package com.example.book_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class K_recycle_historybook extends AppCompatActivity {

    RecyclerView recyclerView1;
    K_MyAdapterHistory myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_historybook);

            recyclerView1 = findViewById(R.id.recyclehistory);
            recyclerView1.setLayoutManager(new LinearLayoutManager(K_recycle_historybook.this));

            myAdapter = new K_MyAdapterHistory(this, getMyList());
            recyclerView1.setAdapter(myAdapter);
        }

        private ArrayList<K_ModelHistory> getMyList () {

            ArrayList<K_ModelHistory> models = new ArrayList<>();

            K_ModelHistory model = new K_ModelHistory();

            model.setBookicon(R.drawable.book);
            model.setBookName("programming in c");
            model.setPublisherName("Reema Thareja");
            model.setAuthorName("Reema Thareja");
            model.setDonerName("kajal shah");
            models.add(model);


            model = new K_ModelHistory();
            model.setBookicon(R.drawable.book);
            model.setBookName("programming in c");
            model.setPublisherName("Reema Thareja");
            model.setAuthorName("Reema Thareja");
            model.setDonerName("kajal shah");
            models.add(model);


            model = new K_ModelHistory();
            model.setBookicon(R.drawable.book);
            model.setBookName("programming in c");
            model.setPublisherName("Reema Thareja");
            model.setAuthorName("Reema Thareja");
            model.setDonerName("kajal shah");
            models.add(model);

            return models;

        }


    }
