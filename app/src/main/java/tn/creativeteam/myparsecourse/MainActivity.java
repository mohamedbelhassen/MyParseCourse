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
        query.getInBackground("fFDrV82exD", (post, e) -> {
            if (e == null) {
                //post.remove("numComments");
                //post.deleteInBackground();
                post.deleteInBackground(e1 -> {
                    if(e == null){
                        Log.d(tag,"post is well deleted");
                    }else{
                        Log.d(tag,"Error occured when deleting the post");
                    }
                });
            } else {
                Log.d(tag,"Error occured when retrieving the poqt");
            }
        });
    }
}

