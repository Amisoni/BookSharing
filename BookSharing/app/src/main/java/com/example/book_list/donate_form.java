package com.example.book_list;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;


public class donate_form extends AppCompatActivity {


    private static final int CAMERA_REQUEST = 1888;
    private static final int SELECT_FILE = 1888;
    EditText bookname, bookauthor, bookpublisher, bookedition, bookdescription;
    Spinner mySpinner;
    Button savedonatebutton;
    FloatingActionButton floatingActionButton;
    ImageView dbookimgview;
    ProgressDialog pd;
    String bname, bauthor, bpublisher, bedition, bcategory, bdescription;
    Bitmap photo;
    long imagename;
    String url = "https://booksharing2020.000webhostapp.com/include/donate_book_controller.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donate_form);
        // getActionBar().setTitle("Book Donate Form");

        pd = new ProgressDialog(donate_form.this);
        pd.setMessage("Loading");
        pd.setCancelable(false);

        bookname = (EditText) findViewById(R.id.dbookname);
        bookauthor = (EditText) findViewById(R.id.dbookauthorname);
        bookpublisher = (EditText) findViewById(R.id.dbookpublishername);
        bookedition = (EditText) findViewById(R.id.dbookedition);
        bookdescription = (EditText) findViewById(R.id.dbookshortDescript);
        mySpinner = (Spinner) findViewById(R.id.dmyspinner);
        savedonatebutton = (Button) findViewById(R.id.savedonatebutton);
        dbookimgview = (ImageView) findViewById(R.id.dbookimgview);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(donate_form.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.bookcategoryspinner));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);
                startActivityForResult(Intent.createChooser(intent, "Select Image"), CAMERA_REQUEST);
            }
        });

        savedonatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    pd.show();

                    bname = bookname.getText().toString();
                    bauthor = bookauthor.getText().toString();
                    bpublisher = bookpublisher.getText().toString();
                    bedition = bookedition.getText().toString();
                    bdescription = bookdescription.getText().toString();
                    bcategory = mySpinner.getSelectedItem().toString();


                    if (TextUtils.isEmpty(bname)) {

                        pd.dismiss();
                        Toast.makeText(donate_form.this, "Book Name Is Required", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(bauthor)) {

                        pd.dismiss();
                        Toast.makeText(donate_form.this, "Please Enter Author Name Of Book", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(bpublisher)) {

                        pd.dismiss();
                        Toast.makeText(donate_form.this, "Please Enter PblisherName Of Book", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(bedition)) {

                        pd.dismiss();
                        Toast.makeText(donate_form.this, "Please Enter Edition Of Book", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(bdescription)) {

                        pd.dismiss();
                        Toast.makeText(donate_form.this, "Please Enter Some Description For Book", Toast.LENGTH_SHORT).show();
                    } else if (bcategory == "Select") {

                        pd.dismiss();
                        Toast.makeText(donate_form.this, "Please Select Book Category", Toast.LENGTH_SHORT).show();
                    } else if (dbookimgview.getTag() != "tt") {

                        pd.dismiss();
                        Toast.makeText(donate_form.this, "Please Upload Photo Of Book", Toast.LENGTH_SHORT).show();
                    } else {

                        com.example.book_list.VolleyMultipartRequest volleyMultipartRequest = new com.example.book_list.VolleyMultipartRequest(Request.Method.POST, url,
                                new Response.Listener<NetworkResponse>() {
                                    @Override
                                    public void onResponse(NetworkResponse response) {
                                        pd.dismiss();
                                        try {
                                            JSONObject obj = new JSONObject(new String(response.data));
                                            String ss = obj.getString("success");
                                            Log.e("ResObj", ">>>>" + ss);

                                            if (response.toString().equals("success")) {
                                                Toast.makeText(donate_form.this, "Book Uploaded SuccessFully", Toast.LENGTH_SHORT).show();

                                                Intent intent = new Intent(donate_form.this, book_category_page.class);
                                                startActivity(intent);
                                            } else {

                                                Toast.makeText(donate_form.this, response.toString(), Toast.LENGTH_SHORT).show();
                                            }
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }

                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {

                                        pd.dismiss();
                                        Toast.makeText(donate_form.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }) {

                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                Map<String, String> params = new HashMap<>();
                                params.put("book_name", bname);
                                params.put("author_name", bauthor);
                                params.put("publisher_name", bpublisher);
                                params.put("edition", bedition);
                                params.put("book_detail", bdescription);
                                params.put("book_category", bcategory);
                                return params;
                            }


                            @Override
                            protected Map<String, DataPart> getByteData() {
                                Map<String, DataPart> params = new HashMap<>();

                                params.put("photo", new DataPart(imagename + ".png", getFileDataFromDrawable1(photo)));
                                return params;
                            }
                        };

                        //adding the request to volley
                        Volley.newRequestQueue(donate_form.this).add(volleyMultipartRequest);
                   /* volleyMultipartRequest .setRetryPolicy(new DefaultRetryPolicy(
                            10000,
                            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));*/
                    }
                }
            }
        });

    }

    public byte[] getFileDataFromDrawable1(Bitmap photo) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        photo.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

/*
    private void opencamera() {
        final CharSequence[] items = {"Camera", "Gallery"};
        AlertDialog.Builder builder = new AlertDialog.Builder(donate_form.this);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (items[i].equals("Camera"))
                {
                    Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, CAMERA_REQUEST);
                    */
/*Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, CAMERA_REQUEST);*//*


                } else if (items[i].equals("Gallery")) {
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_PICK);
                    startActivityForResult(Intent.createChooser(intent, "Select Image"), SELECT_FILE);
                }
            }
        });
        builder.show();
    }
*/


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);



        if (requestCode == SELECT_FILE) {

            Uri filePath = data.getData();
            try {
                //getting image from gallery
                photo = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imagename = System.currentTimeMillis();
                //Setting image to ImageView
                dbookimgview.setImageBitmap(photo);
                dbookimgview.setTag("tt");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


