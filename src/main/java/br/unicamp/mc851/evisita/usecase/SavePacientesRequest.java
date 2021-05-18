package br.unicamp.mc851.evisita.usecase;

import br.unicamp.mc851.evisita.endpoint.dto.PacienteRequest;
import br.unicamp.mc851.evisita.endpoint.dto.PacienteResponse;
import br.unicamp.mc851.evisita.entity.Paciente;

public interface SavePacientesRequest {

    PacienteResponse execute(PacienteRequest pacienteRequest);

}
