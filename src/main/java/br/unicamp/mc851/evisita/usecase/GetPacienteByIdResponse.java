package br.unicamp.mc851.evisita.usecase;

import br.unicamp.mc851.evisita.config.exception.PacienteNotFoundException;
import br.unicamp.mc851.evisita.endpoint.dto.PacienteResponse;

public interface GetPacienteByIdResponse {
    PacienteResponse execute(String prontuario) throws PacienteNotFoundException;
}
