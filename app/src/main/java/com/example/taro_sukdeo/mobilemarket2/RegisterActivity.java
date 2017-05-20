package com.example.taro_sukdeo.mobilemarket2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class RegisterActivity extends Activity {
    private Button btnRegister;
    private Button btnLinkToLogin;
    private EditText inputFullName;
    private EditText inputEmail;
    private EditText inputPassword;
    private EditText inputPhoneNumber;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inputFullName = (EditText)findViewById(R.id.name);
        inputEmail = (EditText)findViewById(R.id.email);
        inputPassword = (EditText)findViewById(R.id.password);
        btnRegister = (Button)findViewById(R.id.btnRegister);
        btnLinkToLogin = (Button)findViewById(R.id.btnLinkToLoginScreen);
        inputPhoneNumber = (EditText)findViewById(R.id.PhoneNumber);

        progressDialog = new ProgressDialog(this);

        //Register Button Click event
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inputFullName.getText().toString().trim();
                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();
                String phonenumber = inputPhoneNumber.getText().toString().trim();

                if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()){
                    ParseUser user = new ParseUser();
                    user.setUsername(email);
                    user.setEmail(email);
                    user.setPassword(password);
                    user.put("PhoneNumber", phonenumber);
                    user.put("FullName", name);
                    user.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null){
                                progressDialog.setMessage("Loading");
                                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                                startActivity(intent);
                            }else{
                                System.out.print(e);
                                Toast.makeText(RegisterActivity.this, "Failed to add user!", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }else {
                    Toast.makeText(RegisterActivity.this, "Please enter your details", Toast.LENGTH_LONG).show();
                }
            }
        });

        //Link to Login Screen
        btnLinkToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
