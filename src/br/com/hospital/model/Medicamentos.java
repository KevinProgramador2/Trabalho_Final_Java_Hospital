package br.com.hospital.model;

import java.time.LocalDate;

public class Medicamentos {
    private Integer id;
    private String nome;
    private LocalDate data;
    private String dosagem;
    private Integer quantidade;
    
    public Medicamentos(Integer id, String nome, LocalDate data, String dosagem, Integer quantidade) {
        this.id= id;
        this.nome = nome;
        this.data = data;
        this.dosagem = dosagem;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Medicamento [id=" + id + ", nome=" + nome + ", data=" + data + ", dosagem=" + dosagem + ", quantidade=" + quantidade
                + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

}
