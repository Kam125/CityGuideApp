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
import com.google.android.material.textfield.TextInputLayout;

public class SignUp extends AppCompatActivity {

    //Variables

    ImageView backBtn;
    Button next, login;
    TextView titleText;

    //Get data variables

    TextInputLayout fullName, userName, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retailer_signup);

        //Hooks for animation
        backBtn = findViewById(R.id.signup_back_button);
        next = findViewById(R.id.signup_next_button);
        login = findViewById(R.id.signup_login_button);
        titleText = findViewById(R.id.signup_title_text);

        //Hooks for getting data

        fullName = findViewById(R.id.signup_fullname);
        userName = findViewById(R.id.signup_username);
        email = findViewById(R.id.signup_email);
        password = findViewById(R.id.signup_password);

    }

    public void goToRetailerScreenFromSignup(View view) {

        Intent intent = new Intent(getApplicationContext(), RetailerStartUpScreen.class);

//Add Transition
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.signup_back_button), "transition_back_arrow_btn");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp.this, pairs);
        startActivity(intent, options.toBundle());

    }

    public void callNextSignupScreen(View view) {

        if (!validateFullName() | !validateUserName() | !validateEmail() | !validatePassword()) {
            return;
        } else {
            Intent intent = new Intent(getApplicationContext(), SignUp2ndClass.class);
            //Add Transitions
            Pair[] pairs = new Pair[4];
            pairs[0] = new Pair<View, String>(backBtn, "transition_back_arrow_btn");
            pairs[1] = new Pair<View, String>(next, "transition_next_btn");
            pairs[2] = new Pair<View, String>(login, "transition_login_btn");
            pairs[3] = new Pair<View, String>(titleText, "transition_title_text");

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp.this, pairs);
           //Sending data to Next screen
            intent.putExtra("fullName", validateFullName());
            intent.putExtra("userName", validateUserName());
            intent.putExtra("email", validateEmail());
            intent.putExtra("password", validatePassword());
            startActivity(intent, options.toBundle());
        }
    }

    public void callLoginScreen(View view) {

        Intent intent = new Intent(getApplicationContext(), Login.class);
        //Animation start in pair

        Pair[] pairs = new Pair[1];

        pairs[0] = new Pair<View, String>(findViewById(R.id.signup_login_button), "transition_login_btn");

        //Now we need to call next activity using the intent and pass these pairs as transitions to ooper wala intent

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp.this, pairs);
        startActivity(intent, options.toBundle());

    }

    /*
        Validation functions
    */

    private boolean validateFullName() {

        String val = fullName.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            fullName.setError("Field can not be empty");
            return false;
        } else {
            fullName.setError(null);
            fullName.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateUserName() {

        String val = userName.getEditText().getText().toString().trim();
        String checkSpaces = "\\A\\w{1,20}\\z";

        if (val.isEmpty()) {
            userName.setError("Field can not be empty");
            return false;
        } else if (val.length() > 20) {
            userName.setError("Username is too large!");
            return false;
        } else if (!val.matches(checkSpaces)) {
            userName.setError("No white spaces are allowed!");
            return false;
        } else {
            userName.setError(null);
            userName.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateEmail() {

        String val = email.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";

        if (val.isEmpty()) {
            email.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checkEmail)) {
            email.setError("Invalid Email!");
            return false;
        } else {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword() {

        String val = password.getEditText().getText().toString().trim();
        String checkPassword = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                //"(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";

        if (val.isEmpty()) {
            password.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checkPassword)) {
            password.setError("Password should contain 4 characters!");
            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }

}