package com.cityguide.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;

import com.cityguide.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retailer_login);
    }

    public void goToRetailerScreenFromLogin(View view){

        Intent intent = new Intent(getApplicationContext(), RetailerStartUpScreen.class);

//Add Transition
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.login_back_button), "transition_back_arrow_btn");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
        startActivity(intent, options.toBundle());

    }

    public void callSignUpScreen(View view){

        Intent intent = new Intent(getApplicationContext(), SignUp.class);

//Add Transition
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.create_account_btn), "transition_login_btn");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
        startActivity(intent, options.toBundle());

    }

    public void ForgetPassword(View view){
        Intent intent = new Intent(getApplicationContext(), ForgetPassword.class);

//Add Transition
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.forget_password_btn), "transition_forget_password_btn");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
        startActivity(intent, options.toBundle());
    }

}