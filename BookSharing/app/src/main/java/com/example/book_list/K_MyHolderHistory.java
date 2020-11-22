package com.example.book_list;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class K_MyHolderHistory extends RecyclerView.ViewHolder {

    ImageView bookimg;
    TextView name;
    TextView author;
    TextView publisher;
    TextView doner;

    public K_MyHolderHistory(@NonNull View itemView) {
        super(itemView);

        this.bookimg = itemView.findViewById(R.id.historybook);
        this.name = itemView.findViewById(R.id.bookname);
        this.author = itemView.findViewById(R.id.authorname);
        this.publisher=itemView.findViewById(R.id.publishername);
        this.doner=itemView.findViewById(R.id.donername);

    }
}
