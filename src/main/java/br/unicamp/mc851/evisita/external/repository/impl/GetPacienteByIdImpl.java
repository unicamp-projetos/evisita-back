package br.unicamp.mc851.evisita.external.repository.impl;

import br.unicamp.mc851.evisita.entity.Paciente;
import br.unicamp.mc851.evisita.external.repository.GetPacienteById;
import br.unicamp.mc851.evisita.external.repository.database.PacienteRepository;
import br.unicamp.mc851.evisita.external.repository.entity.adapter.PacienteModelAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// TODO: lançar execeção de paciente não encontrado

@Service
@RequiredArgsConstructor
public class GetPacienteByIdImpl implements GetPacienteById {

    private final PacienteRepository repository;

    @Override
    public Paciente execute(String prontuario) {
        var optionalPacienteModel = repository.findById(prontuario);
        if (optionalPacienteModel.isPresent()) {
            return PacienteModelAdapter.modelToEntity(optionalPacienteModel.get());
        }
        return null;
    }
}
