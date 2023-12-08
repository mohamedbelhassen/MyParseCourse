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

        ParseQuery<ParseObject> q1 = ParseQuery.getQuery("Player");
        q1.whereEqualTo("nationality","England");

        ParseQuery<ParseObject> q2 = ParseQuery.getQuery("Player");
        q1.whereEqualTo("marketValue",5000);
        List<ParseQuery<ParseObject>> queries = new ArrayList<ParseQuery<ParseObject>>();
        queries.add(q1);
        queries.add(q2);
        ParseQuery<ParseObject> q = ParseQuery.or(queries);

        q.countInBackground((count, e1) -> {
            if (e1 == null) {
                Log.d(tag, "Found: " + count + " players who are from England or cheap");
            }
        });
    }



}

