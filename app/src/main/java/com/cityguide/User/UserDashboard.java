package com.cityguide.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cityguide.Common.LoginSignup.RetailerStartUpScreen;
import com.cityguide.HelperClasses.CategoriesAdapter.CategoriesAdapter;
import com.cityguide.HelperClasses.CategoriesAdapter.CategoriesHelperClass;
import com.cityguide.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.cityguide.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.cityguide.HelperClasses.MostViewedAdpater.MostViewedAdapter;
import com.cityguide.HelperClasses.MostViewedAdpater.MostViewedHelperClass;
import com.cityguide.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables
    static final float END_SCALE = 0.7f;
    RecyclerView featuredRecycler, mostViewedRecycler, categoriesRecycler;
    RecyclerView.Adapter adapter;
    ImageView menuIcon;
    LinearLayout contentView;

    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);
        categoriesRecycler = findViewById(R.id.categories_recycler);
        menuIcon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);
        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        navigationDrawer();

        featuredRecycler();
        mostViewedRecycler();
        categoriesRecycler();

    }

    //Navigation Views Function
    private void navigationDrawer() {

        //Navigation Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        animateNavigationDrawer();
    }

    private void animateNavigationDrawer() {
        drawerLayout.setScrimColor(getResources().getColor(R.color.colorPrimary));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){

            case R.id.nav_all_categories:
                startActivity(new Intent(getApplicationContext(), AllCategories.class));
                break;
        }

        return true;
    }


    //Recycler views Function
    private void categoriesRecycler() {

        categoriesRecycler.setHasFixedSize(true); //recycler contain lot of card views some on screen some off screen, this will load those which are visible to user
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<CategoriesHelperClass> categoriesHelperClasses = new ArrayList<>();
        categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable.restaurant, "Restaurant"));
        categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable.school, "Education"));
        categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable.hospital, "Hospital"));

        adapter = new CategoriesAdapter(categoriesHelperClasses);
        categoriesRecycler.setAdapter(adapter);

    }

    private void mostViewedRecycler() {

        mostViewedRecycler.setHasFixedSize(true); //recycler contain lot of card views some on screen some off screen, this will load those which are visible to user
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostViewedLocations = new ArrayList<>();
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.macdonald_img, "Macdonald's"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.edenrobe, "Edenrobe"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.bakers, "Sweet & Bakers"));

        adapter = new MostViewedAdapter(mostViewedLocations);
        mostViewedRecycler.setAdapter(adapter);

    }

    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true); //recycler contain lot of card views some on screen some off screen, this will load those which are visible to user
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();
        featuredLocations.add(new FeaturedHelperClass(R.drawable.macdonald_img, "Macdonald's", "McDonald's (MCD) is a fast food, limited service restaurant with more than 35,000 restaurants in over 100 countries. It employs more than four million people"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.edenrobe, "Edenrobe",
                "The initiative turned out to be a success & the company quickly became popular for its quality kids wear & later expanded its portfolio to rise as edenrobe"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.bakers, "Sweet & Bakers",
                "Bakers' confections are sweet foods that feature flour as a main ingredient and are baked. Major categories include cakes, sweet pastries, doughnuts, scones, and cookies."));


        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);
    }

    //Normal Functions

    public void callRetailerScreens(View view){
        startActivity(new Intent(getApplicationContext(), RetailerStartUpScreen.class));
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else super.onBackPressed();
    }
}