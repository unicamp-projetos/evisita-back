package br.unicamp.mc851.evisita.usecase.impl;

import br.unicamp.mc851.evisita.endpoint.dto.PacienteRequest;
import br.unicamp.mc851.evisita.endpoint.dto.PacienteResponse;
import br.unicamp.mc851.evisita.external.repository.SavePacientes;
import br.unicamp.mc851.evisita.usecase.SavePacientesRequest;
import br.unicamp.mc851.evisita.usecase.adapter.PacienteAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SavePacientesRequestImpl implements SavePacientesRequest {

    private final SavePacientes savePacientes;

    public PacienteResponse execute(PacienteRequest pacienteRequest) {
        var paciente = savePacientes.execute(PacienteAdapter.requestToEntity(pacienteRequest));
        return PacienteAdapter.entityToResponse(paciente);
    }
}
