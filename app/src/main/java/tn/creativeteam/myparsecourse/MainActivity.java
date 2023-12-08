package tn.creativeteam.myparsecourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.parse.CountCallback;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String tag="MainActivity";

        ParseQuery<ParseObject> expensiveTeamQuery = ParseQuery.getQuery("Team");
        expensiveTeamQuery.whereGreaterThan("squadMarketValue",100000);
        ArrayList <String> teamCodes= new ArrayList();
        expensiveTeamQuery.findInBackground((teamList, e) -> {
            if (e == null) {
                Log.d(tag, "Retrieved Teams: " + teamList.size() + " teams");
                for (ParseObject team: teamList){
                    teamCodes.add(team.getString("code"));
                }
                ParseQuery<ParseObject> playerQuery = ParseQuery.getQuery("Player");
                playerQuery.whereContainedIn("teamCode",teamCodes);
                playerQuery.countInBackground((count, e1) -> {
                    if (e1 == null) {
                        Log.d(tag, " Number of players belonging to expensive teams : " + count + " players");
                    }
                });
            } else {
                Log.d(tag, "Error: " + e.getMessage());
            }
        });

    }



}

