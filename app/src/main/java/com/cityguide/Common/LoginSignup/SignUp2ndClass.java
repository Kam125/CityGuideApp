package com.cityguide.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cityguide.R;

public class SignUp2ndClass extends AppCompatActivity {

    //Variables

    ImageView backBtn;
    Button next, login;
    TextView titleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retailer_sign_up2nd_class);

        //Hooks
        backBtn = findViewById(R.id.signup_back_button);
        next = findViewById(R.id.signup_next_button);
        login = findViewById(R.id.signup_login_button);
        titleText = findViewById(R.id.signup_title_text);
    }

    public void goToSignupScreenFromSignup2ndClass(View viwe){

        Intent intent = new Intent(getApplicationContext(), SignUp.class);

//Add Transition
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.signup_back_button), "transition_back_arrow_btn");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp2ndClass.this, pairs);
        startActivity(intent, options.toBundle());

    }

    public void callNextSignupScreen(View view) {

        Intent intent = new Intent(getApplicationContext(), SignUp3rdClass.class);
        //Add Transitions
        Pair[] pairs = new Pair[4];
        pairs[0] = new Pair<View, String>(backBtn, "transition_back_arrow_btn");
        pairs[1] = new Pair<View, String>(next, "transition_next_btn");
        pairs[2] = new Pair<View, String>(login, "transition_login_btn");
        pairs[3] = new Pair<View, String>(titleText, "transition_title_text");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp2ndClass.this, pairs);
        startActivity(intent, options.toBundle());

    }

    public void callLoginScreen(View view){

        Intent intent = new Intent(getApplicationContext(), Login.class);
        //Animation start in pair

        Pair[] pairs = new Pair[1];

        pairs[0] = new Pair<View, String>(findViewById(R.id.signup_login_button), "transition_login_btn");

        //Now we need to call next activity using the intent and pass these pairs as transitions to ooper wala intent

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp2ndClass.this, pairs);
        startActivity(intent, options.toBundle());

    }

}