package br.unicamp.mc851.evisita.usecase;

import br.unicamp.mc851.evisita.endpoint.dto.PacienteResponse;

import java.util.List;

public interface GetPacientesResponse {
    List<PacienteResponse> execute();
}
