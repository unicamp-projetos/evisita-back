package br.unicamp.mc851.evisita.usecase.impl;

import br.unicamp.mc851.evisita.config.exception.AcompanhanteSemPacienteException;
import br.unicamp.mc851.evisita.config.exception.PacienteNotFoundException;
import br.unicamp.mc851.evisita.endpoint.dto.AcompanhanteResponse;
import br.unicamp.mc851.evisita.endpoint.dto.CreateAcompanhanteRequest;
import br.unicamp.mc851.evisita.entity.Paciente;
import br.unicamp.mc851.evisita.external.repository.GetPacienteById;
import br.unicamp.mc851.evisita.external.repository.SaveAcompanhante;
import br.unicamp.mc851.evisita.usecase.SaveAcompanhanteRequest;
import br.unicamp.mc851.evisita.usecase.adapter.AcompanhanteAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaveAcompanhanteRequestImpl implements SaveAcompanhanteRequest {

    private final GetPacienteById getPacienteById;
    private final SaveAcompanhante saveAcompanhante;

    @Override
    public AcompanhanteResponse execute(CreateAcompanhanteRequest request)
            throws PacienteNotFoundException, AcompanhanteSemPacienteException {
        if (request.getProntuarios().isEmpty()) {
            throw new AcompanhanteSemPacienteException(request.getCpf());
        }
        List<Paciente> pacientes = new ArrayList<>();
        for (String prontuario : request.getProntuarios()) {
            pacientes.add(getPacienteById.execute(prontuario));
        }
        var acompanhante = AcompanhanteAdapter.requestToEntity(request);
        acompanhante.setPacientes(pacientes);
        return AcompanhanteAdapter.entityToResponse(saveAcompanhante.execute(acompanhante));
    }
}
