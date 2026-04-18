package br.com.hospital.model;

import java.time.LocalDate;

public class Paciente extends Pessoa {

    public Paciente(String nome, String cpf, String telefone, String endereco, LocalDate dataNascimento) {
        super(nome, cpf, telefone, endereco, dataNascimento);
    }

}
