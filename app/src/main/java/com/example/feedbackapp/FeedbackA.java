package com.example.feedbackapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedbackA extends AppCompatActivity implements View.OnClickListener {

    private Button send, cancle;
    private EditText email, feedback;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);


        inOne();


    }
    public void inOne(){
        send = findViewById(R.id.send);
        cancle = findViewById(R.id.cancle);

        email = findViewById(R.id.emailedittextId);
        feedback = findViewById(R.id.journeyeditTextId);

        send.setOnClickListener(this);
        cancle.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


        try{
            String name = email.getText().toString();
            String message = feedback.getText().toString();


            switch (v.getId()){
                case R.id.send:
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/email");// this is new
                    intent.addCategory(Intent.CATEGORY_DEFAULT);
                    // this extra email means that we sent email to the developer
                    intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"asif15-1021@diu.edu.bd"});
                    intent.putExtra(Intent.EXTRA_SUBJECT,"feedBack confirmation ");
                    intent.putExtra(Intent.EXTRA_TEXT,"Name : " + name +
                            "\n" + "message : " + message);
                    // this extra package name is only for exprement 
                    intent.putExtra(Intent.EXTRA_PACKAGE_NAME,"com.example.feedbackapp");
                    startActivity(Intent.createChooser(intent,"feedback choose ap"));
                    break;

                case R.id.cancle:
                    email.setText("");
                    feedback.setText("");
                    break;
            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),
                    "please fill the form ",Toast.LENGTH_SHORT).show();


        }




    }
}
