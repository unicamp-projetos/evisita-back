package br.unicamp.mc851.evisita.usecase.impl;

import br.unicamp.mc851.evisita.endpoint.dto.AcompanhanteResponse;
import br.unicamp.mc851.evisita.endpoint.dto.CreateAcompanhanteRequest;
import br.unicamp.mc851.evisita.entity.Paciente;
import br.unicamp.mc851.evisita.external.repository.GetPacienteById;
import br.unicamp.mc851.evisita.usecase.SaveAcompanhante;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// TODO: verificar se paciente existe
// TODO: novo método no adapter para conversão de CreateAcompanhanteRequest

@Service
@RequiredArgsConstructor
public class SaveAcompanhanteImpl implements SaveAcompanhante {

    private final GetPacienteById getPacienteById;

    @Override
    public AcompanhanteResponse execute(CreateAcompanhanteRequest request) {
        List<Paciente> pacientes = new ArrayList<>();
        request.getProntuarios().forEach(prontuario -> {
            pacientes.add(getPacienteById.execute(prontuario));
        });
        return null;
    }
}
