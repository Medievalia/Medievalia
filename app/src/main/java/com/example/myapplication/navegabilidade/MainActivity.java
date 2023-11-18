package com.example.myapplication.navegabilidade;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.myapplication.R;
import com.example.myapplication.database.MySQLConnection;

import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            //conectar com o banco
            MySQLConnection.conectar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        AppCompatButton tenhoUmaConta =  findViewById(R.id.tenho_uma_conta);
        tenhoUmaConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });

        AppCompatButton comeceAgora =  findViewById(R.id.comece_agora);
        comeceAgora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ComeceAgora.class);
                startActivity(intent);
            }
        });
    }
}
