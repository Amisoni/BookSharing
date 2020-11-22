package com.example.book_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.bumptech.glide.Glide;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class Item_Adapter extends RecyclerView.Adapter<Item_Adapter.MyViewHolder> {

    private List<Model> model;
    Context context;

    public Item_Adapter(List<Model> model, Context context)
    {
        this.model=model;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
       /* View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemview,parent,false);*/

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(context);
        view = mInflater.inflate(R.layout.row,parent,false);

      /*  final MyViewHolder viewHolder=new MyViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "hi", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(context, DisplayPac.class);
                if (model.get(viewHolder.getAdapterPosition()).equals("pac")) {
                    i.putExtra("image1", model.get(viewHolder.getAdapterPosition()).getImage1());
                }
                context.startActivity(i);
            }
        });*/
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Model model_item=model.get(position);

        if (model_item.getTag().equals("book")) {
            holder.bookname.setText(model_item.getBookname());
            holder.author.setText(model_item.getAuthor());
            holder.publisher.setText(model_item.getPublisher());
            holder.edition.setText(model_item.getEdition());
            if (context != null) {
                Glide.with(context)
                        .load(model_item.getImage())

                        .into(holder.imageView);
            }
        }
        else {

            Toast.makeText(context, "Book Not Available", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView bookname,author,publisher,edition;
        ImageView imageView;

        public MyViewHolder(View view) {
            super(view);

            imageView = (ImageView) view.findViewById(R.id.img1);
            bookname = (TextView) view.findViewById(R.id.book_name);
            author = (TextView) view.findViewById(R.id.author);
            publisher = (TextView) view.findViewById(R.id.publisher);
            edition=(TextView)view.findViewById(R.id.edition);

        }

    }
}

