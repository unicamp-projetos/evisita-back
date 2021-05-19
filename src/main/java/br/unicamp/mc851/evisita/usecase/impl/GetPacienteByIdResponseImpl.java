package br.unicamp.mc851.evisita.usecase.impl;

import br.unicamp.mc851.evisita.config.exception.PacienteNotFoundException;
import br.unicamp.mc851.evisita.endpoint.dto.PacienteResponse;
import br.unicamp.mc851.evisita.external.repository.GetPacienteById;
import br.unicamp.mc851.evisita.usecase.GetPacienteByIdResponse;
import br.unicamp.mc851.evisita.usecase.adapter.PacienteAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetPacienteByIdResponseImpl implements GetPacienteByIdResponse {

    private final GetPacienteById getPacienteById;

    @Override
    public PacienteResponse execute(String prontuario) throws PacienteNotFoundException {
        var paciente = getPacienteById.execute(prontuario);
        return PacienteAdapter.entityToResponse(paciente);
    }
}
