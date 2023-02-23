package com.example.second;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "First Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button); //кнопка Далее
        button.setText(R.string.next);
        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName); //поле ввода имени
        editText.setText(R.string.user_name);
        TextView appTextView = (TextView) findViewById(R.id.textView); //Mobile Waiter
        appTextView.setText(R.string.app_name);
        TextView restaurant_appTextView = (TextView) findViewById(R.id.textView2); //Приложение для ресторанов
        restaurant_appTextView.setText(R.string.app_for);
        TextView usernameTextView = (TextView) findViewById(R.id.textView3); //Как к вам можно обращаться?
        usernameTextView.setText(R.string.start_screen);
        ImageView myImage = (ImageView) findViewById(R.id.imageView3); //картинка еды на стартовом экране
        myImage.setImageResource(R.drawable.start_food);

    }

    public void onClick(View v) {
        Log.i(TAG, "Button clicked");
    }
}
