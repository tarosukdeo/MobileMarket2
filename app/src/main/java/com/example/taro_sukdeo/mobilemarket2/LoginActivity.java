package com.example.taro_sukdeo.mobilemarket2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends Activity {
    private Button btnLogin;
    private Button btnLinkToRegister;
    private EditText inputEmail;
    private EditText inputPassword;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Parse.initialize(this);

        inputEmail = (EditText)findViewById(R.id.email);
        inputPassword = (EditText)findViewById(R.id.password);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnLinkToRegister = (Button)findViewById(R.id.link_to_register);

        //Progress Dialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(true);

        //Login Button Click Event
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();
                //Check for empty data in the form
                if (!email.isEmpty() && !password.isEmpty()){
                    //login user
                    checkLogin(email, password);
                    progressDialog.setMessage("Loading...");
                    progressDialog.show();
                }else{
                    //Prompt user to enter credentials
                    progressDialog.cancel();
                    Toast.makeText(LoginActivity.this, "Please enter your credentials", Toast.LENGTH_LONG).show();
                }
            }
        });
        //Link to Registration Screen
        btnLinkToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void checkLogin(final String email, final String password){
        ParseUser.logInInBackground(email, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (user != null){
                    System.out.println("Logged in successfully");

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }else{
                    System.out.println(e);
                    progressDialog.cancel();
                    Toast.makeText(LoginActivity.this, "Incorrect username/password", Toast.LENGTH_LONG).show();

                }

            }
        });
    }


}
