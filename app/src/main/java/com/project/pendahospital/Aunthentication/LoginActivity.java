package com.project.pendahospital.Aunthentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.project.pendahospital.Admin.DoctorsHomeActivity;
import com.project.pendahospital.Activities.PasswordActivity;
import com.project.pendahospital.Patient.MainActivity;
import com.project.pendahospital.R;

public class LoginActivity extends AppCompatActivity {
    CheckBox admin;
    private ProgressBar progressBar;
    private EditText EditTextEmail,editTextPassword;
    private FirebaseAuth mAuth;
    private Button login;
    boolean passwordVisible;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        admin = findViewById(R.id.radioButton);
        mAuth = FirebaseAuth.getInstance();
        EditTextEmail = findViewById(R.id.editText2);
        editTextPassword = findViewById(R.id.editText3);
        progressBar = findViewById(R.id.progressBar);

        editTextPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right=2;
                if (event.getAction()==MotionEvent.ACTION_UP){
                    if (event.getRawX()>=editTextPassword.getRight()-editTextPassword.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=editTextPassword.getSelectionEnd();
                        if (passwordVisible){
                            //show password
                            editTextPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.visibility_off_24,0);
                            //hide password
                            editTextPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;

                        }else {
                            //show password
                            editTextPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.visibility_24,0);
                            //show password
                            editTextPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;

                        }
                        editTextPassword.setSelection(selection);
                        return  true;

                    }
                }
                return false;
            }
        });
    }
    public void login(View view) {
        if (admin.isChecked()){
            String email1 =EditTextEmail.getText().toString().trim();
            String password1 =editTextPassword.getText().toString().trim();
            if (email1.isEmpty()){
                EditTextEmail.setError(" email is required!!");
                EditTextEmail.requestFocus();
                return;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email1).matches()){
                EditTextEmail.setError("Please provide a valid email address!");
                EditTextEmail.requestFocus();
                return;
            }
            if (password1.isEmpty()){
                editTextPassword.setError(" password is required!!");
                editTextPassword.requestFocus();
                return;
            }
            progressBar.setVisibility(View.VISIBLE);
            if ("admin@gmail.com".equals(email1) && "admin1234".equals(password1)){
                startActivity(new Intent(LoginActivity.this, DoctorsHomeActivity.class));
                Toast.makeText(LoginActivity.this,"Admin Logged in successfully ",Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(LoginActivity.this,"Failed to log in check your details ",Toast.LENGTH_SHORT).show();
            }
            progressBar.setVisibility(View.GONE);
        }else
            login2();
    }
    public void login2() {
        String email =EditTextEmail.getText().toString().trim();
        String password =editTextPassword.getText().toString().trim();

        if (email.isEmpty()){
            EditTextEmail.setError(" email is required!!");
            EditTextEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            EditTextEmail.setError("Please provide a valid email address!");
            EditTextEmail.requestFocus();
            return;
        }
        if (password.isEmpty()){
            editTextPassword.setError(" password is required!!");
            editTextPassword.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                    Toast.makeText(LoginActivity.this,"Logged in successfully",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LoginActivity.this,"Failed to log in check your credentials and Internet connection",Toast.LENGTH_SHORT).show();
                }
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    public void sign_Up(View view) {
        startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
        finish();
    }

    public void password(View view) {
        startActivity(new Intent(LoginActivity.this, PasswordActivity.class));
    }
}