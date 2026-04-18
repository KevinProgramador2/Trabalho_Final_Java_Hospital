package br.com.hospital.model;

import java.time.LocalDate;

public class Enfermeiro extends Pessoa {

    public Enfermeiro(String nome, String cpf, String telefone, String endereco, LocalDate dataNascimento) {
        super(nome, cpf, telefone, endereco, dataNascimento);
    }

}
