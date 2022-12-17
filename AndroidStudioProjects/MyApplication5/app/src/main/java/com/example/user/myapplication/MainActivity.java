package com.example.user.myapplication;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button b1;
    EditText e1, e2 ;
    TextView t1;
    TextToSpeech ts;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1= (Button)findViewById(R.id.button);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        t1 =(TextView)findViewById(R.id.textView2);
        ts=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
               ts.setLanguage(Locale.ENGLISH);
                ts.setSpeechRate(0.8f);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                Integer i1 = Integer.parseInt(s1);
                Integer i2 =Integer.parseInt(s2);
                Integer i3 = i1 + i2 ;
                String s3 = Integer.toString(i3);
                t1.setText(s3);
                Toast.makeText(MainActivity.this, s3,Toast.LENGTH_SHORT).show();







                ts.speak(s3,TextToSpeech.QUEUE_FLUSH,null);
            }
        });



    }
}
