package com.stuarddevapps.janoabonce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    private FirebaseAuth mAuth;

    EditText email;
    EditText pass;
    Button btnLogin, btnRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        //Declaraciones
        email = findViewById(R.id.txtEmail);
        pass = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRes = findViewById(R.id.registerBtn);

        //llamadas
        botonRegistro();
        iniciarsesion();

    }

    public void botonRegistro(){
        btnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Login.this, Registro.class);
                startActivity(i);
            }
        });
    }


    private void iniciarsesion(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = email.getText().toString();
                String password = pass.getText().toString();
                if (user.isEmpty()){
                    email.setError("Ingresa un correo");
                }else if (password.isEmpty()){
                    pass.setError("Ingresa una contraseña");
                }else{
                    mAuth.signInWithEmailAndPassword(user, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(Login.this,"",Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(Login.this, MainActivity.class);
                                startActivity(i);
                            }else{
                                Toast.makeText(Login.this,"Fallo al iniciar sesion: "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }

}