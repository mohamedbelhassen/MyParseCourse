package tn.creativeteam.myparsecourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseRelation;
import com.parse.SaveCallback;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String tag="MainActivity";

        ParseObject post = ParseObject.createWithoutData("Post","ULDUvxFrd9");
        ParseObject comment = new ParseObject("Comment");
        comment.put("message", "This is just another comment ");
        comment.put("parent",post);
        comment.saveInBackground(e1 -> {
            if( e1 == null){
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

