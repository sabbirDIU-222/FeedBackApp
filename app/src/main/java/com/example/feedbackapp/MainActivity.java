package com.example.feedbackapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.feedback,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.shareappId:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL,"islamsaimun1913@gmail.com");
                intent.putExtra(Intent.EXTRA_SUBJECT,"Share App");
                intent.putExtra(Intent.EXTRA_TEXT,"share your opinion , com.example.feedback");
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                startActivity(Intent.createChooser(intent,"Select One"));
                break;

            case R.id.feedbackId:
                Intent intent1 = new Intent(MainActivity.this,FeedbackA.class);
                startActivity(intent1);
                break;


        }




        return super.onOptionsItemSelected(item);
    }
}
