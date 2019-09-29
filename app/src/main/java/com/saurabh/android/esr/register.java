package com.saurabh.android.esr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText number;
    Button submit;
    User user;
    DatabaseReference dbref;
    FirebaseUser mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = bindUser();
                submitDataToFb(user);
            }
        });

    }

    void init(){
        name = (EditText)findViewById(R.id.name);
        email = (EditText)findViewById(R.id.email);
        number = (EditText)findViewById(R.id.number);
        submit = (Button)findViewById(R.id.submit);
        mAuth = FirebaseAuth.getInstance().getCurrentUser();
    }

    User bindUser(){
        String n = name.getText().toString();
        String e = email.getText().toString();
        String num = number.getText().toString();

        User user1 = new User(n,e,0.0,0.0,25.0,num);

        return user1;
    }

    void submitDataToFb(User u){
        String uid = mAuth.getUid();
        dbref = FirebaseDatabase.getInstance().getReference("users");
        dbref.child(uid).setValue(u);
        startActivity(new Intent(register.this,helpScreen.class));
    }
}
