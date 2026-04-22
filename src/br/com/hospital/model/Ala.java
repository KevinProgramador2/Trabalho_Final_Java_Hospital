package br.com.hospital.model;

import java.util.ArrayList;
import java.util.List;

import br.com.hospital.model.enums.StatusLeitoEnum;
import br.com.hospital.model.enums.TipoAlaEnum;

public class Ala {
    private Integer id;
    private TipoAlaEnum tipo;
    private Hospital hospital;
    private Enfermeiro responsavel;
    private List<Leito> leitos= new ArrayList<>();

    public Ala(Integer id, TipoAlaEnum tipo, Hospital hospital, Enfermeiro responsavel) {
        this.id = id;
        this.tipo = tipo;
        this.hospital= hospital;
        this.responsavel = responsavel;
    }

    @Override
    public String toString() {
        return "Ala [id=" + id + ", tipo=" + tipo + ", responsavel=" + responsavel + ", leitosDisponiveis="
                + getLeitosDisponiveis() + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoAlaEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoAlaEnum tipo) {
        this.tipo = tipo;
    }

    public Enfermeiro getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Enfermeiro responsavel) {
        this.responsavel = responsavel;
    }

    public List<Leito> getLeitos() {
        return leitos;
    }

    public void setLeitos(List<Leito> leitos) {
        this.leitos = leitos;
    }

<<<<<<< HEAD
    public void adicionarLeito(Leito leito) {
=======

    public void addLeito(Leito leito) {
>>>>>>> f61cb4486e6f5c63747563fdc9a53fb73ee94e89
        this.leitos.add(leito);
    }

    public Integer getLeitosDisponiveis() {
        int count = 0;
        for (Leito leito : leitos) {
            if (leito.getStatus() == StatusLeitoEnum.LIVRE) {
                count++;
            }
        }
<<<<<<< HEAD
        return count;
    }

}
=======

        return count;
    }
    
}
>>>>>>> f61cb4486e6f5c63747563fdc9a53fb73ee94e89
