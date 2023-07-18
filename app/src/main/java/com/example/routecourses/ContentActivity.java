package com.example.routecourses;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
public class ContentActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        imageView = findViewById(R.id.iv_course);
        textView = findViewById(R.id.tv_content);
        String courseName = getIntent().getStringExtra("course name");
        setImage(courseName);
        setContentFromTextFile(courseName);
    }

    void setImage(String courseName){
        if (courseName.equals("Android Course")){
            imageView.setImageResource(R.drawable.android);
        } else if (courseName.equals("IOS Course")){
            imageView.setImageResource(R.drawable.ios);
        }else {
            imageView.setImageResource(R.drawable.full_stack);
        }
    }

    public void setContentFromTextFile(String courseName) {
        String string;
        StringBuilder stringBuilder = new StringBuilder();
        InputStream inputStream = this.getResources().openRawResource(R.raw.read);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            boolean readFlag =false;
            while (true) {
                try {
                    if ((string = reader.readLine()) == null) {
                        break;
                    }else{
                        if (courseName.equals("Android Course")) {
                            if (string.equals("content Adroid  >>>>>")) {
                                readFlag = true;
                            } else if (string.equals("Content Full Stack >>>>>")) {
                                readFlag = false;
                                break;
                            }
                        }else if (courseName.equals("IOS Course")){
                            if (string.equals("Content IOS  >>>>>")) {
                                readFlag = true;
                            }
                        }else {
                            if (string.equals("Content Full Stack >>>>>")) {
                                readFlag = true;
                            } else if (string.equals("Content IOS  >>>>>")) {
                                readFlag = false;
                                break;
                            }
                        }
                        if (readFlag) {
                            stringBuilder.append(string).append("\n");
                            textView.setText(stringBuilder);
                        }
                    }

                }
                catch (IOException e) {
                    e.printStackTrace();
                }

            }
            inputStream.close();
        }catch (Exception e){
            Log.e("error",e.getMessage());
        }

    }
}