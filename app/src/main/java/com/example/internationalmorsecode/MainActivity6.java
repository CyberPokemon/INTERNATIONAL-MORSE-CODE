package com.example.internationalmorsecode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity6 extends AppCompatActivity {

    String str1,str2;

    EditText t1;
    TextView t2;
    Button convert,copytext;
    String a[][]= new String[47][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        setupUIviews();
        fill();

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str1=t1.getText().toString();
                str2=convert2(str1).trim();

                t2.setText(str2);
            }
        });

        copytext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

                ClipData clip= ClipData.newPlainText("COPIED TEXT",str2);
                clipboard.setPrimaryClip(clip);

                Toast.makeText(MainActivity6.this,"COPIED",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setupUIviews()
    {
        t1=findViewById(R.id.textView9);
        convert=findViewById(R.id.button2);
        t2= findViewById(R.id.textView10);
        t2.setMovementMethod(new ScrollingMovementMethod());
        copytext=findViewById(R.id.button4);



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

    String convert2(String str)
    {
        int i,j,f;
        char ch;
        String nstr="",w="";
        str.trim();
        for(i=0;i<str.length();i++)
        {
            ch=str.charAt(i);
            if(ch==' ' || ch== '|')
            {
                f=0;
                if(w.equals("")&& ch=='|')
                {
                    nstr=nstr+" ";
                    continue;
                }
                if(w.equals(""))
                    continue;
                for(j=0;j<47;j++)
                {
                    if(a[j][1].equals(w))
                    {
                        nstr=nstr+a[j][0];
                        f=1;
                        break;
                    }
                }
                if(f!=1)
                {
                    nstr=nstr+"[notfound]";
                }
                if(ch=='|')
                {
                    nstr=nstr+" ";
                }
                w="";
            }
            else
            {
                w=w+ch;
            }
        }
        if(w.equals("")==false)
        {
            for(j=0;j<47;j++)
            {
                if(a[j][1].equals(w))
                {
                    nstr=nstr+a[j][0];
                    f=1;
                    break;
                }
            }
        }
        //if(nstr.charAt(nstr.length()-1)!='|')
        //nstr=nstr+"|";
        return nstr;
    }
}