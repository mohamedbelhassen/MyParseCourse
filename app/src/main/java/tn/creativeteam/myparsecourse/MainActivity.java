package tn.creativeteam.myparsecourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String tag="MainActivity";
        ParseObject post = new ParseObject("Post");
        post.put("body", "Hello, My name is Mohamed");
        post.addAllUnique("tags", Arrays.asList("my-first-post", "welcome"));
        post.put("numComments", 0);
        post.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if( e == null){
                    Log.d(tag,"Post object well saved");
                }else{
                    Log.d(tag,"Error occured when saving Post object");
                }
            }
        });
    }
}

