package tn.creativeteam.myparsecourse;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

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

        ParseUser.logInInBackground("Mohamed Belhassen", "1233", (user, e) -> {
            if (e == null) {
                Log.d(tag,"User successfully logged in");
                TextView tvEmail=findViewById(R.id.tv_email);
                tvEmail.setText(ParseUser.getCurrentUser().getEmail());
            } else {
                String error="Error: "+e.getMessage();
                Log.e(tag,error);
                showAlertDialog("Login Error",error,"Ok");
            }
        });
    }

    private void showAlertDialog(String Title, String Message, String buttonText)
    {
        AlertDialog.Builder alertDBuilder= new AlertDialog.Builder(this);
        alertDBuilder.setMessage(Message)
                .setCancelable(false)
                .setTitle(Title)
                .setPositiveButton(buttonText, (dialogInterface, i) -> {
                    dialogInterface.dismiss();
                    finish();});
        AlertDialog alertDialog= alertDBuilder.create();
        alertDialog.show();
    }



}

