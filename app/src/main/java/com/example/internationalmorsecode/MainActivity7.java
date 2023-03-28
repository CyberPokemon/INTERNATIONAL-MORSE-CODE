package com.example.internationalmorsecode;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class MainActivity7 extends AppCompatActivity {

    TextView t1,link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        setupUIviews();

        String des="THIS IS AN APP BASED ON INTERNATIONAL MORSE CODE \n THIS APP CONTAINS THE INTERNATIONAL MORSE CODE CHART \n IT ALSO CONTAINS A PRACTICE MODE TO TEST THE SKILL OF IDENTIFYING MORSE CODE \n THIS APP ALSO HAVE A FEATURE OF CONVERTING SENTENCE TO MORSE CODE AND VICE VERSA";
        t1.setText(des);

        link.setMovementMethod(LinkMovementMethod.getInstance());

        link.setLinkTextColor(Color.BLUE);


    }

    private void setupUIviews()
    {
        t1=findViewById(R.id.textView19);
        t1.setMovementMethod(new ScrollingMovementMethod());
        link=findViewById(R.id.textView23);
    }
}