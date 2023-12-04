package tn.creativeteam.myparsecourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

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
        post.put("body", "Hello, My name is Mohamed");
        post.addAllUnique("tags", Arrays.asList("my-first-post", "welcome"));
        post.put("numComments", 0);

        post.saveInBackground(e -> {
            if( e == null){
                Log.d(tag,"Post object well saved");
                ParseObject comment = new ParseObject("Comment");
                comment.put("message", "This is an awesome post");
                comment.put("parent",post);
                comment.saveInBackground( excepComment ->{
                    if(excepComment == null){
                        ParseRelation<ParseObject> comments = post.getRelation("comments");
                        comments.add((comment));
                        post.increment("numComments");
                        post.saveInBackground();
                    }
                });
            }else{
                Log.d(tag,"Error occured when saving Post object");
            }
        });
    }
}

