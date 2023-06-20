package com.example.teatre_app;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }


    public void registerBtn(View view)
    {
        this._checkName();
    }

    private void _checkName(){

        EditText name = findViewById(R.id.registerNameText);

        if (TextUtils.isEmpty(name.getText().toString())) {

            Toast.makeText(this, "A name must be entered", Toast.LENGTH_SHORT).show();
        }
        else{

            _checkEmail();
        }
    }
    private void _checkEmail(){

        EditText email = findViewById(R.id.registerEmailText);

        if (TextUtils.isEmpty(email.getText().toString())) {

            Toast.makeText(this, "An email must be entered", Toast.LENGTH_SHORT).show();
        }
        else{

            _checkPassword();
        }
    }

    private void _checkPassword(){

        EditText password = findViewById(R.id.registerPasswordText);

        if (TextUtils.isEmpty(password.getText().toString())) {

            Toast.makeText(this, "A password must be entered", Toast.LENGTH_SHORT).show();
        }
        else{

            _addNewUser();
        }
    }
    private void _addNewUser()
    {
        DBConnector connector = new DBConnector(this, null);

        EditText name = findViewById(R.id.registerNameText);
        EditText email = findViewById(R.id.registerEmailText);
        EditText password = findViewById(R.id.registerPasswordText);

        connector.addNewUser(name.getText().toString(), email.getText().toString(), password.getText().toString());

        Toast.makeText(this, "Account Created", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}