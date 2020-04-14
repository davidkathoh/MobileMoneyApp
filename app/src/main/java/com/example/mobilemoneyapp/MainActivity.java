package com.example.mobilemoneyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hover.sdk.api.Hover;
import com.hover.sdk.api.HoverParameters;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Hover.initialize(this);

        final EditText numero = findViewById(R.id.edNumber);
        final EditText montant = findViewById(R.id.edMontant);
        Button envoi = findViewById(R.id.btnSend);
        envoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new HoverParameters.Builder(getApplicationContext())
                        .request("ID de votre action")
                        .extra("numero",numero.getText().toString())
                        .extra("montant", montant.getText().toString())
                        .buildIntent();
                startActivityForResult(i,3);
            }
        });


    }
}
