package com.example.lab_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edUser, edPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edUser = findViewById(R.id.edUser);
        edPass = findViewById(R.id.edPass);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass = edPass.getText().toString();
                String userName = edUser.getText().toString();
                if(checkUserName(userName) == true && checkPass(pass) == true && pass.length() >= 6){
                    Intent intent = new Intent(getBaseContext(),CreateNewNote.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getBaseContext(),"Đăng nhập không thành công",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public boolean checkUserName (String user){
        if(user.compareToIgnoreCase("admin") == 0){
            return true;
        }else{
            return false;
        }
    }
    public boolean checkPass(String pass){
        String str = "qwertyuioplkjhgfdsazxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM";
        String so = "1234567890";
        String kiTu = "!@#$%^&*";
        boolean check = false;
        for(int i = 0;i < pass.length() ; i++){
            if(str.indexOf(pass.charAt(i)) != -1){
                check = true;
                break;
            }
        }for(int i = 0;i < pass.length() ; i++){
            if(so.indexOf(pass.charAt(i)) != -1){
                check = true;
                break;
            }
        }for(int i = 0;i < pass.length() ; i++){
            if(kiTu.indexOf(pass.charAt(i)) != -1){
                check = true;
                break;
            }
        }
       return check;
    }
}
