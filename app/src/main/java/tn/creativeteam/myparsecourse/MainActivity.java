package tn.creativeteam.myparsecourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String tag="MainActivity";

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Player");
        query.whereLessThan("marketValue", 1500);
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> playerList, ParseException e) {
                if (e == null) {
                    Log.d(tag, "Retrieved Players: " + playerList.size() + " players");
                    for (ParseObject player: playerList){
                        Log.d(tag, "Name: " + player.getString("name") +
                                        " has a market value <1.5M : " +player.getInt("marketValue"));
                    }
                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });

    }



}

