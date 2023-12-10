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
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String tag="MainActivity";

        ParseUser user = new ParseUser();
        //User required Fields
        user.setUsername("Mohamed Belhassen");
        user.setPassword("123");
        user.setEmail("mohamed.belhassen@gmail.com");
        //add some optional fields according your needs
        user.put("phone", "97 100 000");
        user.put("address", "Métouia, Gabes, Tunisia");

        user.signUpInBackground(e -> {
            if (e == null) {
                Log.d(tag,"User account created successfully");
            } else {
                Log.e(tag,"Error encountered when creating user account: "+e.getMessage());
            }
        });
    }



}

