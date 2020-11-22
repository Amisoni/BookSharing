package com.example.book_list;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static android.R.id.list;

public class Recycler extends AppCompatActivity {

    RecyclerView recycler;
    Item_Adapter adapter;

    List<Model> list;

    ProgressDialog pd;

    String URL = "https://booksharing2020.000webhostapp.com/include/donate_book_view.php";
    String Image_URL = "https://booksharing2020.000webhostapp.com/donate_book/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        list = new ArrayList<>();

        pd = new ProgressDialog(Recycler.this);
        pd.setMessage("Loading");
        pd.setCancelable(false);
        pd.show();

        recycler = findViewById(R.id.recycler);

        StringRequest request = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                pd.dismiss();

                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject obj = array.getJSONObject(i);
                        Model model = new Model();

                        model.setImage(Image_URL+obj.getString("photo"));
                        model.setBookname(obj.getString("book_name"));
                        model.setAuthor(obj.getString("author_name"));
                        model.setPublisher(obj.getString("publisher_name"));
                        model.setEdition(obj.getString("edition"));
                        model.setDescription(obj.getString("book_detail"));
                        model.setTag("book");

                        list.add(model);
                    }

                    adapter = new Item_Adapter(list, Recycler.this);
                    recycler.setHasFixedSize(true);
                    LinearLayoutManager mLayoutManager = new LinearLayoutManager(Recycler.this);
                    mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    recycler.setAdapter(adapter);
                    recycler.setLayoutManager(mLayoutManager);
                    onClick();
                } catch (JSONException e) {

                    pd.dismiss();
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                pd.dismiss();
                Toast.makeText(Recycler.this, "Connection Problem", Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue queue = Volley.newRequestQueue(Recycler.this);
        queue.add(request);
    }

    private void onClick() {


        recycler.addOnItemTouchListener(new RV_Click(getApplicationContext(), recycler, new ClickListener() {
            @Override
            public void onClick(View view, int position) {

                Intent intent=new Intent(Recycler.this,book_info.class);
                intent.putExtra("photo",list.get(position).getImage());
                intent.putExtra("book_name",list.get(position).getBookname());
                intent.putExtra("author_name",list.get(position).getAuthor());
                intent.putExtra("publisher_name",list.get(position).getPublisher());
                intent.putExtra("edition",list.get(position).getEdition());
                intent.putExtra("book_detail",list.get(position).getDescription());
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }
}