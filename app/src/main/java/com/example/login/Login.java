package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText login, pass;
    Intent i;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void fazLogin(View v){
        String log, senha;
        login = findViewById(R.id.loginctxlogin);
        log = login.getText().toString();
        pass=findViewById(R.id.loginctxpass);
        senha=pass.getText().toString();
        if(log.isEmpty()||senha.isEmpty()){
            Toast.makeText(this, "Preecha os campos de login", Toast.LENGTH_SHORT).show();
        }
        else {
            //fazer validação na base de dados
            db= new DBHelper(this);
            if (db.veriicaLogin(log,senha)>0){
                i = new Intent(Login.this, MostraUtilizadores.class);
                startActivity(i);
                //Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    public void  fazRegistro(View v){
        i=new Intent(Login.this,Registro.class);
        startActivity(i);
        finish();
    }
}