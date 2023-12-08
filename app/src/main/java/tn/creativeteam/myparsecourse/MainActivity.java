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
        query.setLimit(10);
        query.setSkip(30);
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> playerList, ParseException e) {
                if (e == null) {
                    Log.d(tag, "Retrieved Players: " + playerList.size() + " players");
                    for (ParseObject player: playerList){
                        Log.d(tag, "Name: " + player.getString("name") +
                                        " is a player having a market value of : " +
                                        player.getInt("marketValue") +
                                        " ,Position: "+ player.getString("position"));
                    }
                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });

    }



}

