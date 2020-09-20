package com.example.agendamentodeconsultri;

import androidx.appcompat.app.AppCompatActivity;

import java.security.Signature;
import java.util.*;
import java.text.*;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;

import javax.xml.transform.Transformer;

public class MainActivity extends AppCompatActivity {
    EditText nome;
    EditText data;
    EditText nomeM;
    EditText numero;
    Button bt;
    Date x;
    EditText hora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receberValores2();
        hora = (EditText) findViewById(R.id.hora);
        nome = (EditText) findViewById(R.id.nome);
        data = (EditText) findViewById(R.id.data);
        nomeM = (EditText) findViewById(R.id.medico);
        numero = (EditText) findViewById(R.id.numero);
        bt = (Button) findViewById(R.id.bt);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setarData();
                setarHora();
                setarValores();
                goToNewActivity();

            }
        });

    }

        public void setarData() {
            String x1 = data.getText().toString();
            SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");
            String.format(x1, sdf1);


        }


        public void setarHora(){
            String x2 = hora.getText().toString();
            SimpleDateFormat sdf2= new SimpleDateFormat("HH:mm:ss");
            String.format(x2, sdf2);

        }

        public void setarValores(){
                nome.getText().toString();
                nomeM.getText().toString();







        }

    public void goToNewActivity() {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        Bundle b = new Bundle();
        b.putString("valor1", data.getText().toString());
        b.putString("valor2", hora.getText().toString());
        b.putString("valor3", nome.getText().toString());
        b.putString("valor4", nomeM.getText().toString());
        b.putString("valor5", numero.getText().toString());
        intent.putExtras(b);
        startActivity(intent);

        finish();

    }

    public void receberValores2() {
        Bundle b2 = getIntent().getExtras();
        if (b2 != null) {


        }
        }
}