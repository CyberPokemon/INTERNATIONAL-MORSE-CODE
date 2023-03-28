package com.example.internationalmorsecode;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    Button one;
    Button two;
    Button three;
    Button four;
    Button five;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setupUIviews();

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intant = new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(intant);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intant = new Intent(getApplicationContext(), MainActivity4.class);
                startActivity(intant);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intant = new Intent(getApplicationContext(), MainActivity5.class);
                startActivity(intant);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intant = new Intent(getApplicationContext(), MainActivity6.class);
                startActivity(intant);


                //InputMethodManager inputMethodManager= (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

                //inputMethodManager.toggleSoftInputFromWindow(Constraintlayout.getApplicationWindowToken(), InputMethodManager.SHOW_FORCED,0);

            }

        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intant = new Intent(getApplicationContext(), MainActivity7.class);
                startActivity(intant);
            }
        });


    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertdialog = new AlertDialog.Builder(MainActivity2.this);
        alertdialog.setTitle("EXIT APP");
        alertdialog.setMessage("Do you want to exit the app?");
        alertdialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finishAffinity();
            }
        });

        alertdialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        alertdialog.show();
    }

    private void setupUIviews()
    {
        one=findViewById(R.id.b1);
        two=findViewById(R.id.b2);
        three=findViewById(R.id.b3);
        four=findViewById(R.id.b4);
        five=findViewById(R.id.b6);

    }
}