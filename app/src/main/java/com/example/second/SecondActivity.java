package com.example.second;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.second.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle arguments = getIntent().getExtras();
        String name = arguments.get("name").toString();
        TextView textView8 = (TextView) findViewById(R.id.textView8);
        textView8.setText("Здравствуйте, " + name + "!");
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                EditText loginEditText = (EditText) findViewById(R.id.editTextLogin); //поле ввода логина
                String login = loginEditText.getText().toString();
                intent.putExtra("login", login);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}