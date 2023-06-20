package com.example.teatre_app;

import androidx.appcompat.app.AppCompatActivity;

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

public class TestActivity extends AppCompatActivity {

    public void loginBtn(View view) {
        _emailPassword();
    }

   private void _emailPassword(){

       EditText username = findViewById(R.id.loginEmailText2);

       if (TextUtils.isEmpty(username.getText().toString())) {

           Toast.makeText(this, "An email is required to continue", Toast.LENGTH_SHORT).show();
       }
       else{

           _checkUser();
       }
   }

    private void _checkUser() {
        DBConnector connector = new DBConnector(this, null);

        EditText username = findViewById(R.id.loginEmailText2);
        EditText password = findViewById(R.id.loginPasswordText2);


        boolean success = connector.checkLogin(username.getText().toString(), password.getText().toString());
        if (success) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else
            Toast.makeText(this, "Username or password not recognised", Toast.LENGTH_SHORT).show();
    }
}
