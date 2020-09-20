package com.example.agendamentodeconsultri;

public class Agendamento {
    private String nomeCliente;
    private String nomeDoutor;
    private String data;
    private String hora;
    private String numero;
    private int id;

    public Agendamento(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Agendamento() {
        getNomeCliente();
        setNomeCliente(this.nomeCliente);
        return;
    }


    public  int getId(){
        return  id;


}


    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getNumero() {
        return numero;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getNomeDoutor() {
        return nomeDoutor;
    }


    /////


    public void setData(String data) {
        this.data = data;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void setNomeDoutor(String nomeDoutor) {
        this.nomeDoutor = nomeDoutor;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }


}
