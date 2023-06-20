package com.example.teatre_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void booBtn(View view){

        Intent intent = new Intent(this,    BookingActivity.class);
        startActivity(intent);

    }
    public void hamBtn(View view){

        Intent intent = new Intent(this,    HamletActivity.class);
        startActivity(intent);

    }

    public void merBtn(View view){

        Intent intent = new Intent(this,    MerchantActivity.class);
        startActivity(intent);

    }

    public void midBtn(View view){

        Intent intent = new Intent(this,    MidActivity.class);
        startActivity(intent);

    }

    public void oedBtn(View view){

        Intent intent = new Intent(this,    OedipusActivity.class);
        startActivity(intent);

    }

    public void temBtn(View view){

        Intent intent = new Intent(this,    TempestActivity.class);
        startActivity(intent);

    }
}

