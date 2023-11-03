package com.example.damn_tiendaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView registerLink;
    private Button newAccountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asociar elementos de la interfaz de usuario con variables
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_button);
        newAccountButton = findViewById(R.id.login_newAccount);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                //Validar Usuario y contraseña para ingresar
                if (user.equals("admin") && password.equals("2468")){
                    //Si cumple las condiciones se permite acceso y se dirige a la activity ProductsList
                    Intent intentLogin = new Intent(MainActivity.this, ProductsList.class);
                    startActivity(intentLogin);
                    //Toast.makeText(MainActivity.this, "ACCESO AUTORIZADO", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "CREDENCIALES ERRONEAS", Toast.LENGTH_LONG).show();
                }
            }
        });


        newAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRegister = new Intent(MainActivity.this,RegisterNewAccount.class);
                startActivity(intentRegister);
            }
        });

    }
}