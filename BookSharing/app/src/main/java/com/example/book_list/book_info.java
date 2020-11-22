package com.example.book_list;



import android.content.DialogInterface;
import android.content.Intent;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class book_info extends AppCompatActivity {

    ImageView img;
    TextView bookname_info,author_info,publisher_info,edition_info,description_info;
    Button receive;

    AlertDialog.Builder builder;

    String image,bookinfo,authorinfo,publisherinfo,editioninfo,descriptioninfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_info);

        img=findViewById(R.id.img_info);
        bookname_info=findViewById(R.id.bookname_info);
        author_info=findViewById(R.id.author_info);
        publisher_info=findViewById(R.id.publisher_info);
        edition_info=findViewById(R.id.edition_info);
        description_info=findViewById(R.id.description_info);
        receive=findViewById(R.id.receive);

        image=getIntent().getStringExtra("photo");
        bookinfo=getIntent().getStringExtra("book_name");
        authorinfo=getIntent().getStringExtra("author_name");
        publisherinfo=getIntent().getStringExtra("publisher_name");
        editioninfo=getIntent().getStringExtra("edition");
        descriptioninfo=getIntent().getStringExtra("book_detail");

        Glide.with(book_info.this).load(image).into(img);
        bookname_info.setText(bookinfo);
        author_info.setText(authorinfo);
        publisher_info.setText(publisherinfo);
        edition_info.setText(editioninfo);
        description_info.setText(descriptioninfo);

        builder=new AlertDialog.Builder(this);

        receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                builder.setMessage("Are You Sure To Confirm This Book?").setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                finish();
                                /*Intent intent = new Intent(book_info.this, Receipt.class);
                                startActivity(intent);*/
                                Toast.makeText(book_info.this, "Success", Toast.LENGTH_SHORT).show();
                            }

                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                dialog.cancel();
                                Toast.makeText(book_info.this, "Continue", Toast.LENGTH_SHORT).show();
                            }
                        });

                AlertDialog alert=builder.create();
                alert.setTitle("Warning");
                alert.show();
            }
        });
    }
}
