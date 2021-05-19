package br.unicamp.mc851.evisita.usecase;

import br.unicamp.mc851.evisita.config.exception.AcompanhanteNotFoundException;
import br.unicamp.mc851.evisita.endpoint.dto.AcompanhanteResponse;

public interface GetAcompanhanteByIdResponse {
    AcompanhanteResponse execute(String cpf) throws AcompanhanteNotFoundException;
}
