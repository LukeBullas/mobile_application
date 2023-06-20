package com.example.teatre_app;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView text = findViewById(R.id.registerLink);
        SpannableString spannableString = new SpannableString(text.getText());
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        };
        spannableString.setSpan(clickableSpan, 0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text.setText(spannableString);
        text.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void loginBtn(View view) {
        _checkEmail();
    }

    private void _checkEmail(){

        EditText email = findViewById(R.id.loginEmailText);

        if (TextUtils.isEmpty(email.getText().toString())) {

            Toast.makeText(this, "An email must be entered", Toast.LENGTH_SHORT).show();
        }
        else{

            _checkPassword();
        }
    }

    private void _checkPassword(){

        EditText password = findViewById(R.id.loginPasswordText);

        if (TextUtils.isEmpty(password.getText().toString())) {

            Toast.makeText(this, "A password must be entered", Toast.LENGTH_SHORT).show();
        }
        else{

            _checkUser();
        }
    }



    private void _checkUser() {
        DBConnector connector = new DBConnector(this, null);

        EditText username = findViewById(R.id.loginEmailText);
        EditText password = findViewById(R.id.loginPasswordText);



        boolean success = connector.checkLogin(username.getText().toString(), password.getText().toString());
        if (success) {
            Toast.makeText(this, "Logged in successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,    MainActivity.class);
            startActivity(intent);
        }
        else
            Toast.makeText(this, "Username or password not recognised", Toast.LENGTH_SHORT).show();
    }

}