package tn.creativeteam.myparsecourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.parse.ParseObject;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParseObject post = new ParseObject("Post");
        post.put("body", "Hello, My name is Mohamed");
        post.addAllUnique("tags", Arrays.asList("my-first-post", "welcome"));
        post.put("numComments", 0);
        post.saveInBackground();
    }
}