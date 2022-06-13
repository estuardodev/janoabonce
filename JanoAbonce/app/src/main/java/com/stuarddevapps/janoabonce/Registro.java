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

public class Registro extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button btn1, btn2;
    private EditText txt1, txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btn1 = findViewById(R.id.btnRegistarme);
        btn2 = findViewById(R.id.btnRegreso);
        txt1 = findViewById(R.id.txtEmail);
        txt2 = findViewById(R.id.txtPassword);
        mAuth = FirebaseAuth.getInstance();
        //llamadas
        botonRegreso();
        btnRegistrar();

    }

    private void btnRegistrar(){
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = txt1.getText().toString();
                String password = txt2.getText().toString();
                if (email.isEmpty()){
                    txt1.setError("Ingresa un correo");
                }else if (password.isEmpty()){
                    txt2.setError("Ingresa una contraseña");
                }else{
                    mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(Registro.this, "Usuario Registrado", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(Registro.this, MainActivity.class);
                                startActivity(i);
                            }else{
                                Toast.makeText(Registro.this, "Fallo al registrarte: "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }

    public void botonRegreso(){
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Registro.this, Login.class);
                startActivity(i);
            }
        });
    }

}