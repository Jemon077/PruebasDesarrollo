package com.example.damn_tiendaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.damn_tiendaapp.DB.DBHelper;
import com.example.damn_tiendaapp.DB.DBUsers;

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

        // Crear una instancia de DBHelper para administrar la base de datos
        DBHelper dbHelper = new DBHelper(MainActivity.this);
        // Obtener una instancia de la base de datos en modo escritura
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        /*if (dbHelper != null) {
            // Mostrar un mensaje en un Toast indicando que la base de datos se ha creado correctamente
            Toast.makeText(MainActivity.this, "BASE DE DATOS CREADA", Toast.LENGTH_LONG).show();
            // Registrar un mensaje en el registro de Logcat con información importante (comentado en este caso)
            //Log.i(TAG, "BASE DE DATOS CREADA");
        } else {
            // Mostrar un mensaje en un Toast indicando que ha ocurrido un error al crear la base de datos
            Toast.makeText(MainActivity.this, "ERROR AL CREAR LA BASE DE DATOS", Toast.LENGTH_LONG).show();
            // Registrar un mensaje en el registro de Logcat con información de error (comentado en este caso)
            //Log.i(TAG, "ERROR AL CREAR LA BASE DE DATOS");
        }*/

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                //Validar Usuario y contraseña para ingresar
                boolean u = searchUser(user, password);
                if (u){
                    //Si cumple las condiciones se permite acceso y se dirige a la activity ProductsList
                    Intent intentLogin = new Intent(MainActivity.this, ProductsList.class);
                    startActivity(intentLogin);
                    Toast.makeText(MainActivity.this, "ACCESO AUTORIZADO", Toast.LENGTH_LONG).show();
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

    private boolean searchUser(String userName, String pass){
        DBUsers dbUser = new DBUsers(MainActivity.this);
        boolean r = dbUser.validateUser(userName, pass);
        return r;
    }
}