package com.teamx.farmily;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;;

public class SignIn extends AppCompatActivity {
    EditText email2, password2;
    Button btnLogin;
    TextView tvSignup, fPwd;
    FirebaseAuth loginAuth;
    String email, password;
    RadioGroup radioGroup;
    //FirebaseAuth mfirebaseAuth;
    //private  FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        email2 = (EditText) findViewById(R.id.editTextTextEmailAddress);
        password2 = findViewById(R.id.editTextTextPassword);
        btnLogin = findViewById(R.id.button);
        tvSignup = findViewById(R.id.textView12);
        fPwd = findViewById(R.id.textView10);
        initView();
        addClickListener();
        initView();
    }

    private void initView(){
        loginAuth=FirebaseAuth.getInstance();
    }
    private void addClickListener(){
        // Add the Listener to the RadioGroup
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValid())
                    login();
            }
        });
        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signupIntent=new Intent(SignIn.this,SignUp.class);
                startActivity(signupIntent);
            }
        });
    }
    private boolean isValid(){
        boolean isValid=false;

        email = email2.getText().toString();
        password = password2.getText().toString();

        if (TextUtils.isEmpty(email)) {
            email2.setError("Please enter email");
            email2.requestFocus();
        }
        else if (TextUtils.isEmpty(password)) {
            password2.setError("Please enter your password");
            password2.requestFocus();
        }
        else
            isValid=true;
        return isValid;
    }
    private void login(){
        loginAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(SignIn.this, "Login Succesful", Toast.LENGTH_SHORT).show();
                    Intent mainIntent=new Intent(SignIn.this,MainActivity.class);
                    startActivity(mainIntent);
                };
            }
        });
    }


}