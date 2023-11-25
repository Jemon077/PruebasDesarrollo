package com.example.damn_tiendaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.damn_tiendaapp.DB.DBProduct;
import com.example.damn_tiendaapp.DB.DBUsers;
import com.example.damn_tiendaapp.Entidades.Users;

public class RegisterNewAccount extends AppCompatActivity {

    private Button registerCancelCreate;
    private Button registerNewAccount;
    private EditText name;
    private EditText sureName;
    private EditText userName;
    private EditText email;
    private EditText cellphone;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_new_account);

        registerCancelCreate = findViewById(R.id.register_CancelCreate);
        registerNewAccount = findViewById(R.id.register_CreateAccount);
        name = findViewById(R.id.nameUser);
        sureName = findViewById(R.id.surnameUser);
        userName = findViewById(R.id.userName);
        email = findViewById(R.id.emailUser);
        cellphone = findViewById(R.id.telephoneUser);
        password = findViewById(R.id.passwordUser);

        registerCancelCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnActivity();
            }
        });


        registerNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Users u = new Users(name.getText().toString(), sureName.getText().toString(), userName.getText().toString(), email.getText().toString(), cellphone.getText().toString(), password.getText().toString());
                newAccount(u);
                returnActivity();
            }
        });



    }

    private void newAccount(Users u){
        DBUsers dbUser = new DBUsers(RegisterNewAccount.this);
        long r = dbUser.createUser(u.getName().toString(), u.getSurename().toString(), u.getUserName().toString(), u.getEmail().toString(), u.getCellphone().toString(), u.getPassword().toString());
        if (r > 0){
            Toast.makeText(RegisterNewAccount.this, "USUARIO CREADO", Toast.LENGTH_LONG).show();
            clearForm();
        }else{
            Toast.makeText(RegisterNewAccount.this, "ERROR AL CREAR. INTENTE DE NUEVO", Toast.LENGTH_LONG).show();
        }
    }

    private void clearForm(){
        name.setText("");
        sureName.setText("");
        userName.setText("");
        email.setText("");
        cellphone.setText("");
        password.setText("");
    }

    private void returnActivity (){
        Intent intentRegresar = new Intent(RegisterNewAccount.this,MainActivity.class);
        startActivity(intentRegresar);
    }
}