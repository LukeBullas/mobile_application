package com.example.teatre_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MerchantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant);
    }

    public void backBtn(View view){

        Intent intent = new Intent(this,    MainActivity.class);
        startActivity(intent);

    }
}