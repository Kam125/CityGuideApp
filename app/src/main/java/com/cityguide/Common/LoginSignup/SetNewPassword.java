package com.cityguide.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;

import com.cityguide.R;

public class SetNewPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retailer_set_new_password);
    }

    public void backToVerifyOTP(View view){
        Intent intent = new Intent(getApplicationContext(), VerifyOTP.class);

//Add Transition
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.back_pressed), "transition_back_arrow_btn");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SetNewPassword.this, pairs);
        startActivity(intent, options.toBundle());
    }

    public void callSuccessMessageScreen(View view){
        Intent intent = new Intent(getApplicationContext(), ForgetPasswordSuccessMessage.class);

//Add Transition
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.ok_btn), "transition_ok_btn");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SetNewPassword.this, pairs);
        startActivity(intent, options.toBundle());
    }

}