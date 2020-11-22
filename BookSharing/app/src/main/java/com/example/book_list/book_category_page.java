package com.example.book_list;

import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;

public class book_category_page extends AppCompatActivity implements NavigationView.OnCreateContextMenuListener {

    DrawerLayout navDrawer;
    CardView cardView;
    ActionBarDrawerToggle abdt;
    AppBarConfiguration mAppBarConfiguration;

    ImageView drawer_click;
    String MyPREFERENCES = "Myprefs";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_category_page);

        navDrawer = findViewById(R.id.drawer);
        NavigationView navigationView = findViewById(R.id.nav_view);
        Button donateButton = findViewById(R.id.donatbuttonform);
        cardView = findViewById(R.id.card_view1);
        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer_click = findViewById(R.id.drawer_click);

        drawer_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(!navDrawer.isDrawerOpen(GravityCompat.START)) navDrawer.openDrawer(GravityCompat.START);
            else navDrawer.closeDrawer(GravityCompat.END);
            }
        });


        donateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), donate_form.class);
                startActivity(intent);
            }
        });


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(book_category_page.this, Recycler.class);
                startActivity(i);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.his) {
                    Intent it = new Intent(book_category_page.this, History.class);
                    startActivity(it);
                } else if (id == R.id.Donatebook) {
                    Intent it = new Intent(book_category_page.this, donate_form.class);
                    startActivity(it);

                } else if (id == R.id.Receivebook) {
                    Intent it = new Intent(book_category_page.this, Recycler.class);
                    startActivity(it);

                } else if (id == R.id.Setting) {
                    Intent it = new Intent(book_category_page.this, setting.class);
                    startActivity(it);

                } else if (id == R.id.Aboutus) {


                } else if (id == R.id.logout) {

                    editor.clear();
                    editor.commit();
                    Intent it = new Intent(book_category_page.this, Login.class);
                    startActivity(it);
                    finish();
                    return true;
                }

                return false;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        // Retrieve the SearchView and plug it into SearchManager
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return true;
    }


    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setTitle("leave So soon?")
                .setMessage("Are You Sure You Want To Exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        book_category_page.super.onBackPressed();
                    }
                }).create().show();
    }
}
