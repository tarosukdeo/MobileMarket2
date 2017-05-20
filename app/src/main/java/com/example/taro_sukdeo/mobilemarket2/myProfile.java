package com.example.taro_sukdeo.mobilemarket2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.parse.Parse;
import com.parse.ParseFile;
import com.parse.ParseUser;

/**
 * Created by taro_sukdeo on 2017/05/18.
 */
public class myProfile extends Activity {
    private TextView userName;
    private TextView fullName;
    private TextView phoneNumber;
    private Button logout;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_profile);

        userName = (TextView)findViewById(R.id.viewUserName);
        fullName =(TextView)findViewById(R.id.viewFullName);
        phoneNumber = (TextView)findViewById(R.id.viewPhoneNumber);

        ParseUser currentUser = ParseUser.getCurrentUser();
        String user = currentUser.getUsername();
        String name = currentUser.getString("FullName");
        String phone = currentUser.getString("PhoneNumber");

        userName.setText(user);
        fullName.setText(name);
        phoneNumber.setText(phone);

        logout = (Button)findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOut();
                ParseUser currentUser = ParseUser.getCurrentUser();

                Intent intent = new Intent(myProfile.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}
