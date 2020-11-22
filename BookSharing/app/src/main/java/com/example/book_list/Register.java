package com.example.book_list;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Intent;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import androidx.appcompat.app.AppCompatActivity;


    public class Register extends AppCompatActivity {


        EditText et_name;
        EditText et_email;
        EditText et_adrs;
        EditText et_cont;
        EditText enrollmentNo;
        EditText et_password;
        EditText et_conpassword;
        RadioGroup group;
        Button register;
        RadioButton student,faculty;
        ProgressDialog pd;

        String name;
        String enrollment_no;
        String address;
        String mobile_no;
        String email;
        String password;
        String con_password;
        String user_type;

        String url="https://booksharing2020.000webhostapp.com/include/registration.php";

        Matcher user_name;

        boolean u_name;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register);

            pd=new ProgressDialog(Register.this);
            pd.setMessage("Loading");
            pd.setCancelable(false);

            et_name=findViewById(R.id.et_name);
            et_email=findViewById(R.id.et_email);
            et_adrs=findViewById(R.id.et_adrs);
            et_cont=findViewById(R.id.et_cont);
            enrollmentNo=findViewById(R.id.enrollmentNo);
            et_password=findViewById(R.id.et_password);
            et_conpassword=findViewById(R.id.et_conpassword);
            register=findViewById(R.id.register);
           


            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    pd.show();

                    name = et_name.getText().toString();
                    enrollment_no = enrollmentNo.getText().toString();
                    email = et_email.getText().toString();
                    address = et_adrs.getText().toString();
                    mobile_no = et_cont.getText().toString();
                    password=et_password.getText().toString();
                    con_password=et_conpassword.getText().toString();

                    Pattern ps1 = Pattern.compile("^[a-zA-Z ]+$");

                    user_name = ps1.matcher(et_name.getText().toString());
                    u_name = user_name.matches();

                    if (TextUtils.isEmpty(name)) {

                        pd.dismiss();
                        Toast.makeText(Register.this, "Please Enter Your Name.", Toast.LENGTH_LONG).show();
                    }
                    else if (u_name == false) {

                        pd.dismiss();
                        Toast.makeText(Register.this, "Only Text allowed In Name.", Toast.LENGTH_LONG).show();
                    }
                    else if (TextUtils.isEmpty(address)) {

                        pd.dismiss();
                        Toast.makeText(Register.this, "Please Enter Address.", Toast.LENGTH_LONG).show();
                    }
                    else if (TextUtils.isEmpty(mobile_no)) {

                        pd.dismiss();
                        Toast.makeText(Register.this, "Please Enter Mobile Number.", Toast.LENGTH_LONG).show();
                    }
                    else if (mobile_no.length() != 10) {

                        pd.dismiss();
                        Toast.makeText(Register.this, "Please Enter Correct Mobile Number.", Toast.LENGTH_LONG).show();
                    }
                    else if (!email.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")) {

                        pd.dismiss();
                        Toast.makeText(Register.this, "Please Enter Valid Email Address.", Toast.LENGTH_SHORT).show();
                    }
                    else if (TextUtils.isEmpty(enrollment_no)){

                        pd.dismiss();
                        Toast.makeText(Register.this, "Please Enter Enrollment Number.", Toast.LENGTH_LONG).show();
                    }
                    else if (TextUtils.isEmpty(password)) {

                        pd.dismiss();
                        Toast.makeText(Register.this, "Please Enter Password.", Toast.LENGTH_LONG).show();
                    }
                    else if (password.length() < 5) {

                        pd.dismiss();
                        Toast.makeText(Register.this, "Please Enter Minimum 5 Digits password.", Toast.LENGTH_LONG).show();
                    }
                    else if (TextUtils.isEmpty(con_password)) {

                        pd.dismiss();
                        Toast.makeText(Register.this, "Please Confirm Password.", Toast.LENGTH_LONG).show();
                    }
                    else if (!password.equals(con_password)) {

                        pd.dismiss();
                        Toast.makeText(Register.this, "Please Confirm Password.", Toast.LENGTH_LONG).show();
                    }
                    else {

                        StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                if (response.trim().equals("success")){

                                    pd.dismiss();
                                    Intent l = new Intent(Register.this, Login.class);
                                    startActivity(l);
                                    Toast.makeText(Register.this, "Register Successfully" , Toast.LENGTH_LONG).show();

                                }

                                else {

                                    pd.dismiss();
                                    Toast.makeText(Register.this, "Problem on Registration "+response, Toast.LENGTH_LONG).show();
                                }

                            }
                        },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {

                                        pd.dismiss();
                                        Toast.makeText(Register.this, "Connection Problem", Toast.LENGTH_SHORT).show();

                                    }
                                }){
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                Map<String,String> param=new HashMap<>();
                                param.put("name",name);
                                param.put("enrollment_no",enrollment_no);
                                param.put("address",address);
                                param.put("mobile_no",mobile_no);
                                param.put("user_type",user_type);
                                param.put("email",email);
                                param.put("password",password);
//                            param.put("confirm_password",con_password);

                                return param;
                            }
                        };

                        RequestQueue queue= Volley.newRequestQueue(Register.this);
                        queue.add(request);
                    }

                }
            });

        }
    }


