package com.example.taro_sukdeo.mobilemarket2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.parse.*;

/**
 * Created by taro_sukdeo on 2017/05/18.
 */
public class postNewAd extends Activity {
    private EditText postItemName;
    private EditText postItemDesc;
    private EditText postItemPrice;
    private Button postNewAd;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_new_ad);

        postItemName = (EditText)findViewById(R.id.postitemName);
        postItemDesc = (EditText)findViewById(R.id.postitemDescription);
        postItemPrice = (EditText)findViewById(R.id.postitemPrice);

        postNewAd = (Button)findViewById(R.id.postAd);
        postNewAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = postItemName.getText().toString().trim();
                String itemDesc = postItemDesc.getText().toString().trim();
                int itemPrice = postItemPrice.getInputType();


                if (!itemName.isEmpty() && !itemDesc.isEmpty()) {
                    ParseObject item = new ParseObject("Items");
                    item.put("itemName", itemName);
                    item.put("itemDesc", itemDesc);
                    item.put("itemPrice", itemPrice);
                    ParseUser currentuser = ParseUser.getCurrentUser();
                    String id = currentuser.getString("FullName");
                    item.put("postedBy", id);
                    item.saveInBackground();
                    Toast.makeText(postNewAd.this, "Ad Successfully posted!", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(postNewAd.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(postNewAd.this, "Please try again", Toast.LENGTH_LONG).show();
                }
            }

        });

    }
}
