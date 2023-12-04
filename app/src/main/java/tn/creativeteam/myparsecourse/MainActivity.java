package tn.creativeteam.myparsecourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseRelation;
import com.parse.SaveCallback;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    String tag="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Post");
        query.getInBackground("FmCUlJWC5h", new GetCallback<ParseObject>() {
            public void done(ParseObject post, ParseException e) {
                if (e == null) {
                    ParseRelation<ParseObject> commentsRelation = post.getRelation("comments");
                    ParseObject commentToDelete= ParseObject.createWithoutData("Comment", "jANR9CEUKq");
                    commentsRelation.remove(commentToDelete);
                    post.increment("numComments",-1);
                    post.saveInBackground(exPost->{
                        if(exPost == null){
                            Log.d(tag,"comment removed from post");
                        }else{
                            Log.d(tag,"problem occured when removing the comment from relation");
                        }
                    });

                } else {
                    Log.d(tag,"Error occured when retrieving the post");
                }
            }
        });
    }



}

