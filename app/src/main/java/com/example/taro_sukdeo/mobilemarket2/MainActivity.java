package com.example.taro_sukdeo.mobilemarket2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.parse.*;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by taro_sukdeo on 2017/05/18.
 */
public class MainActivity extends Activity {
    ArrayList<item> items = new ArrayList<>();
    EditText inputSearch;
    ListView listView;




    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//        public void get_items() {
//            ParseQuery<ParseObject> itemQuery = ParseQuery.getQuery("Items");
//            itemQuery.findInBackground(new FindCallback<ParseObject>() {
//                @Override
//                public void done(List<ParseObject> objects, ParseException e) {
//                    if (e == null) {
//                        //query was successful
//                        for (int i = 0; i < objects.size(); i++) {
//                            item newItem = new item();
//                            ParseObject currObj = objects.get(i);
//                            newItem.objectId = currObj.getObjectId();
//                            newItem.itemName = currObj.getString("itemName");
//                            System.out.println("Item name " + newItem.itemName);
//                            newItem.itemDescription = currObj.getString("itemDesc");
//                            newItem.itemPrice = currObj.getDouble("itemPrice");
//                            newItem.itemRating = currObj.getDouble("itemRating");
//                            newItem.numRating = currObj.getInt("numRating");
//                            items.add(newItem);
//                        }
//                    }else{
//                        Toast.makeText(MainActivity.this, "Something went wrong, please try again", Toast.LENGTH_LONG).show();
//                    }
//
//                }
//            });
//



        ParseQueryAdapter<ParseObject> adapter = new ParseQueryAdapter<>(this, "Items");
        adapter.setTextKey("itemName");


        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setClickable(true);
        inputSearch = (EditText) findViewById(R.id.inputSearch);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                parent.getAdapter().getItem(position);

                String s = listView.getItemAtPosition(position).toString();
                System.out.println(s);


                Intent intent = new Intent(MainActivity.this, SingleItem.class);
                intent.putExtra("item", s);
                startActivity(intent);
            }
        });


        final Button postNewAd = (Button) findViewById(R.id.postAd);
        postNewAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, postNewAd.class);
                startActivity(intent);
            }
        });

        final Button myProfile = (Button) findViewById(R.id.myProfile);
        myProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.taro_sukdeo.mobilemarket2.myProfile.class);
                startActivity(intent);
            }
        });


    }

}








