package br.unicamp.mc851.evisita.external.repository.impl;

import br.unicamp.mc851.evisita.entity.Paciente;
import br.unicamp.mc851.evisita.external.repository.SavePacientes;
import br.unicamp.mc851.evisita.external.repository.database.PacienteRepository;
import br.unicamp.mc851.evisita.external.repository.entity.adapter.PacienteModelAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SavePacientesImpl implements SavePacientes {

    private final PacienteRepository pacienteRepository;

    public Paciente execute(Paciente paciente) {
        var model = PacienteModelAdapter.entityToModel(paciente);
        return PacienteModelAdapter.modelToEntity(pacienteRepository.save(model));
    }

}
