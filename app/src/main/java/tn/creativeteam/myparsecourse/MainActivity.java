package tn.creativeteam.myparsecourse;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.CountCallback;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;
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

        Button btn= findViewById(R.id.btnReinitPassword);
        btn.setVisibility(View.INVISIBLE);

        ParseUser.logInInBackground("Mohamed Belhassen", "123", (user, e) -> {
            if (e == null) {
                TextView tvEmail=findViewById(R.id.tv_email);
                tvEmail.setText(ParseUser.getCurrentUser().getEmail());
                btn.setVisibility(View.VISIBLE);
            } else {
                showAlertDialog("Login Error","Error: "+e.getMessage(),"Ok");
            }
        });

        btn.setOnClickListener(view -> {
            ParseUser.requestPasswordResetInBackground("mohamed.belhassen@gmail.com", e -> {
                if (e == null) {
                    showAlertDialog("Password Reset success",
                            "Please check your email to reset your password","Ok");
                } else {
                    showAlertDialog("Password Reset failure","Error: "+
                            e.getMessage(),"Ok");
                }
            });
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
                    });
        AlertDialog alertDialog= alertDBuilder.create();
        alertDialog.show();
    }



}

