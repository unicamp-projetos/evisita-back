package br.unicamp.mc851.evisita.usecase.impl;

import br.unicamp.mc851.evisita.endpoint.dto.PacienteResponse;
import br.unicamp.mc851.evisita.external.repository.GetPacientes;
import br.unicamp.mc851.evisita.usecase.GetPacientesResponse;
import br.unicamp.mc851.evisita.usecase.adapter.PacienteAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetPacientesResponseImpl implements GetPacientesResponse {

    private final GetPacientes getPacientes;

    @Override
    public List<PacienteResponse> execute() {
        var pacientes = getPacientes.execute();
        return pacientes.stream()
                .map(PacienteAdapter::entityToResponse)
                .collect(Collectors.toList());
    }
}
