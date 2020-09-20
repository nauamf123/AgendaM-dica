package com.example.agendamentodeconsultri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ListView lista;
    String data;
    String hora;
    String nome;
    String nomeM;
    String numero;
    Button btv;
    SearchView filtro;
    AgendaAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        filtro = (SearchView) findViewById(R.id.filtro);
        receberValores();

        final ArrayList<Agendamento> agendamentos = new ArrayList<>();

        Agendamento agendamento = new Agendamento();
        agendamento.setNumero(numero);
        agendamento.setData(data);
        agendamento.setHora(hora);
        agendamento.setNomeCliente(nome);
        agendamento.setNomeDoutor(nomeM);

        agendamentos.add(agendamento);

        lista = (ListView) findViewById(R.id.lv);
        lista.setAdapter( new AgendaAdapter(this, agendamentos));



        filtro.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                adapter.getFilter().filter(s);
                return false;
            }
        });



    }




    public void receberValores() {
        Bundle b = getIntent().getExtras();
        if (b != null) {
            data = b.getString("valor1");
            hora = b.getString("valor2");
            nome = b.getString("valor3");
            nomeM = b.getString("valor4");
            numero = b.getString("valor5");


        }




    }

        public  void voltar(){
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            Bundle b2 = new Bundle();

            intent.putExtras(b2);
            startActivity(intent);

            finish();

        }
}