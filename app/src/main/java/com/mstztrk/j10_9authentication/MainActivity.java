package com.mstztrk.j10_9authentication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText txtEmail, txtPassword;
    Button btnRegister;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtEmail = (EditText) findViewById(R.id.reg_txtEmail);
        txtPassword = (EditText) findViewById(R.id.reg_txtPassword);
        btnRegister = (Button) findViewById(R.id.reg_btnKayitOl);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth = FirebaseAuth.getInstance();
                mAuth.createUserWithEmailAndPassword(txtEmail.getText().toString(), txtPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Tebrikler kayıt oldunuz", Toast.LENGTH_SHORT).show();
                            //Login sayfasına yönlendirme
                            
                        }else{
                            Toast.makeText(MainActivity.this, "Kayıt işleminde bir hata oluştu", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
