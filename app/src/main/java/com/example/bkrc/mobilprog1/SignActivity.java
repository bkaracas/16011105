package com.example.bkrc.mobilprog1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SignActivity extends Activity {


    Button signIn;
    EditText editTextName, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        editTextName=(EditText)findViewById(R.id.editTextName);
        editTextPassword=(EditText)findViewById(R.id.editTextPassword);
        signIn=(Button)findViewById(R.id.SignIn);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((editTextName.getText().toString().equals("admin"))&&(editTextPassword.getText().toString().equals("password"))){
                    Intent i =new Intent(SignActivity.this,MainActivity.class);
                    startActivity(i);
                }else {
                    Toast.makeText(SignActivity.this, "Kullanıcı adı ya da parola yanlış", Toast.LENGTH_SHORT).show();
                    editTextName.setText("");
                    editTextPassword.setText("");
                }
            }
        });
    }

}