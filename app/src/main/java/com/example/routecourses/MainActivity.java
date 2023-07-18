package com.example.routecourses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnClick(View view){
        if (view instanceof Button){
            String courseName = ((Button) view).getText().toString();
            Intent intent = new Intent(MainActivity.this, ContentActivity.class);
            intent.putExtra("course name",courseName);
            startActivity(intent);
        }
    }
}