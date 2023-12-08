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

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Team");
        query.whereEqualTo("code", "MCFC");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> teamList, ParseException e) {
                if (e == null) {
                    Log.d(tag, "Retrieved Teams" + teamList.size() + " teams");
                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });

    }



}

