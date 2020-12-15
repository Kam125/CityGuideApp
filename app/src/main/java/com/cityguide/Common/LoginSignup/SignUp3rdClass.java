package com.cityguide.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.ScrollView;

import com.cityguide.R;

public class SignUp3rdClass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retailer_sign_up3rd_class);
    }

    public void goToSignup2ndScreenFromSignup3ndClass(View view){

        Intent intent = new Intent(getApplicationContext(), SignUp2ndClass.class);

//Add Transition
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.signup_back_button), "transition_back_arrow_btn");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp3rdClass.this, pairs);
        startActivity(intent, options.toBundle());

    }

    public void callNextSignupScreen(View view){

        Intent intent = new Intent(getApplicationContext(), VerifyOTP.class);

//Add Transition
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.signup_next_button), "transition_OTP_screen");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp3rdClass.this, pairs);
        startActivity(intent, options.toBundle());

    }

    public void callLoginScreen(View view){

        Intent intent = new Intent(getApplicationContext(), Login.class);
        //Animation start in pair

        Pair[] pairs = new Pair[1];

        pairs[0] = new Pair<View, String>(findViewById(R.id.signup_login_button), "transition_login_btn");

        //Now we need to call next activity using the intent and pass these pairs as transitions to ooper wala intent

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp3rdClass.this, pairs);
        startActivity(intent, options.toBundle());

    }

}