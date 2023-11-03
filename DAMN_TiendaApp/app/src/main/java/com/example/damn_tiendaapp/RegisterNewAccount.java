package com.example.damn_tiendaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterNewAccount extends AppCompatActivity {

    private Button registerCancelCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_new_account);

        registerCancelCreate = findViewById(R.id.register_CancelCreate);

        registerCancelCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRegresar = new Intent(RegisterNewAccount.this,MainActivity.class);
                startActivity(intentRegresar);
            }
        });



    }
}