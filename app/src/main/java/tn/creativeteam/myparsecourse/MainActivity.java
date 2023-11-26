package tn.creativeteam.myparsecourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseRelation;
import com.parse.SaveCallback;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String tag="MainActivity";

        ParseObject post = new ParseObject("Post");
        post.put("body", "Hello, My name is Mohamed Belhassen");
        post.addAllUnique("tags", Arrays.asList("my-first-post", "welcome"));
        post.put("numComments", 0);
        ParseObject comment = new ParseObject("Comment");
        comment.put("message", "This is an awesome post with a comment");
        comment.put("parent",post);
        comment.saveInBackground(e -> {
            if( e == null){
                Log.d(tag,"**** Comment object well saved");
                //comment should be saved before adding it to comments post relation
                ParseRelation<ParseObject> comments = post.getRelation("comments");
                comments.add(comment);
                post.increment("numComments");
                post.saveInBackground();
            }else{
                Log.d(tag,"**** Error occured when saving Post object");
            }
        });
    }
}

