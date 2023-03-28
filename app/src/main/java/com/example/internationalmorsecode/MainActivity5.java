package com.example.internationalmorsecode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {

    String str1,str2;
    EditText t1;
    TextView t2;

    Button b1,b2;

    String a[][]= new String[47][3];

    ForegroundColorSpan fcsred = new ForegroundColorSpan(Color.RED);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);


        setupUIviews();
        fill();





        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                str1=t1.getText().toString();
                str1=str1.trim();


                str2=convert(str1);

                if(str2.equals("ERROR: TEXT NOT INPUTED"))
                {
                    SpannableString ss = new SpannableString(str2);


                    ss.setSpan(fcsred, 0, str2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    t2.setText(ss);
                }
                else
                t2.setText(str2);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

                ClipData clip= ClipData.newPlainText("COPIED TEXT",str2);
                clipboard.setPrimaryClip(clip);

                Toast.makeText(MainActivity5.this,"COPIED",Toast.LENGTH_SHORT).show();
            }
        });

        t2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

                ClipData clip= ClipData.newPlainText("COPIED TEXT",str2);
                clipboard.setPrimaryClip(clip);

                Toast.makeText(MainActivity5.this,"COPIED",Toast.LENGTH_SHORT).show();

                return true;
            }
        });




    }

    String convert(String str)
    {
        String nstr="";
        if(str.equals(""))
        {
            return "ERROR: TEXT NOT INPUTED";
        }
        str=" "+str;
        int l =str.length();
        int i;
        char ch;
        for(i=0;i<l;i++)
        {
            ch=str.charAt(i);
            if(ch==' ')
            {
                nstr=nstr+"|";
            }
            else
            {
                ch=Character.toUpperCase(ch);
                if(ch>64 && ch <91)
                {
                    nstr=""+nstr+a[(ch-65)][1]+" ";
                }
                else if(ch>=49 && ch<=57)
                {
                    nstr=""+nstr+a[(int)ch-23][1]+" ";
                }
                else if(ch==48)
                {
                    nstr=""+nstr+a[35][1]+" ";
                }
                else if(ch=='.')
                {
                    //new
                    nstr=""+nstr+a[42][1]+" ";
                }
                else
                {
                    nstr=""+nstr+"not found"+" ";
                }
            }
        }
        nstr=nstr+"|";
        return nstr;
    }
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

    private void setupUIviews()
    {
        t1=findViewById(R.id.editTextTextPersonName);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);
        b1=findViewById(R.id.button);
        t2= findViewById(R.id.textView7);
        t2.setMovementMethod(new ScrollingMovementMethod());
        b2=findViewById(R.id.button3);


    }



}