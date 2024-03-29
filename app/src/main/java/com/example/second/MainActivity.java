package com.example.second;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.second.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "First Activity";
    //private ActivityMainBinding binding;
    Context context = MainActivity.this;
    int time = Toast.LENGTH_LONG; //длительность всплывающего окна
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
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
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SecondActivity.class);
                EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
                String name = editText.getText().toString();
                intent.putExtra("name", name);
                mStartForResult.launch(intent);
            }
        });
    }

    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Intent intent = result.getData();
                    String login = intent.getStringExtra("login");
                    Toast.makeText(context, login + ", приложение пока не готово", time).show();
                }
            }
    );
}
