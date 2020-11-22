package com.example.book_list;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    EditText et_emailid;
    EditText et_password;

    ProgressDialog pd;

    SharedPreferences sharedPreferences;

    public static final String MyPREFERENCES = "MyPrefs" ;

    public static final String ID = "id";
    public static final String KEY_Email = "email";

    TextView txt_crtacc;
    TextView txt_forgotPassword;

    String email;
    String password;
    String url="https://booksharing2020.000webhostapp.com/include/login.php";

    Button b_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pd=new ProgressDialog(Login.this);
        pd.setMessage("Loading");
        pd.setCancelable(false);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        et_emailid=findViewById(R.id.et_email);
        et_password=findViewById(R.id.et_password);
        txt_crtacc=findViewById(R.id.txt_crtacc);
        txt_forgotPassword=findViewById(R.id.txt_forgotPassword);
        b_login=findViewById(R.id.b_login);

        b_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pd.show();

                email = et_emailid.getText().toString();
                password = et_password.getText().toString();

                if (TextUtils.isEmpty(email)) {

                    pd.dismiss();
                    Toast.makeText(Login.this, "Please Enter Email.", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(password)) {

                    pd.dismiss();
                    Toast.makeText(Login.this, "Please Enter Password.", Toast.LENGTH_LONG).show();
                }
                else{

                    StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            if (response.trim().equals("password_wrong")) {
                                pd.dismiss();
                                Toast.makeText(Login.this, "Please Enter Correct E-mail Id or Password", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                pd.dismiss();
                                SharedPreferences.Editor editor = sharedPreferences.edit();

                                editor.putString(KEY_Email, email );
                                editor.putString(ID,response);

                                editor.commit();
                                Intent i = new Intent(Login.this, book_category_page.class);
                                Toast.makeText(Login.this, "Login Success", Toast.LENGTH_SHORT).show();
                                startActivity(i);
                                finish();

                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            pd.dismiss();
                            Toast.makeText(Login.this, "Connection Problem", Toast.LENGTH_SHORT).show();
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> param = new HashMap<>();
                            param.put("email", email);
                            param.put("password", password);
                            return param;
                        }
                    };

                    RequestQueue queue = Volley.newRequestQueue(Login.this);
                    queue.add(request);
                }
            }
        });

        txt_forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent f_intent=new Intent(Login.this,ForgotPassword.class);
                startActivity(f_intent);
            }
        });

        txt_crtacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are You Sure You Want To Exit?")
                .setNegativeButton(android.R.string.no,null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Login.super.onBackPressed();
                    }
                }).create().show();
    }
}