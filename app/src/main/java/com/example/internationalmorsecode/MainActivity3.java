package com.example.internationalmorsecode;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    Spinner spinner;
    TextView printingarea;
    Button b1;
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapteritems;

    String menu[] = {"INCLUDING SPECIAL SIGNALS", "NOT INCLUDING SPECIAL SIGNALS"};
    int pos=-1;
    String a[][]= new String[47][3];
    ForegroundColorSpan fcsred = new ForegroundColorSpan(Color.RED);
    void fill()
    {
        int i;
        char ch=65;
        for(i=0;i<26;i++)
        {
            a[i][0]=Character.toString(ch);
            ch++;
            a[i][2]="";
        }
        a[26][0]="1";
        a[27][0]="2";
        a[28][0]="3";
        a[29][0]="4";
        a[30][0]="5";
        a[31][0]="6";
        a[32][0]="7";
        a[33][0]="8";
        a[34][0]="9";
        a[35][0]="0";
        a[0][1]=".-";
        a[1][1]="-...";
        a[2][1]="-.-.";
        a[3][1]="-..";
        a[4][1]=".";
        a[5][1]="..-.";
        a[6][1]="--.";
        a[7][1]="....";
        a[8][1]="..";
        a[9][1]=".---";
        a[10][1]="-.-";
        a[11][1]=".-..";
        a[12][1]="--";
        a[13][1]="-.";
        a[14][1]="---";
        a[15][1]=".--.";
        a[16][1]="--.-";
        a[17][1]=".-.";
        a[18][1]="...";
        a[19][1]="-";
        a[20][1]="..-";
        a[21][1]="...-";
        a[22][1]=".--";
        a[23][1]="-..-";
        a[24][1]="-.--";
        a[25][1]="--..";
        a[26][1]=".----";
        a[27][1]="..---";
        a[28][1]="...--";
        a[29][1]="....-";
        a[30][1]=".....";
        a[31][1]="-....";
        a[32][1]="--...";
        a[33][1]="---..";
        a[34][1]="----.";
        a[35][1]="-----";
        a[36][0]="Calling Sign";
        a[37][0]="General Answer";
        a[38][0]="Message Received";
        a[39][0]="Good Bye";
        a[40][0]="Word After";
        a[41][0]="Carry On";
        a[42][0]="Full Stop";
        a[43][0]="End of Message";
        a[44][0]="Block Letters";
        a[45][0]="Word Before";
        a[46][0]="Wait";
        //short form
        a[36][2]="VE";
        a[37][2]="A";
        a[38][2]="R";
        a[39][2]="GB";
        a[40][2]="WA";
        a[41][2]="K";
        a[42][2]="AAA";
        a[43][2]="AR";
        a[44][2]="UK";
        a[45][2]="WB";
        a[46][2]="Q";
        //signals
        a[36][1]="...-.";
        a[37][1]=".-";
        a[38][1]=".-.";
        a[39][1]="--.-...";
        a[40][1]=".--.-";
        a[41][1]="-.-";
        a[42][1]=".-.-.-";
        a[43][1]=".-.-.";
        a[44][1]="..--.-";
        a[45][1]=".---...";
        a[46][1]="--.-";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setupUIviews();
        fill();

        adapteritems=new ArrayAdapter<String>(this,R.layout.list_itam,menu);
        autoCompleteTextView.setAdapter(adapteritems);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                pos=i;
            }
        });
/*
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(MainActivity3.this, android.R.layout.simple_spinner_item,menu);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //String value = adapterView.getItemAtPosition(i).toString();
                pos=i;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

 */

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                printingarea.scrollTo(0,0);
                display();
            }
        });






    }

    private void setupUIviews()
    {
        autoCompleteTextView=findViewById(R.id.autocompletetextview);
        //spinner=findViewById(R.id.spinner);
        b1=findViewById(R.id.printbutton);
        printingarea= findViewById(R.id.textView6);
        printingarea.setMovementMethod(new ScrollingMovementMethod());


    }

    void display()
    {
        String printing ="";
        int i;
        if(pos==-1)
        {
            String error ="ERROR: INPUT NOT SELECTED";
            SpannableString ss = new SpannableString(error);
            ss.setSpan(fcsred,0,error.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            printingarea.setText(ss);
            return;
        }
        if(pos==0)
        {
            printing="ALPHABET \t MORSE CODE \n";
            for(i=0;i<26;i++)
            {
                printing=printing+a[i][0]+" \t\t\t\t\t\t\t "+a[i][1]+"\n";
            }
            printing=printing+"DIGITS \t MORSE CODE \n";
            for(i=26;i<36;i++)
            {
                printing=printing+a[i][0]+" \t\t\t\t\t\t\t "+a[i][1]+"\n";
            }

            printing=printing+"NAME OF SIGNAL \t CODE IN ALPHABET \t MORSE CODE"+"\n";
            for(i=36;i<47;i++)
            {
                printing=printing+a[i][0]+" \t "+a[i][2]+" \t "+a[i][1]+"\n";
            }

        }
        else if (pos==1)
        {
            printing="ALPHABET \t MORSE CODE \n";
            for(i=0;i<26;i++)
            {
                printing=printing+a[i][0]+" \t\t\t\t\t\t\t "+a[i][1]+"\n";
            }
            printing=printing+"DIGITS \t MORSE CODE \n";
            for(i=26;i<36;i++)
            {
                printing=printing+a[i][0]+" \t\t\t\t\t\t\t "+a[i][1]+"\n";
            }



        }
        printingarea.setText(printing);
        printingarea.setMovementMethod(new ScrollingMovementMethod());
    }

}