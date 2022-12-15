package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    EditText login, pass,repass,email;
    Intent i;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }
    public void fazRegistro(View v){
        String log,mail, senha,resenha;
        login=findViewById(R.id.registroctxlogin);
        log=login.getText().toString();
        email=findViewById(R.id.regitroctxemail);
        mail=email.getText().toString();
        pass=findViewById(R.id.registroctxpass);
        senha=pass.getText().toString();
        repass=findViewById(R.id.registrotxrepass);
        resenha=repass.getText().toString();
        if(log.isEmpty()||mail.isEmpty()||senha.isEmpty()|| resenha.isEmpty()){
            Toast.makeText(this, "Preecha os campos de login", Toast.LENGTH_SHORT).show();
        }else if (!senha.equals(resenha)){
            Toast.makeText(this, "Os campos password têm de coincidir", Toast.LENGTH_SHORT).show();
        }
        else {
            //fazer validação na base de dados
            db=new DBHelper(this);
            long res = db.insert(log,mail,senha);
            if (res>0){
                Toast.makeText(this, "Registro inserido com sucesso", Toast.LENGTH_SHORT).show();
                login.setText("");
                email.setText("");
                pass.setText("");
                repass.setText("");
            }else {
                Toast.makeText(this, "Não foi possível registrar dados", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void  Voltar(View v){
        i=new Intent(Registro.this,Login.class);
        startActivity(i);
        finish();
    }
}