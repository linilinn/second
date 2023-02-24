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

import com.example.second.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {
    Context context2 = SecondActivity.this;
    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle arguments = getIntent().getExtras();
        initIt();
    }
    private void initIt() {
        Bundle argument = getIntent().getExtras();
        String name = argument.get("name").toString();
        TextView textView8 = (TextView) findViewById(R.id.textView8);
        textView8.setText("Здравствуйте, " + name + "!");
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener( view -> {
            Intent intent = new Intent();
            EditText loginEditText = (EditText) findViewById(R.id.editTextLogin); //поле ввода логина
            String login = loginEditText.getText().toString();
            intent.putExtra("resultText", login);
            setResult(Activity.RESULT_OK, intent);
            finish();
        });
    }
}