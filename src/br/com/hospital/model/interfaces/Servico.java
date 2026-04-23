package br.com.hospital.model.interfaces;

import br.com.hospital.model.enums.TipoServicoEnum;

public interface Servico {
    Integer getIdentificador();
    TipoServicoEnum getTipoServico();
}