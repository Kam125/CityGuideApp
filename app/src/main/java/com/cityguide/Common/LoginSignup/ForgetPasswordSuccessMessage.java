package com.cityguide.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;

import com.cityguide.R;

public class ForgetPasswordSuccessMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retailer_forget_password_success_message);
    }

    public void goToLoginFromSuccessScreen(View view){

        Intent intent = new Intent(getApplicationContext(), Login.class);

//Add Transition
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.back_to_home), "transition_close_btn");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(ForgetPasswordSuccessMessage.this, pairs);
        startActivity(intent, options.toBundle());

    }

    public void callLoginScreen(View view){

        Intent intent = new Intent(getApplicationContext(), Login.class);
        //Animation start in pair

        Pair[] pairs = new Pair[1];

        pairs[0] = new Pair<View, String>(findViewById(R.id.login_btn), "transition_login_btn");

        //Now we need to call next activity using the intent and pass these pairs as transitions to ooper wala intent

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(ForgetPasswordSuccessMessage.this, pairs);
        startActivity(intent, options.toBundle());

    }

}