package com.example.book_list;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

    public class ForgotPassword extends AppCompatActivity {

        EditText et_emailid;
        Button submit;

        ProgressDialog pd;

        String emailid;
        String url = "https://booksharing2020.000webhostapp.com/include/forgotpassword.php";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_forgot_password);

            pd = new ProgressDialog(ForgotPassword.this);
            pd.setMessage("Loading");
            pd.setCancelable(false);

            et_emailid = findViewById(R.id.et_emailid);
            submit = findViewById(R.id.submit);

            submit.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    pd.show();
                    emailid = et_emailid.getText().toString();

                    StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            pd.dismiss();
                            if (response.trim().equals("success")) {

                                Toast.makeText(ForgotPassword.this, "Paasword Link Sent To Your Email", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(ForgotPassword.this, Login.class);
                                startActivity(i);
                            } else {

                                Toast.makeText(ForgotPassword.this, response, Toast.LENGTH_SHORT).show();
                                //Toast.makeText(ForgotPassword.this, "Please Enter Valid Email-Id", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            pd.dismiss();
                            Toast.makeText(ForgotPassword.this, "Connection Problem", Toast.LENGTH_SHORT).show();
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> param = new HashMap<>();
                            param.put("email", emailid);
                            return param;
                        }
                    };

                    RequestQueue queue = Volley.newRequestQueue(ForgotPassword.this);
                    queue.add(request);

                }
            });
        }
    }
