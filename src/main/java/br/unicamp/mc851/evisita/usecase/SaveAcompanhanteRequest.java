package br.unicamp.mc851.evisita.usecase;

import br.unicamp.mc851.evisita.config.exception.AcompanhanteSemPacienteException;
import br.unicamp.mc851.evisita.config.exception.PacienteNotFoundException;
import br.unicamp.mc851.evisita.endpoint.dto.AcompanhanteResponse;
import br.unicamp.mc851.evisita.endpoint.dto.CreateAcompanhanteRequest;

public interface SaveAcompanhanteRequest {
    AcompanhanteResponse execute(CreateAcompanhanteRequest request)
            throws PacienteNotFoundException, AcompanhanteSemPacienteException;
}
