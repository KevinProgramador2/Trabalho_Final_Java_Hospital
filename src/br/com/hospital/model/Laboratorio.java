package br.com.hospital.model;

import br.com.hospital.model.enums.TipoLaboratorioEnum;

public class Laboratorio {
    private Integer id;
    private String nome;
    private TipoLaboratorioEnum tipo;


    public Laboratorio(Integer id, String nome, TipoLaboratorioEnum tipo) {
        this.id= id;
 
        this.nome = nome;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Laboratorio [id=" + id + ", nome=" + nome + ", tipo=" + tipo + "]";
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

    public TipoLaboratorioEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoLaboratorioEnum tipo) {
        this.tipo = tipo;
    }

}
