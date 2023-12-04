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
        query.getInBackground("sxnqbLt4HE", new GetCallback<ParseObject>() {
            public void done(ParseObject post, ParseException e) {
                if (e == null) {
                    post.put("body","This is a new body content");
                    post.increment("numComments",1);
                    post.add("tags","updated-content");
                    //either use add or addUnique, not both of them
                    //post.addUnique("tags","my-first-post");
                    post.saveInBackground();
                } else {
                    Log.d(tag,"Error occured when retrieving the poqt");
                }
            }
        });
    }



}

