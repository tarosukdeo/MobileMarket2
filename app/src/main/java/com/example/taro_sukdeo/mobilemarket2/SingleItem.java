package com.example.taro_sukdeo.mobilemarket2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;


public class SingleItem extends Activity {
    private TextView singleItemName;
    private TextView singleItemDesc;
    private TextView singleItemPrice;
    private TextView seller;
    private TextView avgRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_item);
//        Intent intent = getIntent();
//        String s = intent.getExtras().getString("item");


        singleItemName = (TextView)findViewById(R.id.tv1);
        singleItemDesc = (TextView)findViewById(R.id.tv2);
        singleItemPrice = (TextView)findViewById(R.id.tv3);
        seller = (TextView)findViewById(R.id.tv4);
        avgRating = (TextView)findViewById(R.id.tv5);

//        ParseQuery<ParseObject> query = ParseQuery.getQuery("Items");
//        query.getInBackground("D162V9gA9A", new GetCallback<ParseObject>() {
//            @Override
//            public void done(ParseObject object, ParseException e) {
//                if (e == null){
//                    String itemName = object.getString("itemName");
//                    String itemDesc = object.getString("itemDesc");
//                    int itemPrice = object.getInt("itemPrice");
//                    String postedBy = object.getString("postedBy");
//                    int numRatings = object.getInt("numRatings");
//
//                    singleItemName.setText(itemName);
//                    singleItemDesc.setText(itemDesc);
////                    singleItemPrice.setText(itemPrice);
//                    seller.setText(postedBy);
//                    avgRating.setText(numRatings);
//                }else{
//                    Log.e("Something went wrong!", e.getMessage());
//                    e.getStackTrace();
//                    e.printStackTrace();
//                }
//            }
//        });




    }

}
