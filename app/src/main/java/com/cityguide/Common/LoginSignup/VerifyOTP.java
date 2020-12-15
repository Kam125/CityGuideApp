package com.cityguide.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;

import com.cityguide.R;

public class VerifyOTP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retailer_verify_o_t_p);
    }

    public void goToHomeFromOTP(View view){

        Intent intent = new Intent(getApplicationContext(), SignUp.class);

//Add Transition
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.back_to_home), "transition_OTP_screen");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(VerifyOTP.this, pairs);
        startActivity(intent, options.toBundle());

    }

    public void callSetNewPasswordScreen(View view){

        Intent intent = new Intent(getApplicationContext(), SetNewPassword.class);

//Add Transition
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.verify_code_btn), "transition_OTP_screen");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(VerifyOTP.this, pairs);
        startActivity(intent, options.toBundle());

    }

}