package br.unicamp.mc851.evisita.external.repository;

import br.unicamp.mc851.evisita.config.exception.AcompanhanteNotFoundException;
import br.unicamp.mc851.evisita.entity.Acompanhante;

public interface GetAcompanhanteById {
    Acompanhante execute(String cpf) throws AcompanhanteNotFoundException;
}
