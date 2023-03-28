package com.example.internationalmorsecode;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    String[]  item = {"INCLUDING SPECIAL SIGNALS","NOT INCLUDING SPECIAL SIGNALS"};
    String[]  item2 = {"ALPHABET TO SIGNAL","SIGNAL TO ALPHABET","RANDOM"};

    String a[][]= new String[47][3];

    AutoCompleteTextView autoCompleteTextView, autoCompleteTextView2;

    ArrayAdapter<String> adapteritems,adapteritems2;

    String errormessage,ans="";
    int iteration=0,j=0,q=0;

    int select1=-1, select2=-1,reset1=0,numOfQues=0;

    int choice1=0,choice2=0,random1=0,countcorrect=0;
    Button start,check;
    double time1, time2,timsum=0,timeavg=0;

    int execution=0;

    boolean startenable=true,checkenable=false;
    TextView question,remarks,noq;
    EditText numberofquestion,answer;

    ForegroundColorSpan fcsred = new ForegroundColorSpan(Color.RED);
    ForegroundColorSpan fcsgreen = new ForegroundColorSpan(Color.GREEN);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        setupUIviews();
        fill();

        adapteritems=new ArrayAdapter<String>(this,R.layout.list_itam,item);
        adapteritems2=new ArrayAdapter<String>(this,R.layout.list_itam,item2);

        autoCompleteTextView.setAdapter(adapteritems);
        autoCompleteTextView2.setAdapter(adapteritems2);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                select1=i;

                //String item = adapterView.getItemAtPosition(i).toString();
                //Toast.makeText(MainActivity4.this, "selected ="+item, Toast.LENGTH_SHORT).show();
            }
        });

        autoCompleteTextView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                select2=i;

                //String item2 = adapterView.getItemAtPosition(i).toString();
                //Toast.makeText(MainActivity4.this, "selected2 ="+item2, Toast.LENGTH_SHORT).show();
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(reset1==1)
                {
                    reset();

                }
                else if (startenable==false)
                {
                    Toast.makeText(MainActivity4.this, "BUTTON UNAVAILABLE", Toast.LENGTH_SHORT).show();

                }
                else
                {


                    if ((select1 == -1 || select2 == -1 || (numberofquestion.getText().toString()).equals("")) && startenable == true) {
                        if (select1 == -1 && select2 == -1 && (numberofquestion.getText().toString()).equals("")) {
                            errormessage = "ERROR: ALL FIELDS NOT FILLED";
                            SpannableString ss = new SpannableString(errormessage);


                            ss.setSpan(fcsred, 0, errormessage.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                            remarks.setText(ss);
                        } else if (select1 == -1 && select2 == -1 && ((numberofquestion.getText().toString()).equals("") == false)) {
                            errormessage = "ERROR: SPECIAL SIGNALS AND PRACTICE MODE NOT FILLED";
                            SpannableString ss = new SpannableString(errormessage);


                            ss.setSpan(fcsred, 0, errormessage.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                            remarks.setText(ss);

                        } else if (select1 == -1 && select2 != -1 && (numberofquestion.getText().toString()).equals("")) {
                            errormessage = "ERROR: SPECIAL SIGNALS AND NUMBER OF QUESTIONS NOT FILLED";
                            SpannableString ss = new SpannableString(errormessage);


                            ss.setSpan(fcsred, 0, errormessage.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                            remarks.setText(ss);

                        } else if (select1 == -1 && select2 != -1 && ((numberofquestion.getText().toString()).equals("") == false)) {
                            errormessage = "ERROR: SPECIAL SIGNALS NOT FILLED";
                            SpannableString ss = new SpannableString(errormessage);


                            ss.setSpan(fcsred, 0, errormessage.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                            remarks.setText(ss);

                        } else if (select1 != -1 && select2 == -1 && (numberofquestion.getText().toString()).equals("")) {
                            errormessage = "ERROR: PRACTICE MODE AND NUMBER OF QUESTIONS NOT FILLED";
                            SpannableString ss = new SpannableString(errormessage);


                            ss.setSpan(fcsred, 0, errormessage.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                            remarks.setText(ss);

                        } else if (select1 != -1 && select2 == -1 && ((numberofquestion.getText().toString()).equals("") == false)) {
                            errormessage = "ERROR: PRACTICE MODE NOT FILLED";
                            SpannableString ss = new SpannableString(errormessage);


                            ss.setSpan(fcsred, 0, errormessage.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                            remarks.setText(ss);

                        } else if (select1 != -1 && select2 != -1 && (numberofquestion.getText().toString()).equals("")) {
                            errormessage = "ERROR: NUMBER OF QUESTIONS NOT FILLED";
                            SpannableString ss = new SpannableString(errormessage);


                            ss.setSpan(fcsred, 0, errormessage.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                            remarks.setText(ss);

                        }

                    } else {
                        if ((Integer.parseInt(numberofquestion.getText().toString()) <= 0) && startenable == true) {
                            errormessage = "ERROR: INVALID NUMBER OF QUESTIONS";
                            SpannableString ss = new SpannableString(errormessage);


                            ss.setSpan(fcsred, 0, errormessage.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                            remarks.setText(ss);

                        } else if ((Integer.parseInt(numberofquestion.getText().toString()) > 30) && startenable == true) {
                            errormessage = "ERROR: MAXIMUM NUMBER OF QUESTION IS 30";
                            SpannableString ss = new SpannableString(errormessage);


                            ss.setSpan(fcsred, 0, errormessage.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                            remarks.setText(ss);

                        } else {
                            if (startenable == true) {
                                errormessage = "GOOD LUCK!!";
                                SpannableString ss = new SpannableString(errormessage);


                                ss.setSpan(fcsgreen, 0, errormessage.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                                remarks.setText(ss);
                                numOfQues=Integer.parseInt(numberofquestion.getText().toString());

                                iteration = 1;
                                startenable = false;
                                checkenable = true;
                                choice1=select1;
                                choice2=select2;
                                execution=1;



                                switch (choice2) {
                                    case 0:
                                        alphatosignal(choice1, numOfQues, iteration, j, ans);
                                        break;
                                    case 1:
                                        signaltoalpha(choice1, numOfQues, iteration, j, ans);
                                    break;
                                    case 2:random(choice1, numOfQues, iteration, j, ans);
                                    break;
                                }


                            }


                        }
                    }
                }
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkenable==false)
                {
                    Toast.makeText(MainActivity4.this, "BUTTON UNAVAILABLE", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(choice2==0 || random1==1)
                    {
                        if (j == 1) {
                            ans = answer.getText().toString();
                            alphatosignal(choice1, numOfQues, iteration, j, ans);
                            iteration++;
                            check.setText("NEXT");
                            random1=0;
                        } else if (j == 0) {
                            check.setText("CHECK");
                            remarks.setText("");
                            alphatosignal(choice1, numOfQues, iteration, j, "");
                        }
                    }
                    else if (choice2==1  || random1==2)
                    {
                        if (j == 1) {
                            ans = answer.getText().toString();
                            signaltoalpha(choice1, numOfQues, iteration, j, ans);
                            iteration++;
                            check.setText("NEXT");
                            random1=0;
                        } else if (j == 0) {
                            check.setText("CHECK");
                            remarks.setText("");
                            signaltoalpha(choice1, numOfQues, iteration, j, "");
                        }
                    }
                    else if (choice2==2)
                    {
                        remarks.setText("");
                        random(choice1, numOfQues, iteration, j, "");

                    }
                }

            }
        });


    }

    @Override
    public void onBackPressed() {
        if(execution==0)
        super.onBackPressed();
        else
        {
            AlertDialog.Builder alertdialog = new AlertDialog.Builder(MainActivity4.this);
            alertdialog.setTitle("EXIT PRACTICE SESSION");
            alertdialog.setMessage("Do you want to exit in between practice?");
            alertdialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i)
                {
                    //execution=0;
                    //onBackPressed();
                    MainActivity4.super.onBackPressed();
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
    }

    void alphatosignal(int c1, int b1, int j1, int j2, String ans2)
    {
        ans2=ans2.trim();
        String remarks2="";
        int range=0;

        if(j2==1)
        {
            time2=System.currentTimeMillis();
            if(ans2.equals(""))
            {
                remarks2="INCORRECT \n CORRECT ANSWER = "+a[q][1];
                SpannableString ss = new SpannableString(remarks2);
                ss.setSpan(fcsred,0,remarks2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                remarks.setText(ss);
            }
            else if(ans2.equals(a[q][1]))
            {
                remarks2="CORRECT";

                SpannableString ss = new SpannableString(remarks2);
                ss.setSpan(fcsgreen,0,remarks2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                remarks.setText(ss);
                countcorrect++;
            }
            else
            {
                remarks2="INCORRECT \n CORRECT ANSWER = "+a[q][1];

                SpannableString ss = new SpannableString(remarks2);
                ss.setSpan(fcsred,0,remarks2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                remarks.setText(ss);
            }

            timsum=timsum+(time2-time1);

            j=0;
        }
        else
        {
            if(c1==1)
            {
                range=36;
            }
            else
            {
                range=47;
            }

            if(j1<=b1)
            {
                q=(int)(0+(Math.random()*range));
                answer.setText("");//new
                question.setText("Q) "+a[q][0]+" ("+j1+"/"+b1+")");
                j=1;
                time1=System.currentTimeMillis();
            }
            else
            {
                //timeavg=(timsum/numOfQues)/1000.0;
                timeavg=roundtime((timsum/numOfQues)/1000.0);
                answer.setText("");
                question.setText("");
                execution=0;
                remarks.setText("QUESTIONS COMPLETED    \n AVERAGE TIME TAKEN PER QUESTION = "+timeavg+"s \n CORRECT ANSWER ="+countcorrect+"/"+numOfQues);
                checkenable=false;
                start.setText("RESET");
                reset1=1;
            }
        }


    }

    void signaltoalpha(int c1,int b1,int j1,int j2,String ans2)
    {
        ans2=ans2.trim();
        String remarks2="";
        int range=0;

        if(j2==1)
        {
            time2=System.currentTimeMillis();
            if(ans2.equals(""))
            {
                remarks2="INCORRECT \n CORRECT ANSWER = "+a[q][0];
                SpannableString ss = new SpannableString(remarks2);
                ss.setSpan(fcsred,0,remarks2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                remarks.setText(ss);
            }
            else if(ans2.equalsIgnoreCase(a[q][0]) || ans2.equalsIgnoreCase(a[q][2]))
            {
                remarks2="CORRECT";

                SpannableString ss = new SpannableString(remarks2);
                ss.setSpan(fcsgreen,0,remarks2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                remarks.setText(ss);
                countcorrect++;
            }
            else
            {
                remarks2="INCORRECT \n CORRECT ANSWER = "+a[q][0];

                SpannableString ss = new SpannableString(remarks2);
                ss.setSpan(fcsred,0,remarks2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                remarks.setText(ss);
            }
            timsum=timsum+(time2-time1);
            j=0;
        }
        else
        {
            if(c1==1)
            {
                range=36;
            }
            else
            {
                range=47;
            }

            if(j1<=b1)
            {
                q=(int)(0+(Math.random()*range));
                answer.setText("");//new
                question.setText("Q) "+a[q][1]+" ("+j1+"/"+b1+")");
                j=1;
                time1=System.currentTimeMillis();
            }
            else
            {
                //timeavg=(timsum/numOfQues)/1000.0;
                timeavg=roundtime((timsum/numOfQues)/1000.0);
                answer.setText("");
                question.setText("");
                execution=0;
                remarks.setText("QUESTIONS COMPLETED    \n AVERAGE TIME TAKEN PER QUESTION = "+timeavg+"s \n CORRECT ANSWER ="+countcorrect+"/"+numOfQues);
                checkenable=false;
                start.setText("RESET");
                reset1=1;
            }
        }
    }
    void random(int c1,int b1,int j1,int j2,String ans2)
    {
        //int i1=1;
        check.setText("CHECK");
        if(j1<=b1)
        {
            int choice= 0+(int)(Math.random()*10);
            if(choice<=4)
            {
                random1=1;

                alphatosignal(c1,b1,j1,j2,ans2);
            }
            else
            {
                random1=2;
                signaltoalpha(c1,b1,j1,j2,ans2);
            }

        }
        if(j1>b1)
        {
            //timeavg=(timsum/numOfQues)/1000.0;
            timeavg=roundtime((timsum/numOfQues)/1000.0);
            answer.setText("");
            question.setText("");
            execution=0;
            remarks.setText("QUESTIONS COMPLETED    \n AVERAGE TIME TAKEN PER QUESTION = "+timeavg+"s \n CORRECT ANSWER ="+countcorrect+"/"+numOfQues);
            checkenable=false;
            start.setText("RESET");
            reset1=1;
        }
    }
    private void setupUIviews()
    {
        autoCompleteTextView=findViewById(R.id.autocompletetextview);
        autoCompleteTextView2=findViewById(R.id.autocompletetextview2);
        numberofquestion=findViewById(R.id.editTextNumber3);
        //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);
        start=findViewById(R.id.button7);
        question=findViewById(R.id.textView14);
        question.setMovementMethod(new ScrollingMovementMethod());
        question.setHorizontallyScrolling(true);
        noq=findViewById(R.id.textView4);
        noq.setMovementMethod(new ScrollingMovementMethod());
        noq.setHorizontallyScrolling(true);
        answer=findViewById(R.id.editTextTextPersonName2);
        //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);
        //getWindow().setSoftInputMode(WindowManager.LayoutParams.FLAG_LOCAL_FOCUS_MODE);
        check=findViewById(R.id.button5);
        remarks=findViewById(R.id.textView11);
        remarks.setMovementMethod(new ScrollingMovementMethod());

    }
    private void setupUIviews2()
    {
        autoCompleteTextView=findViewById(R.id.autocompletetextview);
        autoCompleteTextView2=findViewById(R.id.autocompletetextview2);
        numberofquestion=findViewById(R.id.editTextNumber3);
        //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);
        start=findViewById(R.id.button7);
        question=findViewById(R.id.textView14);
        question.setMovementMethod(new ScrollingMovementMethod());
        question.setHorizontallyScrolling(true);
        noq=findViewById(R.id.textView4);
        noq.setMovementMethod(new ScrollingMovementMethod());
        noq.setHorizontallyScrolling(true);
        answer=findViewById(R.id.editTextTextPersonName2);
        //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);
        check=findViewById(R.id.button5);
        remarks=findViewById(R.id.textView11);
        remarks.setMovementMethod(new ScrollingMovementMethod());



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
    void reset()
    {
        reset1=0;
        start.setText("START");
        startenable=true;
        checkenable=false;
        iteration=0;
        j=0;
        q=0;
        question.setText("");
        remarks.setText("");
        random1=0;
        check.setText("CHECK");
        timeavg=0;
        timsum=0;
        time2=0;
        time1=0;
        countcorrect=0;
        //select1=-1;
        //select2=-1;

        answer.setText("");//new
        numberofquestion.setText("");//new

        execution=0;

    }

    double roundtime(double time)
    {
        time=time*1000;
        time=Math.round(time);
        time=time/1000;
        return time;
    }
}