package com.teamscam.localhub.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.teamscam.localhub.MainActivity;
import com.teamscam.localhub.R;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class LoginActivity extends AppCompatActivity {
    public static final String NAME = "com.scam.localhub.MESSAGE";
    EditText et1;
    EditText et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SharedPreferences editor = getSharedPreferences("LocalHub10", MODE_PRIVATE);
        String name=editor.getString("name","");
        if(!name.equalsIgnoreCase(""))
        {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }

        Button button = findViewById(R.id.login_button);
        et1=findViewById(R.id.login_name);
        et2=findViewById(R.id.login_number);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String name=et1.getText().toString();
                String number=et2.getText().toString();
                if(TextUtils.isEmpty(name) || TextUtils.isEmpty(number))
                {
                    if(TextUtils.isEmpty(name))
                        et1.setError("Required");
                    if(TextUtils.isEmpty(number))
                        et2.setError("Required");
                    //Toast.makeText(LoginActivity.this, "Enter Valid Input", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    SharedPreferences.Editor editor = getSharedPreferences("LocalHub10", MODE_PRIVATE).edit();
                    editor.putString("name",name);
                    editor.putString("number",number);
                    editor.apply();
                    startActivity(intent);
                }

            }
        });
        Button btn=findViewById(R.id.signup_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivityLog.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }
}
