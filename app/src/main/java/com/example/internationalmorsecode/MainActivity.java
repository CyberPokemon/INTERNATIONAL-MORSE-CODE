package com.example.internationalmorsecode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i1 = new Intent(getApplicationContext(), MainActivity2.class);

        button=findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(getApplicationContext(),"HELLO WORLD", Toast.LENGTH_SHORT).show();
                Intent intant = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intant);
            }
        });



    }
}