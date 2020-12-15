package com.cityguide.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;

import com.cityguide.R;

public class ForgetPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retailer_forget_password);
    }

    public void backToLoginScreen(View view){
        Intent intent = new Intent(getApplicationContext(), Login.class);

//Add Transition
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.back_pressed), "transition_back_arrow_btn");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(ForgetPassword.this, pairs);
        startActivity(intent, options.toBundle());
    }

    public void callMakeSelectionScreen(View view){

        Intent intent = new Intent(getApplicationContext(), MakeSelection.class);

//Add Transition
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.next_btn), "transition_next_btn");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(ForgetPassword.this, pairs);
        startActivity(intent, options.toBundle());

    }

}