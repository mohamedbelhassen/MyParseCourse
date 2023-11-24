package tn.creativeteam.myparsecourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String tag="MainActivity";

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Post");
        query.getInBackground("fFDrV82exD", new GetCallback<ParseObject>() {
            public void done(ParseObject post, ParseException e) {
                if (e == null) {
                    Log.d(tag,"Object well retrieved: ");
                    Log.d(tag,"Post Body: "+post.getString("body"));
                    Log.d(tag,"Post Tags: "+post.getJSONArray("tags"));
                    Log.d(tag,"Post numComments: "+post.getInt("numComments"));
                } else {
                    Log.d(tag,"Error occured when retrieving the poqt");
                }
            }
        });
    }


}

